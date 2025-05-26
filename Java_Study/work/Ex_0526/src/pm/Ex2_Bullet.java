package pm;

public class Ex2_Bullet extends Thread {
//스페이스바를 눌렀을 때 생성되는 총알객체를 의미하는 클래스다.
	
	int x,y;//총알의 위치
	int w=8, h=20;

	Ex2_FrameT f;
	
	
	public Ex2_Bullet(Ex2_FrameT n, int x,int y) {
		this.f=n;
		this.x=x;
		this.y=y;
	}
	
	
	
	@Override
	public void run() {
		System.out.println("run");
		while(true) {
			y-=5;
			f.p.repaint();
			
			if(y<0)
				break;
			
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//while 끝
		f.al.remove(this);
		f.p.repaint();
	}
	
}
