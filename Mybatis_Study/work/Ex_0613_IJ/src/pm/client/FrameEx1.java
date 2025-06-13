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
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FrameEx1 extends JFrame {

    JPanel north_p;
    JComboBox<String> combo;
    String[] ar = {"이름검색", "직종검색", "부서검색"};
    JTextField input_tf;
    JButton btn;

    JTable table;
    String[] c_name = {"사원번호", "이름", "직무", "입사일","부서코드"};
    String[][] data;

    SqlSessionFactory factory;


    public FrameEx1() {

        north_p = new JPanel();
        north_p.add(combo = new JComboBox<>(ar));
        north_p.add(input_tf = new JTextField(12));
        north_p.add(btn = new JButton("검색"));
        this.add(north_p, BorderLayout.NORTH);

        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data, c_name));

        setBounds(300, 300, 400, 300); // x, y, width, height
        // Set the frame visibility
        setVisible(true);

        init();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        input_tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Exit the application when the window is closed
            }
        });
    }
    private void search(){
        String str = input_tf.getText().trim();
        if(str.length()>0){
            //사용자가 검색어를 1자라도 입력했을 때 만 수행
            Map<String,String> map = new HashMap<>();
            int type = combo.getSelectedIndex();
//            System.out.printf("Input : %d, Value : %s\r\n" ,type, str);
            map.put("searchType", String.valueOf(type));
            map.put("searchValue", str);
            SqlSession ss = factory.openSession();
            List<EmpVO> list = ss.selectList("emp.search", map);

            viewTable(list);
            ss.close();
        }
    }

    private void viewTable(List<EmpVO> list) {
        //인자로 받은 List구조를 2차원배열로 변환한 후 JTable에 표현
        data = new String[list.size()][c_name.length];
        int i=0;
        for(EmpVO vo : list){
            data[i][0] = vo.getEmpno();
            data[i][1] = vo.getEname();
            data[i][2] = vo.getJob();
            data[i][3] = vo.getHiredate();
            data[i][4] = vo.getDeptno();
            i++;
        }
        table.setModel(new DefaultTableModel(data, c_name));

    }

    private void init() {
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close(); // Close the Reader after building the factory
            this.setTitle("준비완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insert(){
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new FrameEx1();
    }
}
