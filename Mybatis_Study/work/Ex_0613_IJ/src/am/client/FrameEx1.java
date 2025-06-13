package am.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;

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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Exit the application when the window is closed
            }
        });
    }

    private void init() {
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
            r.close(); // Close the Reader after building the factory
            this.setTitle("준비완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FrameEx1();
    }
}
