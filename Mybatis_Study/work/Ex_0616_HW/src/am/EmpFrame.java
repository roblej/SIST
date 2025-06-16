package am;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.VO.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
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
    int clicked_idx;
    public EmpFrame() {
        north_p = new JPanel();
        start_label = new JLabel("시작일");
        end_label = new JLabel("종료일");
        start_jt = new JTextField(10);
        end_jt = new JTextField(10);
        btn = new JButton("조회");
        north_p.add(start_label);
        north_p.add(start_jt);
        north_p.add(end_label);
        north_p.add(end_jt);
        north_p.add(btn);
        this.add(north_p,"North");

        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data, c_name));

        this.setBounds(300,300,500,400);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        init();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = start_jt.getText().trim();
                end = end_jt.getText().trim();
                search(start, end);
            }
        });
        start_jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.doClick();
            }
        });
        end_jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.doClick();
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
    }
    //주석
    public static void main(String[] args) {
        new EmpFrame();
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
}
