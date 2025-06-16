package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.VO.DeptVO;
import pm.VO.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpFrame extends JFrame{

    JPanel north_p;
    JLabel start_label,end_label;
    JTextField start_jt,end_jt;
    JButton btn;
    JTable table;
    String[] c_name = {"사번","이름","입사일","급여","부서명"};
    String[][] data;
    SqlSessionFactory factory;
    String start,end;
    List<EmpVO> list;
    List<DeptVO> depts;
    int clicked_idx;
    JCheckBox[] chk_ar;


    public EmpFrame() {

        north_p = new JPanel();
        start_label = new JLabel("부서검색 : ");
        start_jt = new JTextField(5);

        btn = new JButton("조회");
        north_p.add(start_label);
//        north_p.add(start_jt);\
        init();

        north_p.add(btn);
        this.add(north_p,"North");

        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data, c_name));

        this.setBounds(300,300,600,400);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });



        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> dept_list = new ArrayList<>();  // 부서번호를 담을 ArrayList
                for (JCheckBox box : chk_ar) {  // 체크박스 배열에서
                    if (box.isSelected()) { // 체크박스가 선택되었으면
                            String str = box.getText();

                        //str을 depts라는 List에서 DeptVO를 대상으로 찾아낸다.
                        //부서코드를 dept_list에 추가한다.
                        for (DeptVO dvo : depts) { // 부서목록에서
                            if (dvo.getDname().equalsIgnoreCase(str)) {
                                //선택된 체크박스의 부서번호를 알아내자
                                dept_list.add(dvo.getDeptno()); // 부서번호를 ArrayList에 추가
                                break; // 해당 부서번호를 찾았으면 반복문을 빠져나온다.
                            }
                        }//for의 끝
                    }
                }//for의 끝
//                System.out.println(dept_list);
                Map<String,ArrayList<String>> map = new HashMap<>();
                map.put("dept_list", dept_list); // 부서번호 리스트를 맵에 추가

                SqlSession ss = factory.openSession();
                list = ss.selectList("emp.search_deptno", map);
                viewTable(list);
                ss.close();

            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //테이블에서 더블클릭을 알아내자
                int cnt = e.getClickCount();
                if(cnt == 2){
                    //Jtable에 선택된 행, index를 알아내자
                    clicked_idx = table.getSelectedRow();
                    //위의 i는 list의 접근하기위한 index이다.
                    EmpVO vo = list.get(clicked_idx);
                    MyDialog md = new MyDialog(EmpFrame.this, true , vo);
                }
            }
        });

    }

    private void search(String start, String end) {
        SqlSession ss = factory.openSession();
            // Assuming you have a mapper method named 'selectEmpByDateRange'
        if(start.length()>0 && end.length()>0) {
            Map<String, String> params = new HashMap<>();
            params.put("startDate", start);
            params.put("endDate", end);
            list = ss.selectList("emp.select", params);
            viewTable(list);
        }else
            JOptionPane.showMessageDialog(EmpFrame.this,"날짜를 모두 입력하세요");
        ss.close();
    }
    private void viewTable(List<EmpVO> list){
        String[][] data = new String[list.size()][c_name.length];
        for(int i=0; i<list.size(); i++){
            EmpVO vo = list.get(i);
            data[i][0] = vo.getEmpno();
            data[i][1] = vo.getEname();
            data[i][2] = vo.getHiredate();
            data[i][3] = vo.getSal();
            data[i][4] = vo.getDname();
        }
        table.setModel(new DefaultTableModel(data, c_name){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 셀 편집 불가능
            }
        });
    }
    private void init(){
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
             factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            allData();
    }
    private void allData(){
        SqlSession ss = factory.openSession();
        depts = ss.selectList("emp.dept_all");
        viewDept();
        ss.close();
    }

    private void viewDept() {
        // 멤버변수인 depts의 길이만큼 chk_ar이라는 배열을 생성한다.
        chk_ar = new JCheckBox[depts.size()];
        //아직 jCheckBox가 만들어지진 않았다.
        int i=0;
        for(DeptVO dvo : depts){
            chk_ar[i] = new JCheckBox(dvo.getDname());
            north_p.add(chk_ar[i]);
            i++;
        }
    }

    public void updateData(EmpVO vo) {
        SqlSession ss = factory.openSession();
        int cnt = ss.update("emp.edit", vo);
        if(cnt > 0) {
            ss.commit();
            //JTable값을 갱신한다. 사용자가 JTable에서 더블클릭한 행번호(clicked_idx)를 알아야 한다.
//            table.setValueAt(vo.getEname(), clicked_idx, 1);
//            table.setValueAt(vo.getHiredate(), clicked_idx, 2);
//            table.setValueAt(vo.getSal(), clicked_idx, 3);
//            //멤버변수 List의 내용도 변경해야한다.
//            list.set(clicked_idx, vo); // list의 해당 인덱스에 수정된 vo를 넣는다.
            viewTable(list); // 테이블을 갱신한다.
            //수정 성공 메시지
            JOptionPane.showMessageDialog(this, "수정 성공");
//            search(start, end); // 수정 후 다시 조회
        }else
            ss.rollback();
        ss.close();
    }

    public static void main(String[] args) {
        new EmpFrame();
    }
}
