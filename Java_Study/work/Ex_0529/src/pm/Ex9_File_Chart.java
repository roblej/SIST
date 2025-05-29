package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex9_File_Chart extends JFrame {

	JTable table;
	String[] c_name = {"파일명","수정일","용량"};

	
	JPanel north_p;
	JTextField uri_tf;
	JButton ok_bt;
	
	public Ex9_File_Chart() {
		
		north_p = new JPanel();
		north_p.add(new JLabel("URI : "));
		north_p.add(uri_tf = new JTextField(30));
		north_p.add(ok_bt = new JButton("확인"));
		table = new JTable();
		
		this.add(north_p,BorderLayout.NORTH);
		this.add(new JScrollPane(table));
		
		ok_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String path = uri_tf.getText();

				File f = new File(path);
				if(f.isDirectory()) {
					//디렉토리 일 경우 수행
					File[] sub = f.listFiles();
					
					String[] c_name = {"파일명","수정일","용량"};
					String[][] ar = new String[sub.length][c_name.length];
					
					for(int i=0;i<sub.length;i++) {
						//파일 하나를 얻어
						File sub_file = sub[i];
						
						try {
							//얻어낸 파일의 정보를 얻어내기 위해 Map구조 생성
							Map<String,Object> att = Files.readAttributes(
									Paths.get(sub_file.getAbsolutePath()), "*");
							
							ar[i][0] = sub_file.getName();
							
							FileTime ft = (FileTime) att.get("lastModifiedTime");
							
							ar[i][1] = ft.toString();
							ar[i][2] = String.valueOf(sub_file.length());
							
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
					DefaultTableModel model = new DefaultTableModel(ar, c_name);
					table.setModel(model);
				}
				
			}
		});
		
		
		
		this.setBounds(300, 100, 600, 550);
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
		new Ex9_File_Chart();
	}

}
