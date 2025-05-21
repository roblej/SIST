package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex1_GuguDan extends JFrame implements ActionListener {

	JButton[] bt_ar;
	JPanel north_p;
	JTextArea jt;
	
	public Ex1_GuguDan() {
		north_p = new JPanel();
		bt_ar=new JButton[8];
		jt = new JTextArea();
		
		JScrollPane jp = new JScrollPane(jt);
		
		for(int i=0;i<bt_ar.length;i++) {
//			StringBuffer sb = new StringBuffer();
//			sb.append(i+2);
//			bt_ar[i]= new JButton(sb.toString());
			bt_ar[i]= new JButton(String.valueOf(i+2));//Static메소드라 생성하지 않고 사용가능 System.out~도 마찬가지 ststic
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
		new Ex1_GuguDan();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		int dan = Integer.parseInt(str);
		StringBuffer sb = new StringBuffer(str);
		
		sb.append("단\r\n");
		sb.append("-----------------\r\n");
		
		Formatter fm = new Formatter(sb);
		
		for(int i=1;i<10;i++) {
			fm.format("%d*%d=%d\r\n",dan,i,dan*i);
		}
		
		jt.setText(sb.toString());
		
		
//		for(int j=1;j<10;j++) {
//			sb.append(str);
//			sb.append("*");
//			sb.append(j);
//			sb.append("=");
//			sb.append(dan*j);
//			sb.append("\r\n");
//		}
//		jt.setText(sb.toString());
		
		
		
		
//		jt.setText(str);
//		jt.append("단\r\n");
//		jt.append("-----------------\r\n");
//		for(int j=1;j<10;j++) {
//			jt.append(str);
//			jt.append("*");
//			jt.append(String.valueOf(j));
//			jt.append("=");
//			jt.append(String.valueOf(dan*j));
//			jt.append("\r\n");
//		}
//		jt.setText(sb.toString());
		
//		jt.setText(str);
//		jt.append(str);
		
//		내가 짠 코드
//		Object obj = e.getSource();
//		StringBuffer sb = new StringBuffer();
//		for(int i=0;i<bt_ar.length;i++) {
//			if(obj==bt_ar[i]) {
//				sb.append(i+2);
//				sb.append("단\r\n");
//				sb.append("-----------------\r\n");
//				for(int j=1;j<10;j++) {
//					sb.append(i+2);
//					sb.append("*");
//					sb.append(j);
//					sb.append("=");
//					sb.append((i+2)*j);
//					sb.append("\r\n");
//				}
//			}
//		}
//		jt.setText(sb.toString());
		
	}

}
