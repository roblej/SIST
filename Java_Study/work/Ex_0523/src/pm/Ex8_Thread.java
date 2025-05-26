package pm;

import javax.swing.JPanel;

public class Ex8_Thread extends Thread {
	Ex8_Frame f;
	int time;
	public Ex8_Thread(Ex8_Frame n) {
		// TODO Auto-generated constructor stub
		f=n;
		time = (int)(Math.random()*650+50);
	}
	@Override
	public void run() {
		System.out.println("test");
		// TODO Auto-generated method stub
//		f.y-=10;
		while(f.y<f.p.getHeight()-20){
			f.y+=5;
			f.p.repaint();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while끝
//		f.al.remove(this);
	}

}
