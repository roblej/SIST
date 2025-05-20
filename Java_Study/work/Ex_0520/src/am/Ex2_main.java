package am;

public class Ex2_main {
	
	public void test(Ex2_Inter n) {
//		inter을 구현한 객체는 모두 getvalue를 재정의함
//		그러므로 무조건 getvalue 호출
		n.getValue();
	}
	
	public static void main(String[] args) {
//		인터페이스는 추상메서드(미환성적 개념)이 있어 직접
//		인스턴스를 생성할 수 없다.
//		Ex2_Inter it = new Ex2_Inter(); //오류
		
//		인터페이스는 다른 클래스로 부터 구현하도록 해야한다.
		Ex2_Class c = new Ex2_Class();
//		System.out.println(c.getValue());
		Ex2_Impl it = new Ex2_Impl();
//		System.out.println(it.getValue());
//		System.out.println("====================");
		Ex2_main main = new Ex2_main();
		main.test(c);
		main.test(it);
	}
}
