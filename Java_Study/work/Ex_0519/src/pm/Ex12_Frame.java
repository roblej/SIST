package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//현재 객체는 JFrame으로부터 상속을 받았으므로
//현재 객체를 생성하는 것이 바로 창틀을 만드는 것과 같음
public class Ex12_Frame extends JFrame {

	//현재 창 객체가 가지는 모든 것들을 멤버변수로 선언한다.
	private JButton bt1,bt2,bt3;
	
	public Ex12_Frame() {
		
		setTitle("버튼을 가진 창");
		
		//버튼객체 생성
		bt1 = new JButton("클릭1"); 
		bt2 = new JButton("클릭2"); 
		bt3 = new JButton("클릭3"); 
		//아직 현재 창에 추가하지 않아 보이지 않음.
		add(bt1,BorderLayout.NORTH);//north영역에 bt1 추가
		add(bt2,BorderLayout.SOUTH);
		add(bt3,BorderLayout.CENTER);
		setSize(500, 400);
		setLocation(700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12_Frame f = new Ex12_Frame();
		
	}

}
