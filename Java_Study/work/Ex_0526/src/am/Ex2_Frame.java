package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ex2_Frame extends JFrame {
	JPanel bullet;
	JPanel p;
	ArrayList<Ex2_Thread> al = new ArrayList<Ex2_Thread>();
	
	int x = 250;
	int y =300;
	
	public Ex2_Frame() {
		System.out.println(x);
		System.out.println(y);
		p= new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.fillRect(x, y, 40, 20);
				
			}
			
		};
		bullet = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				//ArrayList에 있는 Ex1_Mythread들을 하나씩 가져와서 그림을 그려야 함
				//먼저 더블버퍼링을 위한 Image객체 준비
				Image buf = createImage(this.getWidth(),this.getHeight());//this==JPanel을 상속받는 이름없는 내부객체
				
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				
				for(int i=0;i<al.size();i++) {
					Ex2_Thread mt = al.get(i);
					buf_g.setColor(mt.bg);
//					System.out.printf("%d,%d,%d,%d\n",mt.x, mt.y, mt.width, mt.height);
					buf_g.fillRect(mt.x, mt.y, mt.width, mt.height);
					//사각형이 그려진 이미지를 JPanel에 넣기
					g.drawImage(buf,0,0,this);		
				}
			}
			//JPanel을 상속받는 익명의 내부클래스
			
		};
		p.setBackground(Color.WHITE);
		p.add(bullet);
		this.add(p);
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_SPACE:
					Ex2_Thread m = new Ex2_Thread(x,y,Ex2_Frame.this);
					al.add(m);
					m.start();
					break;
				case KeyEvent.VK_LEFT:
					x-=5;
					if(x<0)
						x=0;
					p.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					if(x>p.getWidth()-40)
						x=p.getWidth()-40;
					p.repaint();
					break;
				}
			}
		});
		
		
		setBounds(300, 400, 500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Ex2_Frame();
	}
}
