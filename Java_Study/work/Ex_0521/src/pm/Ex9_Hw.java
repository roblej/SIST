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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex9_Hw extends JFrame implements ActionListener{
	
	JPanel jp1,jp2;
	JPanel[] rp = new JPanel[4];
	JButton[] bt= new JButton[5];
	JLabel[] lb = new JLabel[4];
	JTextField[] jt = new JTextField[4];
	JTextArea ta;
	FlowLayout fl;
	GridLayout gl;
	String[] tag = {"전체","추가","검색","삭제","취소"};
	String[] tag2 = {"사번 :","이름 :","직책 :","부서코드 :"};
	
	final int TOTAL = 0;
	final int ADD = 1;
	final int SEARCH = 2;
	final int DELETE = 3;
	final int CANCEL = 4;
	
	int cmd=4;//현재 눌려진 버튼 값을 저장할 곳
	
	public Ex9_Hw() {
//		fl = new FlowLayout(FlowLayout.RIGHT);
//		gl = new GridLayout(4,2,10,30);
//		jp1= new JPanel(fl);
//		jp2 = new JPanel(gl);
		jp1= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp2 = new JPanel(new GridLayout(6,2,10,30));
		ta = new JTextArea();
		
		for(int i=0;i<bt.length;i++) {
			bt[i]=new JButton(tag[i]);
			bt[i].addActionListener(this);
			jp1.add(bt[i]);
		}
		
		for(int i=0;i<lb.length;i++) {
			if(i==0) {
				jp2.add(new JLabel());
			}
			rp[i]=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			lb[i]=new JLabel(tag2[i]);
//			jp2.add(lb[i]);
			jt[i] = new JTextField(8);
			rp[i].add(lb[i]);
			rp[i].add(jt[i]);
			
			jp2.add(rp[i]);
		}
		
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jp2,BorderLayout.WEST);
		this.add(new JScrollPane(ta),BorderLayout.CENTER);
		
		this.setBounds(300,300,600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void setButton() {
		for(int i=0;i<bt.length-1;i++) {
			bt[i].setEnabled(false);
		}
		
		switch(cmd) {
		case ADD:
			break;
		case SEARCH:
			for(int i=0;i<jt.length;i++) {
				jt[i].setEnabled(false);
			}
			jt[1].setEnabled(true);
			break;
		case DELETE:
			for(int i=0;i<jt.length;i++) {
				jt[i].setEnabled(false);
			}
			jt[0].setEnabled(true);
			break;
		case CANCEL:
			break;
		}
		
		bt[cmd].setEnabled(true);
		if(cmd==4) {
			for(int i=0;i<bt.length-1;i++) {
				bt[i].setEnabled(true);
				jt[i].setEnabled(true);
			}
		}

	}
	
	public void viewData() {
		// TODO Auto-generated method stub
		cmd = 4;
		//데이터를 불러서 ta에 표현
		setButton();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == bt[0]) {
			
		}else if(obj == bt[1]) {//add
			if(cmd==ADD) {
				viewData();
			}else {
				cmd=ADD;
				setButton();
			}
		}else if(obj == bt[2]) {//search
			if(cmd==SEARCH) {
				viewData();
			}else {
				cmd=SEARCH;
				setButton();
			}
		}else if(obj == bt[3]) {//delete
			if(cmd==DELETE) {
				viewData();
			}else {
				cmd=DELETE;
				setButton();
			}
		}else
			cmd=CANCEL;
			setButton();
//		for(int i=0;i<bt.length;i++) {
//			if(obj != bt[i]&&bt[i]!=bt[4]&&obj!=bt[0]) {
//				bt[i].setEnabled(false);
//				if(obj==bt[1]) {
//					for(int j=0;j<jt.length;j++) {
//						jt[j].setEnabled(true);
//					}
//				}else if(obj==bt[2]) {
//					for(int j=0;j<jt.length;j++) {
//						if(j==1) {
//							jt[j].setEnabled(true);
//						}else
//							jt[j].setEnabled(false);
//					}
//				}else if(obj ==bt[3]) {
//					for(int j=0;j<jt.length;j++) {
//					if(j==0) {
//						jt[j].setEnabled(true);
//					}else
//						jt[j].setEnabled(false);
//				}
//					
//				}
//			}//if
//		}//for문 끝
//		if(obj == bt[4]) {
//			for(int i=0;i<bt.length;i++) {
//				bt[i].setEnabled(true);
//				if(i<4)
//				jt[i].setEnabled(true);
//			}//for
//		}//if문 끝
	}
	
	
	
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex9_Hw();
	}


//전체/추가 는 다 검색은 이름 삭제는 사번





}
