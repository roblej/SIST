package hw;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowAdap	extends WindowAdapter {
	
	
	//WindowAdapter은 WindowListener을 구현하였으며 추상메서드들이
	//모두 Empty로 재정의 되어 현재클래스에서 의무적으로 재정의할
	//메서드가 없다
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
