package pm;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex6_AddDialog extends JDialog {

	Ex6_Frame f;
	
	JTextField empno_tf, ename_tf, pos_tf, hdate_tf, deptno_tf;
	JPanel p1, p2, p3, p4, p5, p6;
	JButton ok_bt, cancel_bt;
	
	public Ex6_AddDialog(Ex6_Frame f) {
		this.f = f;
		
		// 현재 대화창의 레이아웃을 그리드레이아웃으로 변경
		this.setLayout(new GridLayout(6, 1));
		
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p6 = new JPanel();//가운데 정렬
		
		// 사번파트
		p1.add(new JLabel("사번:"));
		p1.add(empno_tf = new JTextField(8));
		
		p2.add(new JLabel("이름:"));
		p2.add(ename_tf = new JTextField(8));
		
		p3.add(new JLabel("직책:"));
		p3.add(pos_tf = new JTextField(8));
		
		p4.add(new JLabel("입사일:"));
		p4.add(hdate_tf = new JTextField(8));
		
		p5.add(new JLabel("부서코드:"));
		p5.add(deptno_tf = new JTextField(8));
		
		p6.add(ok_bt = new JButton("추가"));
		p6.add(cancel_bt = new JButton("취소"));
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		
		this.setBounds(400, 200, 200, 280);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();//현재 창객체만 메모리에서 삭제
			}
		});
		
		ok_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 추가하고자 하는 사원의 정보들을 모두 가져온다.
				String empno = empno_tf.getText().trim();
				if(empno.length() < 1) {
					//경고창
					JOptionPane.showMessageDialog(
						Ex6_AddDialog.this, "사번을 입력하세요");
					empno_tf.setText("");//청소
					empno_tf.requestFocus();// 커서 가져다 놓기
					return;
				}
				
				String ename = ename_tf.getText().trim();
				String pos = pos_tf.getText().trim();
				String hdate = hdate_tf.getText().trim();
				String deptno = deptno_tf.getText().trim();
				
				f.addData(empno, ename, pos, hdate, deptno);// Ex6_Frame에 있는
				// ArrayList에 사원객체를 저장한 후 JTable에 표현하고 돌아온다.
				dispose();
			}
		});
		
		cancel_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 취소
				dispose();
			}
		});
	}
}







