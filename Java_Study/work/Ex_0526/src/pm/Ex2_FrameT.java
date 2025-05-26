package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import am.Ex2_Frame;
import am.Ex2_Thread;

public class Ex2_FrameT extends JFrame {
	
	JPanel p;
	
	int w = 80;//상자의 너비
	int h = 20;//상자의 높이
	int x,y; //상자의 위치
	ArrayList<Ex2_Bullet> al = new ArrayList<Ex2_Bullet>();
	//스페이스바를 누를 때 마다 생성되는 총알객체(thread)를 저장할 arraylist
	
	public Ex2_FrameT() {
		
		this.add(p= new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				//더블버퍼링 기법 = 현 JPanel과 같은 크기의 Image객체 준비
				Image buf = createImage(this.getWidth(),this.getHeight());//this==JPanel을 상속받는 이름없는 내부객체
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				//총알을 그리기 위한 반복문
				buf_g.fillRect(x, y, w, h);
				
				for(int i=0;i<al.size();i++) {
					//총알객체를 al로부터 하나씩 얻어내어 b라는 변수에 저장
					Ex2_Bullet b = al.get(i);
					buf_g.fillRect(b.x, b.y, b.w, b.h);
				}
				
				g.drawImage(buf,0,0,this);		
			}
			
		});
		
		
		this.setBounds(300, 100, 600, 500);
		
		this.setBackground(null);
		p.setFocusable(true);
		setVisible(true);
		
		
		//상자의 위치를 잡아주기 위해 setVisible 후에 x,y좌표를 지정해야한다.
		x = p.getWidth()/2- w/2;
		y = p.getHeight()- (h+10);
		
		
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
				switch(key) {
				case KeyEvent.VK_SPACE:
					Ex2_Bullet b = new Ex2_Bullet(Ex2_FrameT.this,x+75/2,y);
					al.add(b);
					b.start();
					break;
				case KeyEvent.VK_LEFT:
					x-=5;
					if(x<0)
						x=0;
					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					if(x>p.getWidth()-w)
						x=p.getWidth()-w;
					break;
				}//switch끝
				p.repaint();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2_FrameT();
	}

}
