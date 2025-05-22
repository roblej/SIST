package pm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex2_MyAdap extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		//프로그램종료
		System.exit(0);
	}

}
