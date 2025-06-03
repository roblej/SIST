package pm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex6_Frame extends JFrame{
	
	JTable table;
	
	String[] c_name ={"사번","이름","직책","입사일","부서코드"};
	
	Object[][] data;
	
	ArrayList<Ex6_emp> e_list = new ArrayList<>();
	
	JMenuBar bar;
	JMenu file_menu;
	JMenuItem new_item, add_item, open_item, save_item, exit_item;
	
	ObjectInputStream br;
	ObjectOutputStream pw;
	File selectedFile;
	
	public Ex6_Frame() {
		
		add(new JScrollPane(table = new JTable(new DefaultTableModel(null, c_name))));
		
		new_item = new JMenuItem("새파일");
		add_item = new JMenuItem("추가");
		open_item = new JMenuItem("열기...", new ImageIcon("src/images/folder.png"));
		save_item = new JMenuItem("저장", new ImageIcon("src/images/save.png"));
		exit_item = new JMenuItem("종료");
		
		file_menu = new JMenu("파일");
		
		//생성된 파일메뉴에 메뉴아이템들 추가
		file_menu.add(new_item);
		file_menu.add(add_item);
		file_menu.add(open_item);
		file_menu.add(save_item);
		file_menu.addSeparator();//구분선
		file_menu.add(exit_item);
		
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
		
		add_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ex6_AddDialog add = new Ex6_AddDialog(Ex6_Frame.this);
			}
		});
		
open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 열기라는 메뉴아이템을 선택했을 때만 수행하는 곳
				JFileChooser jfc = new JFileChooser("C:/Users/TEN/Documents/GitHub/SIST");
				int cmd = jfc.showOpenDialog(Ex6_Frame.this);// 파일선택기 보여주기
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
					JFileChooser jfc = new JFileChooser("C:/Users/TEN/Documents/GitHub/SIST");
					int cmd = jfc.showSaveDialog(Ex6_Frame.this);
					if(cmd == JFileChooser.APPROVE_OPTION) {
						selectedFile = jfc.getSelectedFile();
						
						//저장하겠다고 선택한 파일이 이미 존재한다면...
						if(selectedFile.exists()) {
							int select = JOptionPane.showConfirmDialog(
									Ex6_Frame.this, "덮어쓰시겠습니까?",
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
		
	}
	
	private void readFile() {
		
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
	
	public void addData(String empno, String ename, String pos,
			String hdate, String deptno) {
		Ex6_emp emp = new Ex6_emp(empno, ename, pos, hdate, deptno);
		e_list.add(emp);// 멤버변수인 e_list라는 ArrayList에 저장!!!!
		viewTable();
	}
	
	public void viewTable() {
		//멤버변수인 e_list를 가지고 2차원 배열을 만든다.
		data = new Object[e_list.size()][c_name.length];
		
		for(int i=0; i<e_list.size(); i++) {
			//ArrayList에서 저장된 요소 가져오기
			Ex6_emp emp = e_list.get(i);
			
			data[i][0] = emp.getEmpno();//사번
			data[i][1] = emp.getEname();//이름
			data[i][2] = emp.getPos();//직책
			data[i][3] = emp.getHire_date();// 입사일
			data[i][4] = emp.getDeptno();//부서코드
		}
		//위의 반복문으로 테이블에 사용할 모델 자원이 준비되었다.
		// 모델객체 생성한 후 그것을 테이블에 적요하면 끝~~!
		table.setModel(new DefaultTableModel(data, c_name));
	}
	
	public static void main(String[] args) {
		new Ex6_Frame();
		
	}
}
