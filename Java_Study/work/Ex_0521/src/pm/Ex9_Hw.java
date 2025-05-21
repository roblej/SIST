package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex9_Hw extends JFrame implements ActionListener{
	
	JPanel jp1,jp2,jp3;
	JButton[] bt= new JButton[5];
	JLabel[] lb = new JLabel[4];
	JTextField[] jt = new JTextField[4];
	JTextArea ta;
	FlowLayout fl;
	GridLayout gl;
	String[] tag = {"전체","추가","검색","삭제","취소"};
	String[] tag2 = {"사번","이름","직책","부서"};
	
	public Ex9_Hw() {
		fl = new FlowLayout(FlowLayout.RIGHT);
		gl = new GridLayout(4,2,10,30);
		jp1= new JPanel(fl);
		jp2 = new JPanel(gl);
		jp3 = new JPanel();
		ta = new JTextArea();
		
		for(int i=0;i<bt.length;i++) {
			bt[i]=new JButton(tag[i]);
			bt[i].addActionListener(this);
			jp1.add(bt[i]);
		}
		
		for(int i=0;i<lb.length;i++) {
			lb[i]=new JLabel(tag2[i]);
			jp2.add(lb[i]);
			jt[i] = new JTextField();
			jp2.add(jt[i]);
		}
		jp3.add(ta);
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jp2,BorderLayout.WEST);
		this.add(ta,BorderLayout.CENTER);
		
		this.setBounds(300,300,500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		for(int i=0;i<bt.length;i++) {
			if(obj != bt[i]&&bt[i]!=bt[4]) {
				bt[i].setEnabled(false);
			}//if
		}//for문 끝
		if(obj == bt[4]) {
			for(int i=0;i<bt.length;i++) {
				bt[i].setEnabled(true);
			}//for
		}//if문 끝
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex9_Hw();
	}


//전체/추가 는 다 검색은 이름 삭제는 사번





}
