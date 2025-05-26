package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex7_Frame extends JFrame{
	
	JPanel p;
	int x = 220;
	int y = 170;
	int cmd;
	Thread t1 = new Thread() {

		@Override
		public void run() {

			cmd = (int)(Math.random()*4+37);

			// TODO Auto-generated method stub
			while(true) {
				switch(cmd) {
				case KeyEvent.VK_RIGHT:
					x+=10;
					break;
				case KeyEvent.VK_LEFT:
					x-=10;					
					break;
				case KeyEvent.VK_UP:
					y-=10;
					break;
				case KeyEvent.VK_DOWN:
					y+=10;
					break;
				}
				if(x>p.getWidth()-40||x<0||y>p.getHeight()-40||y<0) {
					break;
				}
				try {
					Thread.sleep(30);
					p.repaint();//그림다시그리기
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//무한반복
		}
	};
	
	public Ex7_Frame() {
		
		p = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(),this.getHeight());
				
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				buf_g.setColor(Color.orange);
				buf_g.fillRect(x, y, 40, 40);
				
				//사각형이 그려진 이미지를 JPanel에 넣기
				g.drawImage(buf,0,0,this);
				
			}
		};
		
		
		this.add(p);
		setBounds(300, 100, 500, 500);
		setVisible(true);
		
//		t1.start();
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_SPACE) {
					t1.start(); 
				}else
					cmd = key;
				
					
			}
		});
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
	}
	public static void main(String[] args) {
		new Ex7_Frame();
	}
}