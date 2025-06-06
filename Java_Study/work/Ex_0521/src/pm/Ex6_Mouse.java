package pm;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex6_Mouse extends JFrame implements MouseListener{
	JPanel center_p;
	int count;
	Color color;
	
	public Ex6_Mouse() {
		center_p = new JPanel();
		this.add(center_p);
		
		this.setBounds(300,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		color = center_p.getBackground();//배경색 얻기
		//이벤트 감지자 등록
		center_p.addMouseListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6_Mouse();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setTitle(++count+"회 클릭");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//center_p에 마우스가 들어가면 수행하는곳
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		Color c = new Color(red,green,blue);//색상객체 생성
		//위에서 만든 색상객체를 center_p의 배경색으로 지정
		center_p.setBackground(c);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		//center_p에 마우스가 빠져나오면 수행하는곳
		center_p.setBackground(color);
	}

}
