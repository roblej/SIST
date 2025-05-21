package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;
import java.util.TreeSet;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex8_Lotto extends JFrame implements ActionListener{
	//번호생성을 누르면 이미지 6개 랜덤으로 출력
	JPanel north_p, center_p;
	JButton bt;
	GridLayout gl;
	FlowLayout fl;
	ImageIcon icon;
	JLabel[] jb = new JLabel[6];
	StringBuffer sb;
	
	public Ex8_Lotto() {
		fl = new FlowLayout(FlowLayout.RIGHT);
		bt = new JButton("번호생성");
		gl = new GridLayout(1,6);
		
		north_p = new JPanel(fl);
		center_p = new JPanel(gl);
		
		
		north_p.add(bt);
		this.add(north_p,BorderLayout.NORTH);
		this.add(center_p,BorderLayout.CENTER);
		
		this.setBounds(300,300,720,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		bt.addActionListener(this);
		
	}
	
	//120x6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8_Lotto();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		Object obj = e.getSource();
		
		
		
		if(obj == bt) {
			center_p.removeAll();
			
			TreeSet<Integer> set= new TreeSet<>();
			
			while(set.size()<6) {
				set.add((int)(Math.random()*45+1));			
			}
			
			Iterator<Integer> it = set.iterator();
			
			while(it.hasNext()) {
				int i=0;
				int num = it.next();
				sb = new StringBuffer();
				
				Formatter fm = new Formatter(sb);
				fm.format("src/images/%d.gif",num);
				
				icon= new ImageIcon(sb.toString());
				jb[i] = new JLabel(icon); 
				center_p.add(jb[i]);
				i++;
			}
			center_p.updateUI();
//			center_p.revalidate();
			
		}
	}

}
//추가를 누르면 추가 or 취소만 클릭가능 enabled
//검색-> 검색,취소 삭제->삭제,취소