package am;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3_GridLayout extends JFrame {

	JButton[] ar = new JButton[5];
	GridLayout gl;
	JPanel center_p;
	
	public Ex3_GridLayout() {
		center_p = new JPanel();
		gl = new GridLayout(3, 3,10,20 );//3행3열 즉, 9개의 셀이 만들어진다.
		center_p.setLayout(gl);//기본레이아웃이 FlowLayout이었던 것을 GridLayout으로 변경
		
		for(int i=0;i<ar.length;i++) {
			ar[i] = new JButton(String.valueOf(i+1));
			center_p.add(ar[i]);//center_p에 버튼객체 추가
			
		}
		for(int i=0;i<3;i++) {//3행3열의 모양을 유지하기 위해 공백을(JLabel로) 삽입
			center_p.add(new JLabel());
		}
		
		this.add(center_p);
		setBounds(300,200,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3_GridLayout();
	}

}
