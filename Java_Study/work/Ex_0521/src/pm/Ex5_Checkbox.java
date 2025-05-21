package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex5_Checkbox extends JFrame implements ActionListener, ItemListener{
	
	JPanel north_p,center_p;
	JButton bt;
	JCheckBox ch1,ch2,ch3;
	GridLayout gl;
	FlowLayout fl;
	
	public Ex5_Checkbox() {
		fl = new FlowLayout(FlowLayout.RIGHT);
		gl = new GridLayout(3,1);
		
		north_p = new JPanel(fl);
		center_p = new JPanel(gl);
		
		bt = new JButton("버튼");
		north_p.add(bt);
		bt.setEnabled(false);//비활성화
		
		ch1 = new JCheckBox("test1");
		ch2 = new JCheckBox("test2");
		ch3 = new JCheckBox("test3");		
		center_p.add(ch1);
		center_p.add(ch2);
		center_p.add(ch3);
		
		this.add(north_p, BorderLayout.NORTH);
		this.add(center_p,BorderLayout.CENTER);
		
		this.setBounds(300, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
//		ch1.addActionListener(this);
//		ch2.addActionListener(this);
//		ch3.addActionListener(this);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5_Checkbox();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		String str = e.getActionCommand();
//		Object obj = e.getSource();
//		boolean ch = false;
//		
//		if(obj == ch1) {
//			 ch = ch1.isSelected();	
//		}else if(obj == ch2) {
//			ch = ch2.isSelected();				
//		}else
//			ch = ch3.isSelected();	
//			
//		if(ch) {
//			this.setTitle(str	);
//		}else
//			this.setTitle("");
//		
////		this.setTitle(str);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//이벤트를 발생시킨 객체가 뭔지는 모르지만
			//현재 이벤트를 감지하는 객체는 ch1,ch2,ch2가 되므로
			//그냥 이벤트 발생 객체의 문자열을 얻어내기
			Object obj = e.getSource();
			JCheckBox ch = (JCheckBox) obj;
			String str = ch.getActionCommand();
			setTitle(str);
		}else
			setTitle("");
	}

}
