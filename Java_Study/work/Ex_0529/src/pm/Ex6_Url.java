package pm;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex6_Url extends JFrame {
	JPanel center_p;
	JTextField url_tf;
	JButton down_bt;
	
	//파일처리를 위한 스트림 객체들
	BufferedInputStream bis;
	BufferedOutputStream bos;
	
	public Ex6_Url() {
		//화면구성
		center_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		center_p.add(new JLabel("URL : "));
		center_p.add(url_tf = new JTextField(60));
		center_p.add(down_bt = new JButton("다운로드"));
		
		this.add(center_p);

		
		
		
		this.setBounds(300, 100, 800, 250);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override 
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				closed();
				
			}
			
		});
		
		down_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다운로드 버튼을 클릭 시
				
				JFileChooser jfc = new JFileChooser("c:/my_study");
				
				
				 String url_path = url_tf.getText().trim();
//				 int idx = url_path.lastIndexOf("/");
//				 String fname =  url_path.substring(idx+1);
				 
				String[] name= url_path.split("/");
				String fname =name[name.length-1]; 
				
				//추출한 파일명을 파일 선택기에 지정한다
				jfc.setSelectedFile(new File(fname));
				
				int cmd = jfc.showSaveDialog(Ex6_Url.this);
				if(cmd == JFileChooser.APPROVE_OPTION) {
					//저장버튼을 클릭한 경우
					//이런 경우 사용자가 반드시 파일을 선택한 경우다
					//선택된 파일을 얻어내자
					File f= jfc.getSelectedFile();

					try {
						URL url = new URL(url_path);//웹상의 경로를 객체화
						//웹 상에 존재하는 이미지 경로와 연결된 스트림 생성
						bis = new BufferedInputStream(url.openStream());
						bos = new BufferedOutputStream(new FileOutputStream(f));
						
						int size = -1;
						byte[] buf = new byte[4096];
						
						while((size = bis.read(buf))!= -1) {
							//읽은 자원들은 모두 buf라는 배열에 저장된 상태이다.
							//읽기한 수는 size가 기억하므로 buf의 0번지부터 size수 만큼
							//쓰기
							bos.write(buf, 0, size);
							bos.flush();
						}
						JOptionPane.showMessageDialog(Ex6_Url.this, "저장완료!");
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
				}
			}
		});
	}//생성자의 끝
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
		// 프로그램 시작
		new Ex6_Url();

	}

}
