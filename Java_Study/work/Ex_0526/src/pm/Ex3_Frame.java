package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import am.Ex2_Frame;
import am.Ex2_Thread;

public class Ex3_Frame extends JFrame {
	
	JPanel p;
	
	int w = 60;//상자의 너비
	int h = 60;//상자의 높이
	int x,y; //상자의 위치
	ArrayList<Ex3_Bullet> al = new ArrayList<Ex3_Bullet>();
	//스페이스바를 누를 때 마다 생성되는 총알객체(thread)를 저장할 arraylist
	Image bg,ship,bullet;
	
	int bgY=0;
	int shipX=250;
	int shipY=600;
	boolean esc=true;
	
	public Ex3_Frame() {
		
		bg = new ImageIcon("src/images/space.jpg").getImage();
		ship = new ImageIcon("src/images/gunship.png").getImage();
		bullet = new ImageIcon("src/images/missile.png").getImage();
		this.add(p= new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				//더블버퍼링 기법 = 현 JPanel과 같은 크기의 Image객체 준비
				Image buf = createImage(this.getWidth(),this.getHeight());//this==JPanel을 상속받는 이름없는 내부객체
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				//배경 그리기
				int bgHeight = bg.getHeight(this);
				buf_g.drawImage(bg, 0,bgY,getWidth(),bgHeight, null);
				buf_g.drawImage(bg, 0,bgY-bgHeight,getWidth(),bgHeight, null);
				
				//비행기 그리기
				super.paintComponent(g);
				buf_g.drawImage(ship, shipX, shipY, 60, 60,  this);
				
				//총알을 그리기 위한 반복문
				for(int i=0;i<al.size();i++) {
					//총알객체를 al로부터 하나씩 얻어내어 b라는 변수에 저장
					Ex3_Bullet b = al.get(i);
//					buf_g.fillRect(b.x-10, b.y, b.w, b.h);
					buf_g.drawImage(bullet, b.x-10, b.y-40, b.w, b.h*2, null);
				}
				//화면에 나타내기 위해 이미지를 패널에 붙여넣는다.
				g.drawImage(buf, 0, 0, this);
			}	
		});
		this.add(p);
				
		p.setFocusable(true);
		
		this.setBounds(300, 100, 600, 800);
		setVisible(true);
		Thread back = new Thread() {
			@Override
			public void run() {
				while(esc) {
					bgY+=2;
					if(bgY>=bg.getHeight(p))
						bgY=0;
					p.repaint();
					try {
						sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		back.start();
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		p.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				int step = 10;
				switch(key) {
				case KeyEvent.VK_SPACE:
					Ex3_Bullet b = new Ex3_Bullet(Ex3_Frame.this,shipX+75/2,shipY);
					al.add(b);
					b.start();
					break;
				case KeyEvent.VK_LEFT:
//					shipX-=5;
//					if(shipX<0)
//						shipX=0;
					shipX = Math.max(shipX-step, 0);
					break;
					
				case KeyEvent.VK_RIGHT:
					shipX = Math.min(shipX+step, p.getWidth()-w);
					break;
					
				case KeyEvent.VK_UP:
					shipY = Math.max(shipY-step, 0);
					break;
					
				case KeyEvent.VK_DOWN:
					shipY = Math.min(shipY+step, p.getHeight()-h);
					break;
					
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
					break;
					
				case KeyEvent.VK_X:
					esc=false;
					break;
				case KeyEvent.VK_Z:
					esc=true;
					break;
				}//switch끝
				p.repaint();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3_Frame();
	}

}