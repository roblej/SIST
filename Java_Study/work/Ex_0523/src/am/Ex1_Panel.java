package am;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Ex1_Panel extends JPanel {
	int x = 210;
	@Override
	public void paintComponent(Graphics g) {//더블버퍼링기법
		//  현재 JPanel과 같은 크기의 이미지 객체를 생성
		Image buf = createImage(this.getWidth(), this.getHeight());
		
		//buf에만 그림을 그릴 수 있는 붓 객체를 얻어낸다.
		Graphics buf_g = buf.getGraphics();
		
		buf_g.fillRect(x, 235, 80, 30);//buf에 그림그리기
		
		//현재 JPanel에 위에서 준비된 이미지를 붙여넣기
		g.drawImage(buf, 0, 0,this);
		
	}

}
