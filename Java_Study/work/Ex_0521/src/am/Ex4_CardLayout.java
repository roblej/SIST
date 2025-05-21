package am;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex4_CardLayout extends JFrame implements ActionListener{

	JPanel card1, card2;
	ImageIcon icon1,icon2;
	JButton bt1,bt2;
	CardLayout cl;
	
	
	public Ex4_CardLayout() {
		//첫번째 화면 작업
		card1 = new JPanel();
		JLabel lb = new JLabel("첫번째 화면");
		card1.add(lb);
		icon1 = new ImageIcon("src/images/1.gif");
		JLabel lb2 = new JLabel(icon1);
		card1.add(lb2);
		
		bt1 = new JButton("다음");
		card1.add(bt1);
		
		card2 = new JPanel();
		JLabel lb3 = new JLabel("두번째 화면");
		card2.add(lb3);
		icon2 = new ImageIcon("src/images/2.gif");
		JLabel lb4 = new JLabel(icon2);
		card2.add(lb4);
		
		bt2 = new JButton("이전");
		card2.add(bt2);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
//		현재 창의 레이아웃을 카드레이아웃으로 변경한다.
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
//		현재 창 안에 각 카드들 등록한다.
		this.getContentPane().add("card1",card1);
		this.getContentPane().add("card2",card2);
		
//		cl.show(this.getContentPane(), "card2");
		
		setBounds(300,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4_CardLayout();	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==bt2) {
			cl.show(this.getContentPane(), "card1");
		}
		else
			cl.show(this.getContentPane(), "card2");
	}

}
