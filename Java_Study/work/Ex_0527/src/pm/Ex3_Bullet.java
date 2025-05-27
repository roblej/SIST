package pm;

import java.awt.Rectangle;

public class Ex3_Bullet extends Thread {
//스페이스바를 눌렀을 때 생성되는 총알객체를 의미하는 클래스다.
	Rectangle rect = new Rectangle();
//	int x,y;//총알의 위치
//	int w=8, h=20;

	Ex3_Frame f;
	
	public Ex3_Bullet(Ex3_Frame n, int x,int y) {
		this.f=n;
		rect.x=x;
		rect.y=y;
		rect.width=19;
		rect.height=88;
	}
	
	@Override
	public void run() {
		while(true) {
			rect.y-=5;
			f.p.repaint();

			if(rect.y<0)
				break;

			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//while 끝
		f.b_list.remove(this);
		f.p.repaint();
	}
	
}
