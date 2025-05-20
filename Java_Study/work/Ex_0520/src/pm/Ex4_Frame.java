package pm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex4_Frame extends JFrame implements WindowListener{
	
	public Ex4_Frame() {
		this.setTitle("새 창");
		this.setSize(500, 500);
		this.setLocation(700, 300);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(this);//현재 객체에서 윈도우이벤트가 발생할때마다 addWindowListener(this)로 지정된 this에게 해당 함수를 호출함
//		예를 들어 종료버튼을 클릭하면 this에서 windowClosing이라는 함수를 자동으로 호출한다.
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("실행");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 종료버튼을 눌렀을때 자동 호출되는 곳
		System.out.println("종료");
		System.exit(0);//지금즉시 프로그램 종료
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("종료됨");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("아이콘화");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비아이콘화");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("활성화");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비활성화");
		
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		Ex4_Frame f = new Ex4_Frame();
		
	}

	
}
