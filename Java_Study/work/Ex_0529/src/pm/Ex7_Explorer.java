package pm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex7_Explorer extends JFrame {

	JTable table;
	String[] c_name = {"사번","이름","입사일","직책","부서"};
	Object[][] data = {
			{"1010","일지매","2024-10-02","사원","10"},
			{"2100","이지매","2022-11-02","대리","10"},
			{"2220","삼지매","2024-06-12","사원","20"}
	};
	
	public Ex7_Explorer() {
		
		DefaultTableModel model = new DefaultTableModel(data, c_name);
		
		table = new JTable(model);
		
		this.add(new JScrollPane(table));
		
		
		this.setBounds(300, 100, 500, 550);
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex7_Explorer();
	}

}
