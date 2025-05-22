package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_Card extends JFrame implements ActionListener {
	
	CardLayout cl;
	GridLayout gl = new GridLayout(2,1);
	JLabel  jl1,jl2;
	JButton bt1,bt2;
	JPanel card1,card2,jp1,jp2;
	JTextField tf1,tf2;
	JTextArea ta;
	ImageIcon icon;
	
	public Ex5_Card() {
		
		card1 = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel(gl);
		
		
		icon = new ImageIcon("src/images/asd.png");
		JLabel lbicon = new JLabel(icon);
		jp1.add(lbicon);
		
		JPanel jplog = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jl1 = new JLabel("대화명:");
		tf1 = new JTextField(9);
		jplog.add(jl1);
		jplog.add(tf1);
		bt1 = new JButton("로그인");
		
		jp2.add(jplog);
		jp2.add(bt1);
		card1.add(jp1,BorderLayout.CENTER);
		card1.add(jp2,BorderLayout.SOUTH);
		
		
		card2 = new JPanel();
		ta = new JTextArea();
		JPanel tap = new JPanel();
		tap.add(ta);
		JPanel text = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		tf2 = new JTextField(15);
		bt2 = new JButton("보내기");
		text.add(tf2);
		text.add(bt2);
		card2.add(tap,BorderLayout.CENTER);
		card2.add(text,BorderLayout.SOUTH);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		cl = new CardLayout();
		this.getContentPane().setLayout(cl);
		this.getContentPane().add("card1",card1);
		this.getContentPane().add("card2",card2);
		
		this.setBounds(300, 300, 300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new Ex5_Card();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		 TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==bt2) {
			cl.show(this.getContentPane(), "card1");
		}
		else
			cl.show(this.getContentPane(), "card2");
		}
	
}
