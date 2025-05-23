package am;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Frame extends JFrame {
	private String msg = "상용교육센터";
	JPanel p;
	
	public Ex3_Frame() {
		
		p=new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawString(msg, 10, 50);
			}
			
		};
		
		this.add(p);
		
		this.setBounds(300, 100, 400, 400);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			//현재 영역은 WindowAdapter을 상속받는 이름없는 내부클래스다
			//class ? extends WindowAdapter{}와 동일
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3_Frame();
	}

}
