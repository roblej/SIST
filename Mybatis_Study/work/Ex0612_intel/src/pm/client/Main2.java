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
                    search(n,"emp.search_name");

                }
            }
        });
        it_empno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = JOptionPane.showInputDialog("사번을 입력하세요.");
                search(ans,"emp.search_empno");
            }
        });
        it_job.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = JOptionPane.showInputDialog("직종을 입력하세요.");
                search(ans,"emp.search_job");
            }
        });
        it_deptno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = JOptionPane.showInputDialog("부서코드를 입력하세요.");
                search(ans,"emp.search_deptno");
            }
        });
    }

    private void search(String n, String tag){
        //SQL문장을 통해 n을 전달하여 결과를 얻어내야 한다.
        SqlSession ss = factory.openSession();
        List<EmpVO> list = ss.selectList(tag,n);
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

        ss.close();
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
