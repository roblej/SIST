package pm;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_Frame extends JFrame {

//	JPanel p;
	Ex3_Panel p;
	public Ex3_Frame() {
//		p = new JPanel();
//		this.add(p);
		
		p = new Ex3_Panel();
		this.add(p);
		
		setBounds(300, 300, 400, 300);
		setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new Ex2_MyAdap());
		p.addMouseMotionListener(new Ex3_Mousemotion(this));
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		new Ex3_Frame();

	}

}
