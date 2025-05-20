package pm;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_Frame  extends JFrame implements WindowListener,MouseListener{

	JPanel north_p;
	JButton bt1,bt2,bt3;
	JTextArea ta;
	
	public Ex6_Frame() {
		north_p = new JPanel();
		bt1 = new JButton("RED");
		bt2 = new JButton("GREEN");
		bt3 = new JButton("BLUE");
		ta = new JTextArea();
		
		//위에서 생성한 객체들을 배치시켜야 한다.
		//먼저 North영역에 들어갈 버튼들을 north_p에 추가
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		//현재 창 North영역에 north_p를 추가한다.
		this.add(north_p,BorderLayout.NORTH);
		//현재 창 가운데에 ta를 추가한다
		//스크롤바의 역활을 하는 객체 생성
		JScrollPane jp = new JScrollPane(ta);

		this.addWindowListener(this);
		
		//이벤트 감지자 등록
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addMouseListener(this);
		
		this.add(jp,BorderLayout.CENTER);
		this.setSize(500, 500);
		this.setLocation(300, 200);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_Frame f = new Ex6_Frame();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 마우스 버튼을 누를때 마다 호출하여 수행
		//이벤트를 발생시킨 객체를 찾는다
		
		Object obj = e.getSource();
		
		if(obj == bt1) {//이벤트를 발생시킨 객체가 bt1일 때 수행
			ta.append("Red\r\n");
		}else if(obj == bt2) {
			ta.append("Green\r\n");
			
		}else if(obj == bt3) {
			ta.append("Blue\r\n");
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
