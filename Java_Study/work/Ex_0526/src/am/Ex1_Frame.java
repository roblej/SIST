package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ex1_Frame extends JFrame {
	
	JPanel p;
	ArrayList<Ex1_MyThread> al = new ArrayList<Ex1_MyThread>();
	Ex1_Frame f;
	
	public Ex1_Frame() {
		f=this;
		
		p = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				//ArrayList에 있는 Ex1_Mythread들을 하나씩 가져와서 그림을 그려야 함
				//먼저 더블버퍼링을 위한 Image객체 준비
				Image buf = createImage(this.getWidth(),this.getHeight());//this==JPanel을 상속받는 이름없는 내부객체
				
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				
				for(int i=0;i<al.size();i++) {
					Ex1_MyThread mt = al.get(i);
					
					buf_g.setColor(mt.bg);
					buf_g.fillOval(mt.x, mt.y, mt.width, mt.height);
					//사각형이 그려진 이미지를 JPanel에 넣기
					g.drawImage(buf,0,0,this);		
				}
			}
			//JPanel을 상속받는 익명의 내부클래스
			
		};
		
		
		
		this.add(p);
		
		this.addMouseListener(new MouseAdapter() {
			//현재영역은 MouseAdapter을 상속받는 익명 내부 클래스
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y= e.getY();
				Ex1_MyThread m = new Ex1_MyThread(x,y,Ex1_Frame.this);
				//내부클래스에서 바깥쪽 클래스를 지칭할때는
				//바깥쪽 클래스명.this라고한다.
				
				//이렇게 생성된 타원스레드객체인 ex1_mythread를 al에 저장
				al.add(m);
				//이제 m이라는 스레드를 구동해야함
				m.start();
			}
			
		});
		
		
		
		this.setBounds(300, 100, 800, 500);
		this.setVisible(true);
		
		//종료이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프로그램 종료
			}
			
		});
	}
	
	public static void main(String[] args) {
		new Ex1_Frame();
	}
}
