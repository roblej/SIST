package am;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_FlowLayout extends JFrame  implements ActionListener{
	
	JPanel north_p;
	JButton bt1,bt2,bt3;
	FlowLayout fl;

	public Ex2_FlowLayout() {//객체가 생성될 때 단 한번 호출
							 //멤버변수에 대한 초기화를 목적
		north_p = new JPanel();
		
		bt1= new JButton("Left");
		bt2= new JButton("Center");
		bt3= new JButton("Right");
		
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		//버튼 3개를 가지는 north_p를 현재 창의 North영역에 추가한다.
		
		this.add(north_p,BorderLayout.NORTH);
		
		setBounds(300,100,500,400);//x,y,width,height
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bt1.addActionListener(this);//인자는 ActionListener을 구현한 객체의 주소
		bt2.addActionListener(this);//인자는 ActionListener을 구현한 객체의 주소
		bt3.addActionListener(this);//인자는 ActionListener을 구현한 객체의 주소
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();//클릭한 버튼의 문자열 얻기
		
		if(str.equals("Left")) {
			//버튼들을 왼쪽맞춤
			fl = new FlowLayout(FlowLayout.LEFT);
		}else if(str.equalsIgnoreCase("Right")) {//대소문자구분없이비교함 
			fl = new FlowLayout(FlowLayout.RIGHT);			
		}else {
			fl = new FlowLayout(FlowLayout.CENTER);
		}
		//위에서 만든 레이아웃을 다시 north_p에 적용시키자
		north_p.setLayout(fl);
		north_p.updateUI();
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2_FlowLayout();
	}


}
