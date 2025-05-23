package hw;

import javax.swing.JFrame;

public class TestFrame extends JFrame {
	TestPanel p;
	
	public TestFrame() {
//		p = new TestPanel();
//		this.add(p);
		this.add(p=new TestPanel());
		//이벤트 감지자 등록
		this.addWindowListener(new TestWindowAdap());
		this.addKeyListener(new TestKeyAdap(this));
		
		setTitle("키맵핑");
		setBounds(500, 500, 500, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestFrame();
	}

}
