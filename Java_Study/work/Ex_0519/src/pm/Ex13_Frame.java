package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex13_Frame extends JFrame {
	
	public Ex13_Frame() {
		JButton bt1 = new JButton();
		bt1.setText("버튼1");
		JButton bt2 = new JButton();
		bt2.setText("버튼2");
		JButton bt3 = new JButton();
		bt3.setText("버튼3");
		JButton bt4 = new JButton();
		bt4.setText("버튼4");
		JButton bt5 = new JButton();
		bt5.setText("버튼5");
		
		this.add(bt1, BorderLayout.EAST);
		this.add(bt2, BorderLayout.NORTH);
		this.add(bt3, BorderLayout.WEST);
		this.add(bt4, BorderLayout.CENTER);
		this.add(bt5, BorderLayout.SOUTH);
		
		this.setTitle("버튼 5개 창:");
		this.setSize(500, 500);
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		Ex13_Frame f = new Ex13_Frame();
	}
}
