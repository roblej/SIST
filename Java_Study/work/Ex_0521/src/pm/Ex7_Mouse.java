package pm;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Ex7_Mouse extends JFrame implements KeyListener{

	Ex7_Panel p1;
	
	public Ex7_Mouse() {
		p1 = new Ex7_Panel();
		this.add(p1);//현재 창의 가운데에 Ex7_Panel을 추가했다.
		
		
		setBounds(300,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		this.addKeyListener(this);
	}
	
	
	
	
	public static void main(String[] args) {
		// 프로그램시작
		new Ex7_Mouse();
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 누를 때마다 수행하는 곳
		// 이 떄 방향키만 얻어낸다.
		int keyCode = e.getKeyCode();
		
		//keyCode가 방향키인지 구분하여 처리하는 비교문
		switch(keyCode) {
		case KeyEvent.VK_UP:
			p1.y-=5;
//			p1.repaint();
			break;
		case KeyEvent.VK_RIGHT:
			p1.x+=5;
			break; 
		case KeyEvent.VK_DOWN:
			p1.y +=5;
			break;
		case KeyEvent.VK_LEFT:
			p1.x-=5;
			break;
		}//스위치의 끝
		p1.repaint();
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
