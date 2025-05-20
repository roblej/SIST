package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex8_Frame extends JFrame implements ActionListener {
	JButton[] bt_ar;
	JPanel north_p,center_p;
	JTextArea jt;
	
	public Ex8_Frame() {
		bt_ar=new JButton[8];
		north_p = new JPanel();
		center_p = new JPanel();
		jt = new JTextArea();
		JScrollPane jp = new JScrollPane(jt);
		
		for(int i=0;i<bt_ar.length;i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(i+2);
			bt_ar[i]= new JButton(sb.toString());
			bt_ar[i].addActionListener(this);
			north_p.add(bt_ar[i]);
		}
		
		this.add(north_p, BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);
		
		this.setTitle("구구단");
		this.setBounds(700, 300, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == bt_ar[0]) {
			System.out.println("test");
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<bt_ar.length;i++) {
			if(obj==bt_ar[i]) {
				sb.append(i+2);
				sb.append("단\r\n");
				sb.append("-----------------\r\n");
				for(int j=1;j<10;j++) {
					sb.append(i+2);
					sb.append("*");
					sb.append(j);
					sb.append("=");
					sb.append((i+2)*j);
					sb.append("\r\n");
				}
			}
		}
		jt.append(sb.toString());
	}

}
