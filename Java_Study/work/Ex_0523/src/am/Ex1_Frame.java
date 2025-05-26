 package am;

import javax.swing.JFrame;

public class Ex1_Frame extends JFrame {

	Ex1_Panel p;
	
	public Ex1_Frame() {
		this.add(p=new Ex1_Panel());//가운데 p객체 생성 후 추가
		
		
		
		this.addWindowListener(new Ex1_WinAdap());
		this.addKeyListener(new Ex1_keyAdap(this));
		
		setBounds(300,100,500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_Frame();

	}

}
