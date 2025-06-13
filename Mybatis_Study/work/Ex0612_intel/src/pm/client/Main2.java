package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main2 extends JFrame {
//테스트 원투쓰리
    JPanel north_p;
    JButton btn;
    JTextField input_tf;
    JTable table;
    JMenuBar bar;
    JMenu search;
    JMenuItem  it_empno,it_job,it_deptno;
    String[] c_name = {"사번","이름","직종","부서코드"};
    String[][] data = null;
    SqlSessionFactory factory;

    public Main2(){
        bar = new JMenuBar();
        search = new JMenu("검색");
        search.add(it_empno = new JMenuItem("사번검색"));
        search.add(it_job = new JMenuItem("직종검색"));
        search.add(it_deptno = new JMenuItem("부서검색"));
        bar.add(search);
        

        setJMenuBar(bar);
        north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        north_p.add(new JLabel("검색할 이름"));
        north_p.add(input_tf = new JTextField(15));
        north_p.add(btn = new JButton("검색"));
        this.add(north_p,BorderLayout.NORTH);

        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data,c_name));

        this.setVisible(true);
        this.setBounds(300,100,500,500);

        init(); // 공장 준비 완료!

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //검색버튼(btn)을 클릭할 때 이벤트 감지자 등록
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //사용자가 입력한 검색할 이름을 가져온다.
                String n = input_tf.getText().trim();
                if(n.length()<1){
                    JOptionPane.showMessageDialog(Main2.this,
                            "검색할 이름을 입력해주세요");
                }else {
                    // DB에서 검색
                    search("emp.search_name",n);

                }
            }
        });
        it_empno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //사번검색
                String ans = JOptionPane.showInputDialog(Main2.this,"사번을 입력하세요.");
                if(ans==null || ans.trim().length()<1){
                    JOptionPane.showMessageDialog(Main2.this,"사번을 입력해주세요.");
                    return;
                }else {
                    searchEmpno(ans);
//                    search("emp.search_empno",ans);
                }
            }
        });
        it_job.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //직종검색
                String ans = JOptionPane.showInputDialog(Main2.this,"직종을 입력하세요.");
                if(ans==null || ans.trim().length()<1){
                    JOptionPane.showMessageDialog(Main2.this,"직종을 입력해주세요.");
                    return;
                }else
                    search("emp.search_job",ans);
            }
        });
        it_deptno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //부서검색
                String ans = JOptionPane.showInputDialog(Main2.this,"부서코드를 입력하세요.");
                if(ans==null || ans.trim().length()<1){
                    JOptionPane.showMessageDialog(Main2.this,"부서코드를 입력해주세요.");
                    return;
                }else
                    search("emp.search_deptno",ans);
            }
        });
    }
    private void searchEmpno(String n){
        //SQL문 활용하기 위해 factory를 통해 SqlSession을 얻어낸다.
        SqlSession ss = factory.openSession();
        //검색할 값이 기본키이므로 검색에 성공할 경우 결과는 1개다.
        //그래서 결과를 1개만 반환하는 함수를 호출했다.
        EmpVO vo = ss.selectOne("emp.search_empno",n);
        List<EmpVO> list = new ArrayList<>();
        list.add(vo); //검색결과가 1개이므로 list에 추가한다.
        viewTable(list);  //테이블에 보여주기


        ss.close();
    }
    private void search(String tag, String n){
        //SQL문장을 통해 n을 전달하여 결과를 얻어내야 한다.
        SqlSession ss = factory.openSession();
        List<EmpVO> list = ss.selectList(tag,n);
        viewTable(list);

        ss.close();
    }
    private void viewTable(List<EmpVO> list) {
        if(list!=null && list.size()>0){ //DB로부터 받은 데이터가 있을때만
            //받은 list를 JTable에 표현하기 위해 2차원 배열로 만들기
            data = new String[list.size()][c_name.length];
            int i=0;
            for(EmpVO vo : list){
                data[i][0] = vo.getEmpno();
                data[i][1] = vo.getEname();
                data[i][2] = vo.getJob();
                data[i][3] = vo.getDeptno();
                i++;
            }
            table.setModel(new DefaultTableModel(data,c_name));

        }

        }
    private void init()  {

        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
            this.setTitle("준비완료!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Main2();
    }

}
