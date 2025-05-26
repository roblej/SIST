package am;

import java.awt.Color;

import javax.swing.JPanel;

//클릭할 때 마다 생성되는 타원을 의미하는 객체
public class Ex1_MyThread extends Thread {
	int x,y;
	int width,height;
	Color bg;
	int speed;
	
	Ex1_Frame f;//Ex1_Frame안에 있는 p를 접근하여
				//필요할 때 p에게 다시 그림을 그리도록 해야 하기 때문에
				//p를 가지고 있는 객체 즉, Ex1_Frame의 주소를
				//현재 객체가 생성될 때 받아야 한다.
	
	public Ex1_MyThread(int x, int y, Ex1_Frame n) {
		f = n;
		width = 100;
		height = 100;
		this.x = x-(width/2);
		this.y = y-(height/2);
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		bg = new Color(red,green,blue);
		speed = (int)(Math.random()*600+50);
		
	}
	@Override
	public void run() {
		//현재 스레드는 JPanel의 높이값에서 - height값을 뺀 결과까지를
		//y좌표의 한계점으로 본다
		
		while(true) {
			y+=5;
	
			//JPanel의 높이값과 y의 값을 비교,무한반복 탈출 여부 판단
			if(y>=f.p.getHeight()-height) {
				break;//무한반복 탈출,스레드 소멸
			}
				
			//JPanel의 그림을 다시 그리도록 한다.
			f.p.repaint();
			//일정 시간동안 휴식
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}//while의 끝
		f.al.remove(this);
		f.p.repaint(); //?????????????머지
	}
	
}
