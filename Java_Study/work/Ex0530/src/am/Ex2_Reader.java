package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex2_Reader extends JFrame {

	JTextArea ta;
	
	JMenuBar bar;
	JMenu file_menu;
	JMenuItem new_item, open_item, save_item, exit_item;
	
	//파일로부터 자원을 읽기하기 위한 스트림
	BufferedReader br;
	PrintWriter pw;
	File selectedFile;
	
	public Ex2_Reader() {
		
		// 화면 가운데에 ta를 생성하여 스크롤바에 추가하여 넣는다.
		add(new JScrollPane(ta = new JTextArea()));
		
		//메뉴 작업
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...", new ImageIcon("src/images/folder.png"));
		save_item = new JMenuItem("저장", new ImageIcon("src/images/save.png"));
		exit_item = new JMenuItem("종료");
		
		file_menu = new JMenu("파일");
		
		//생성된 파일메뉴에 메뉴아이템들 추가
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(save_item);
		file_menu.addSeparator();//구분선
		file_menu.add(exit_item);
		
		//메뉴바 생성
		bar = new JMenuBar();
		
		//메뉴바에 메뉴추가
		bar.add(file_menu);
		
		//현재 창에 메뉴바 설정
		this.setJMenuBar(bar);
		
		setBounds(300, 100, 500, 500);
		setVisible(true);
		
		//이벤트 감지자 등록
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 열기라는 메뉴아이템을 선택했을 때만 수행하는 곳
				JFileChooser jfc = new JFileChooser("c:/my_study");
				int cmd = jfc.showOpenDialog(Ex2_Reader.this);// 파일선택기 보여주기
				// 사용자가 [열기]를 선택했다면 cmd에는 JFileChooser.APPROVE_OPTION인
				// 0값이 저장된다.
				
				if(cmd == JFileChooser.APPROVE_OPTION) {
					// 선택된 파일을 얻어내어 멤버변수인 selectedFile에 저장!
					selectedFile = jfc.getSelectedFile();
					
					readFile();
				}
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedFile == null) {
					JFileChooser jfc = new JFileChooser("c:/my_study");
					int cmd = jfc.showSaveDialog(Ex2_Reader.this);
					if(cmd == JFileChooser.APPROVE_OPTION) {
						selectedFile = jfc.getSelectedFile();
						
						//저장하겠다고 선택한 파일이 이미 존재한다면...
						if(selectedFile.exists()) {
							int select = JOptionPane.showConfirmDialog(
									Ex2_Reader.this, "덮어쓰시겠습니까?",
									"경고", JOptionPane.YES_NO_OPTION);
							if(select != JOptionPane.YES_OPTION) {
								selectedFile = null;
								return;
							}
						}
					}else {
						selectedFile = null;
						return;
					}
				}
				// 파일을 열었거나 저장을 한번이라도 한 경우 또는
				// 저장하라고 선택한 파일이 존재하지 않거나,
				// 존재해도 파일을 덮어쓰기에 승인한 경우
				saveFile();
				
			}
		});
	}
	
	private void saveFile() {
		try {
			pw = new PrintWriter(new FileOutputStream(selectedFile));
			//스트림이 준비되었다. 이제 JTextArea에 있는 모든 문자열을 가져온다.
			String str = ta.getText();
			
			pw.write(str);
			pw.flush();
			this.setTitle(selectedFile.getName());
		} catch (Exception e) {
			// TODO: handle exception 1352845
		}
	}
	
	private void readFile() {
		if(selectedFile != null) {
			try {
				// 선택된 파일이 있으면 스트림을 생성할 수 있다.
				br = new BufferedReader(new InputStreamReader(
											new FileInputStream(selectedFile)));
				StringBuffer sb = new StringBuffer();
				String str = null;
				while((str = br.readLine()) != null) {
					sb.append(str);
					sb.append("\r\n");
				}// while문의 끝
				ta.setText(sb.toString());//JTextArea에 문자열 변경
				ta.setCaretPosition(0);//화면을 맨위로 이동시킨다.
				this.setTitle(selectedFile.getName());//파일명으로 제목변경
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void closed() {
		// 사용되는 스트림이 있다면 먼저 닫아야 한다.
		try {
			if(br != null)
				br.close();// 스트림 닫기
			if(pw != null)
				pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.exit(0);//프로그램 종료
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_Reader();
	}

}
