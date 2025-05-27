package pm;

import java.awt.Point;

public class Ex3_Explosion {
//운석이 폭발하는 의미를 가지는 객체
	int size = 128;
	
	Point pt = new Point();
	
	//현재 객체가 하나 생성될때는 운석이 주인공이랑 충돌할 때이다.
	//이때 운석이 폭발하면서 사라져야함.
	//폭발 이미지는 총 27개, 이들은 Ex3_Frame에 배열로 미리 준비해둔다.
	//배열을 접근하는 index값을 준비하자!
	int index; //0
	int delay = 5;//반복수행이 delay만큼 될때 index를 증가
	int interval = delay;
	
	public boolean move_index() {
		if(interval==delay)
			index++;
			
		interval--;
		if(interval==0)
			interval = delay;
		
		//index값은 27이 되면 현재 함수는 폭발 이미지 27개를 모두
		//표현한 상태가 된다. 그래서 폭발이 끝났음을 알려야 한다.
		return index>=27;
	}
}
