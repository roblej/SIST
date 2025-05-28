package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ex2_File extends JFrame{
	
	JPanel north_p;
	JTextField input_tf;
	JButton ok_bt, back_bt;
	JList<String> list;
	String path;
	
	public Ex2_File() {
		
		north_p = new JPanel();
		input_tf = new JTextField(20);
		ok_bt = new JButton("확인");
		back_bt = new JButton("뒤로");
		
		north_p.add(new JLabel("경로:"));
		north_p.add(input_tf);
		north_p.add(ok_bt);
		north_p.add(back_bt);
		this.add(north_p,BorderLayout.NORTH);
		
		this.add(new JScrollPane(list = new JList<>()));
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		});
	
	ok_bt.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//ok_bt를 눌렀을때만 수행하는 곳이므로
			//e.getSource()를 호출하여 객체를 구별할 필요가 없다.
			viewList();
		}
	});
	
	input_tf.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// JTextField에서 엔터를 치면 ActionEvent다.
			viewList();
			
		}
	});
	
	back_bt.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//풀이
			path = input_tf.getText().trim();
			int index = path.lastIndexOf("/");
			path=path.substring(0, index);
			input_tf.setText(path);
			
//			//path에서 역순으로 /를 만날때까지 삭제
//			String[] ar = path.split("/");
//			StringBuffer sb = new StringBuffer();
//			
//			for(int i=0;i<ar.length-1;i++) {
//				sb.append(ar[i]);
//				sb.append("/");	
//			}
//			
//			input_tf.setText(sb.toString());
			
			viewList();
			
		}
	});
	
	list.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			//더블클릭했는지 확인
			int cnt = e.getClickCount();
			if(cnt==2) {
				String str = list.getSelectedValue();
				
//				JOptionPane.showMessageDialog(list, str);
				String path_old = path;
				
				path=path.concat("/").concat(str);
				
				if(!new File(path).isDirectory()) 
					path = path_old;
				
					input_tf.setText(path);
					
				viewList();
			}
		}
		
		
	});
	
	}
	public void viewList() {
		//해야할 일은 - 사용자가 입력한 경로를 얻어낸다.
		path =input_tf.getText().trim();
		
		if(path.length()<3 && !path.contains("/")) {
			path = path.concat("/");
			input_tf.setText(path);
		}
		
		//두번째로 할일은 경로를 얻어냈으니 이 경로로 File 객체 생성
		File f= new File(path);
		//해당 f가 존재하는지? 폴더인지?
		if(f.exists()&&f.isDirectory()) {
			String[] ar = f.list();
			//받은 배열을 jList에 적용한다.
			list.setListData(ar);
		}//if의 끝
	}
	public static void main(String[] args) {
		new Ex2_File();
	}
}
