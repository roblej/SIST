package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_CardT extends JFrame implements ActionListener {

	ImageIcon icon;
	JLabel icon_lb;
	JPanel chat1_p1, chat2_p2;
	JPanel p1_south_p,s_p1,s_p2,p2_south_p;
	JTextField name_tf,input_tf;
	JTextArea ta;
	JButton login_bt, send_bt;
	
	CardLayout card;
	
	public Ex5_CardT() {
		//현재 창의 레이아웃을 CardLayout으로
		card = new CardLayout();
		this.getContentPane().setLayout(card);
		
		//첫번째 화면 작업
		chat1_p1 = new JPanel(new BorderLayout());
		icon = new ImageIcon("src/images/asd.png");
		icon_lb = new JLabel(icon);
		chat1_p1.add(icon_lb);
		
		s_p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		s_p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		s_p1.add(new JLabel("대화명:"));
		s_p1.add(name_tf = new JTextField(8));
		
		s_p2.add(login_bt = new JButton("   로그인   "));
		
		p1_south_p = new JPanel(new GridLayout(2,1));
		p1_south_p.add(s_p1);
		p1_south_p.add(s_p2);
		
		chat1_p1.add(p1_south_p,BorderLayout.SOUTH);
		
		this.getContentPane().add("chat1",chat1_p1);
		
		//두번째 화면
		chat2_p2 = new JPanel(new BorderLayout());
		chat2_p2.add(new JScrollPane(ta = new JTextArea()));
		
		p2_south_p = new JPanel(new BorderLayout());
		p2_south_p.add(input_tf = new JTextField());
		p2_south_p.add(send_bt = new JButton("보내기"),BorderLayout.EAST);
		
		chat2_p2.add(p2_south_p,BorderLayout.SOUTH);
		
		this.getContentPane().add("chat2",chat2_p2);
		
		
		send_bt.addActionListener(this);
		login_bt.addActionListener(this);
		//창사이즈
		this.setBounds(300, 300, 300, 400);
		this.addWindowListener(new Ex2_MyAdap());
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex5_CardT();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String text = name_tf.getText().trim();
		if(obj==send_bt) {
			card.show(this.getContentPane(), "chat1");
		}
		else
			if(text.length()>0)
				card.show(this.getContentPane(), "chat2");
			else
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요");
		}
}

