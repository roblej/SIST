package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex5_Output extends JFrame {
	
	JTextArea ta;
	
	JMenuBar bar;
	JMenu file_menu, color_menu;
	JMenuItem new_item,open_item,save_item,exit_item;
	JMenuItem red_item,green_item,blue_item,orange_item;
	
	BufferedInputStream bis;
	BufferedOutputStream bos;
	File selectedFile;
	
	public Ex5_Output() {
		ta = new JTextArea();
		this.add(new JScrollPane(ta));
		
		//메뉴작업
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기");
		save_item = new JMenuItem("저장");
		exit_item = new JMenuItem("종료");
		//서브메뉴 작업
		red_item = new JMenuItem("빨강");
		green_item = new JMenuItem("초록");
		blue_item = new JMenuItem("파랑");
		
		color_menu = new JMenu("색상");
		color_menu.add(red_item);
		color_menu.add(green_item);
		color_menu.add(blue_item);
		//
		
		file_menu = new JMenu("파일");
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(color_menu);
		
		file_menu.add(save_item);
		file_menu.addSeparator();
		file_menu.add(exit_item);
		
		
		
		bar = new JMenuBar();
		bar.add(file_menu);
//		bar.add(color_menu);
		
		this.setJMenuBar(bar);
		
		this.setBounds(300, 100, 600, 600);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				closed();
				System.exit(0);
			}
		});
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser("c:/my_study");
				//위와 같은 파일선택기가 생성되어도 화면에는 나타나지 않는다.
				int cmd = jfc.showOpenDialog(Ex5_Output.this);
				
				if(cmd == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					
					readFile();
				}
			}
		});
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//저장 버튼을 클릭할때만 수행
				//선택된 파일이 null이 아니고 파일이 존재해야 한다.
				if(selectedFile !=null) {
					saveFile();
				}else {
					//선택된 파일이 없을때
					//어디에 저장할 건지 파일선택기를 보여주면서 사용자로 하여금
					//저장 위치를 지정하도록 해야 한다.
					JFileChooser jfc = new JFileChooser("c:/my_study");
					int cmd = jfc.showSaveDialog(Ex5_Output.this);
					if(cmd==JFileChooser.APPROVE_OPTION) { //저장버튼을 눌렀을때
						//사용자가 선택한 파일정보를 얻어내어 selectedfile에 저장
						selectedFile = jfc.getSelectedFile();
						//파일이 이미 존재할 경우 덮어쓰기할지?
						if(selectedFile.exists()) {					
							int cmd2 =
									JOptionPane.showConfirmDialog(Ex5_Output.this, "덮어쓰기 하시겠습니까?",
											"경고",JOptionPane.YES_NO_OPTION);
							
							if(cmd2!=JOptionPane.YES_OPTION) {
								selectedFile = null;
								return;
							}
							saveFile();
						}
					}
					
				}
			}
		});
	}//생성자의 끝
	
	//파일에 저장하는 함수
	private void saveFile() {
		if(selectedFile!=null && selectedFile.exists()) {
			try {
				bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
				//쓰기할 데이터는 JTextArea에 있음
				String str = ta.getText();
				
				byte[] buf = str.getBytes();
				bos.write(buf, 0, buf.length);
				bos.flush();
				
				this.setTitle(selectedFile.getName());
				JOptionPane.showMessageDialog(this, "저장완료");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	private void readFile() {
		//먼저 선택된 파일이 있어야 하고, 파일이 존재해야 한다.
		if(selectedFile!=null && selectedFile.exists()) {
			//읽기할 스트림 생성
			try {
				bis = new BufferedInputStream(new FileInputStream(selectedFile));
				
				int size = -1;//읽은 수를 저장할 변수
				byte[] buf = new byte[2048];//바구니역할의 byte타입 배열
				StringBuffer sb = new StringBuffer();
				
				while((size = bis.read(buf))!= -1) {//주석달기
					String str = new String(buf, 0, size);//배열에 있는 자원들을 가져와서 문자열 객체로 생성
					sb.append(str);
					
				}
				ta.setText(sb.toString());
				this.setTitle(selectedFile.getName());//제목설정
				ta.setCaretPosition(0);//화면을 맨 위로 이동
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	private void closed() {
		//각 스트림들 생성여부 확인 후 닫기 한다.
		try {
			if (bis!=null) 
				bis.close();
			if(bos!=null)
				bos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		new Ex5_Output();
	}
}
