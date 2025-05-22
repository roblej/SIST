package pm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Ex3_Mousemotion extends MouseMotionAdapter {
	Ex3_Frame f;
	
	public Ex3_Mousemotion(Ex3_Frame n) {
		f=n;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		
		//위에서 얻은 xy값을 JPanel에 x,y에 전달해야함.그리고 jPanel에 그림을 다시 그리도록 해야함(repaint)
		f.p.x = x;
		f.p.y = y;
		
		f.p.repaint();
		
	}

}
