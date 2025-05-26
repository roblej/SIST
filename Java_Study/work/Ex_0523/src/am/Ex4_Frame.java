package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame{
	JPanel p;
	
	int x = 210;
	
	public Ex4_Frame() {
		
		p=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				//buf에만 그림을 그릴 수 있는 붓 객체를 얻어낸다.
				Graphics buf_g = buf.getGraphics();
				int red = (int)(Math.random()*256);
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				Color c = new Color(red,green,blue);
				buf_g.setColor(c);
				
				buf_g.fillRect(x, 235, 80, 30);//buf에 그림그리기
				
				//현재 JPanel에 위에서 준비된 이미지를 붙여넣기
				g.drawImage(buf, 0, 0,this);
			}
				};
		this.add(p);//가운데 p객체 생성 후 추가
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					int keyCode = e.getKeyCode();
					
					switch(keyCode) {
					case KeyEvent.VK_LEFT:
						x-=5;
						if(x<0)
							x=0;
						break;
					case KeyEvent.VK_RIGHT:
						x+=5;
						if(x>p.getWidth()-80)
							x=p.getWidth()-80;
						break;
					}//switch의 끝
					
					p.repaint();
		}
		});
		
		setBounds(300,100,500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex4_Frame();

	}
}
