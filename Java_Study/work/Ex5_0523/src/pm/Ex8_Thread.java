package pm;

import javax.swing.JPanel;

public class Ex8_Thread extends Thread {
	Ex8_Frame f;
	public Ex8_Thread(Ex8_Frame n) {
		// TODO Auto-generated constructor stub
		f=n;
	}
	@Override
	public void run() {
		System.out.println("test");
		// TODO Auto-generated method stub
//		f.y-=10;
		while(f.y<f.p.getHeight()-40){
			f.y+=5;
			f.p.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while끝
	}

}
