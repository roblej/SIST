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
	int x;
	int y;
	Ex8_Frame f;
	public Ex8_Frame() {
		f=this;
		
		p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(),this.getHeight());
				
				Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
				buf_g.setColor(Color.orange);
				buf_g.fillOval(x, y, 20, 20);
				//사각형이 그려진 이미지를 JPanel에 넣기
				g.drawImage(buf,x,y,this);

				
			}
		};
		
		this.add(p);
		setBounds(300, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				x = e.getX();
				y= e.getY();
//				System.out.println(y);
//				p.repaint();
				Ex8_Thread t1= new Ex8_Thread(f);
				t1.start();
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new Ex8_Frame();
	}
}
