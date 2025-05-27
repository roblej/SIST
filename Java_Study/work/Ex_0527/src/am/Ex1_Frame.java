package am;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_Frame extends JFrame {

	Dimension d = new Dimension(390,590);
	
	//필요한 이미지를 선언
	Image back_img, me_img;
	
	JPanel p;
	Me me = new Me();
	
	public Ex1_Frame() {
		
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		
		p=new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// 배경그리기
				g.drawImage(back_img, 0, 0, this);
				
				//주인공그리기
				g.drawImage(me_img, me.rect.x, me.rect.y,this);
				
			}
			
		};
		init_game();//게임 초기화 함수 호출
		init_me_pos();
		
		this.setLocation(500, 250);
		this.pack();//내부에 들어온 컴포넌트들의 크기에 맞도록
					//현재 창의 사이즈를 설정 우린 창에 JPanel만 추가하므로
					//JPanel의 크기(Dimnention)에 맞춘다.
		
		this.setResizable(false);//창의 크기 조정 불가
		this.setVisible(true);
		//이벤트감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	private void init_game() {
		//크기 객체(Dimnetion)을 가지고 JPanel의 크기로 예약하자 
		p.setPreferredSize(d);
		
		//크기가 지정된 jpanel을 현재 창 가운데 추가(pack때문에 자동 사이즈 지정)
		this.add(p);
	}
	private void init_me_pos(){
		//주인공 이미지의 초기 위치를 지정하는 함수
		
		//주인공 이미지의 너비와 높이
		int imgWidth = me_img.getWidth(this);
		int imgHeight = me_img.getHeight(this);
		
//		System.out.printf("%d,%d",imgWidth,imgHeight);
		//me객체 안에 Rectangle의 x,y,width,height를 지정하자
		me.rect.x = (d.width-imgWidth)/2;
		me.rect.y =(d.height-imgHeight)-5;
		
		me.rect.width=imgWidth;//이 너비와 높이가 없어도 이미지는 구현됨
		me.rect.height=imgHeight;//하지만 운석객체와 주인공객체가 충돌하는지 확인할때 필요
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_Frame();

	}

}
