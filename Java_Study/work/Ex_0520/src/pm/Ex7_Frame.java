package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex7_Frame extends JFrame implements MouseListener, ActionListener{
	
	JPanel jp1,jp2;
	
	JButton bt1,bt2,bt3;
	
	public Ex7_Frame() {
		// TODO Auto-generated constructor stub
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		bt1 = new JButton("Red");
		bt2 = new JButton("Green");
		bt3 = new JButton("Blue");
		
		jp1.add(bt1);
		jp1.add(bt2);
		jp1.add(bt3);
		
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		
		jp1.addMouseListener(this);
		jp2.addMouseListener(this);
		
		this.setTitle("jp2");
//		this.setSize(500,500);
//		this.setLocation(300, 200);
		setBounds(300, 200, 500, 500); // 위 두줄을 한줄로
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//이벤트감지자등록
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Ex7_Frame f = new Ex7_Frame();
		new Ex7_Frame();//f는 한번 쓰고 땡이라 이렇게 써도 됨
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 발생할 때 마다 수행하는곳!
		// 이벤트를 발생시킨 객체를 알아낸다.
		Object obj =  e.getSource();
		if(obj ==bt1) {
			jp2.setBackground(Color.red);
		}else if (obj == bt2){
			jp2.setBackground(Color.green);
		}else {
			jp2.setBackground(Color.blue);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == jp1) {
			System.out.println("jp1");
		}else if(obj == jp2) {
			System.out.println("jp2");
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
