package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Ex8_Jpanel extends JPanel {
	int x,y;
	public Ex8_Jpanel(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image buf = createImage(this.getWidth(),this.getHeight());
		
		Graphics buf_g = buf.getGraphics();//이미지에 그리는 전용 붓
		buf_g.setColor(Color.orange);
		buf_g.fillOval(x, y, 20, 20);
		//사각형이 그려진 이미지를 JPanel에 넣기
		g.drawImage(buf,0,0,this);

		
	}
}
