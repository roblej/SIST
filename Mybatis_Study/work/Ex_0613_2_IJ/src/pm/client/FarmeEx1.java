package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.VO.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FarmeEx1 extends JFrame{

    JPanel north_p;
    JLabel start_label,end_label;
    JTextField start_jt,end_jt;
    JButton btn;
    JTable table;
    String[] c_name = {"사번","이름","입사일","급여","부서명"};
    String[][] data;
    SqlSessionFactory factory;
    String start,end;
    public FarmeEx1() {
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
                start = start_jt.getText();
                end = end_jt.getText();
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
    }

    private void search(String start, String end) {
        SqlSession ss = factory.openSession();
            // Assuming you have a mapper method named 'selectEmpByDateRange'
        if(start.length()>0 && end.length()>0) {
            Map<String, String> params = new HashMap<>();
            params.put("startDate", start);
            params.put("endDate", end);
            List<EmpVO> list = ss.selectList("emp.select", params);
            viewTable(list);
            ss.close();
        }
    }
    private void viewTable(List<EmpVO> list){
        String[][] data = new String[list.size()][c_name.length];
        for(int i=0; i<list.size(); i++){
            EmpVO vo = list.get(i);
            data[i][0] = vo.getEmpno();
            data[i][1] = vo.getEname();
            data[i][2] = vo.getHiredate();
            data[i][3] = vo.getSal();
            data[i][4] = vo.getDeptno();
        }
        table.setModel(new DefaultTableModel(data, c_name));
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
        new FarmeEx1();
    }
}
