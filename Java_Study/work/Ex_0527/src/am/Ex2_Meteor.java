package am;

import java.awt.Rectangle;

public class Ex2_Meteor extends Thread {
//스스로 움직이는 운석을 의미하는 객체
	Rectangle rect = new Rectangle();
	int speed;
	
	//현재 운석객체는 Ex2_Frame정보를 가지고 있어야 한다. 이유는
	//그곳에 있는 ArrayList와 JPanel등을 접근해야 하기 때문이다.
	Ex2_Frame f;
	
	public Ex2_Meteor(Ex2_Frame f, int w, int h) {
		this.f=f;
		//받은 w와 h는 Rectangle에 저장한다.
		rect.width=w;
		rect.height=h;
		
		speed = (int)(Math.random()*200+20);
		
	}

	@Override
	public void run() {
		//무한반복을 통해 y값을 증가시킨다.
		//이때 화면 하단에 도달할 경우 무한반복 탈출
		while(true) {
			rect.y +=3;
			//화면하단에 도달했는지 확인
			if(rect.y>=f.p.getSize().height-rect.height) {
				break;//무한반복 탈출
			}
			
			
			//주인공과 현재 운석이 충돌했을 수도 있으므로 충돌검사 ㄱㄱ
			if(rect.intersects(f.me.rect)) {
				//운석충돌시 폭발이펙트
				System.out.println("end");
				break;
			}
				
				try {
					Thread.sleep(speed);
				} catch (Exception e) {
					// TODO: handle exception
				}
				f.p.repaint();
		}//무한반복의 끝
		f.m_list.remove(this);
		
		//Ex2_Frame에 있는 ArrayList에서 현재 운석객체를 찾아서 삭제
		
	}
}
