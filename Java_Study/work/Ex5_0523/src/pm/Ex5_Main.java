package pm;

public class Ex5_Main {
	public static void main(String[] args) {
		Thread t1 = new Thread();//run함수가 비어있기 때문에 할 일이 없는 스레드임
		t1.start();//->run()수행
		
		Ex5_Thread t2 = new Ex5_Thread();
		t2.start();
		
		System.out.println("메인스레드");
	}
}
//일하는 스레드는 3개(main,t1,t2) 