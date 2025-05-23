package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex8_Frame extends JFrame{
/*
 마우스 클릭시 원 생성, 아래로 떨어짐 구현
 */
	JPanel p;
	int x = 220;
	int y = 170;
	
	Thread t1 = new Thread() {//클래스 만들어야함. 내부클래스 x and arraylist사용

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("test");
			while(y>p.getHeight()-40){
				y=-10;
				p.repaint();
			}
		}
	};
	
	public Ex8_Frame() {
		p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(),this.getHeight());
				
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				buf_g.setColor(Color.orange);
				buf_g.fillOval(x, y, 20, 20);
				//사각형이 그려진 이미지를 JPanel에 넣기
				g.drawImage(buf,x,y,this);
				t1.start();
				
			}
		};
		
		this.add(p);
		setBounds(300, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1.start();
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				x = e.getX();
				y= e.getY();
				p.repaint();
				System.out.println(x);
				System.out.println(y);
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new Ex8_Frame();
	}
}
