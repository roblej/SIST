package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame implements ActionListener {
	
	JPanel north_p,center_p;
	JButton bt;
	
	public Ex4_Frame() {
		
		//화면구성
		north_p = new JPanel();
		north_p.add(bt = new JButton("Color"));
		this.add(north_p,BorderLayout.NORTH);
		this.add(center_p = new JPanel(),BorderLayout.CENTER);
		
		
		
		
		this.setBounds(300, 300, 400, 500);
		this.setVisible(true);
		
		//이벤트감지자
		this.addWindowListener(new Ex2_MyAdap());
		bt.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Ex4_Dialog(this);
		
	}

}
