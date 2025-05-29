package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7_Frame extends JFrame {

	JTextArea ta;
	
	JMenuItem new_item,open_item,save_item,exit_item;
	JMenu f_menu;
	JMenuBar bar;
	//파일처리를 위한 객체
	File f;
	BufferedInputStream bis;
	
	public Ex7_Frame() {
		
		this.add(new JScrollPane(ta= new JTextArea()));
		
		//메뉴작업 - JMenuItem-->JMenu-->JMenubar
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...");
		save_item = new JMenuItem("저장...");
		exit_item = new JMenuItem("종료");
		
		f_menu = new JMenu("파일");
		
		f_menu.add(new_item);
		f_menu.add(open_item);
		f_menu.add(save_item);
		f_menu.addSeparator();
		f_menu.add(exit_item);
		
		bar = new JMenuBar();
		bar.add(f_menu);
		
		this.setJMenuBar(bar);
		
		setBounds(300, 100, 600, 550);
		setVisible(true);
		
		//이벤트감지자
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				closed();
				System.exit(0);
			}
		});
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closed();
				System.exit(0);
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//파일선택기
				JFileChooser jfc = new JFileChooser("c:/my_study/sist/java_study");
				int cmd =jfc.showOpenDialog(Ex7_Frame.this);
				if(cmd == JFileChooser.APPROVE_OPTION) {
					//사용자가 긍정적인 승인을 했을때만 수행
					//Approve_option이면 사용자가 파일을 선택한 경우
					
					f = jfc.getSelectedFile();
					//위에서 받은 파일을 가지고 존재 여부 확인
					if(f.exists()) {						
						//스트림과 f를 연동
						try {
							
							bis = new BufferedInputStream(new FileInputStream(f));
							
							//size와 byte배열 선언
							int size = -1;
							byte[] buf = new byte[2048];
							
							//반복문 처리하면서 byte배열에 있는 자원을 가지고 문자열 생성
							StringBuffer sb = new StringBuffer();
							while((size=bis.read(buf))!=-1) {
								String str = new String(buf,0,size);
								//생성된 문자열을 ta에 추가
								sb.append(str);
							}
							ta.setText(sb.toString());
							ta.setCaretPosition(0);//화면 맨 위로
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
	}//생성자의 끝
	
	private void closed() {
		if(bis!=null) {
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex7_Frame();
	}

}
