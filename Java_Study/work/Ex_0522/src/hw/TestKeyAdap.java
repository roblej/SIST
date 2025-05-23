package hw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyAdap extends KeyAdapter {
	
	TestFrame f;
	
	public TestKeyAdap(TestFrame f) {
		this.f=f;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			f.p.x-=5;
			if(f.p.x<0)
				f.p.x=0;
			break;
		case KeyEvent.VK_RIGHT:
			f.p.x+=5;
			if(f.p.x>f.p.getWidth()-80)
				f.p.x=f.p.getWidth()-80;
			break;
		}//switch의 끝
		
		f.p.repaint();
	}

}
