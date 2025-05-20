package am;

public class Ex3_main {
	
	public void test(Ex3_Inter n) {
		n.print();
		n.testValue();
	}
	
	public static void main(String[] args) {
		Ex3_Class t1 = new Ex3_Class();
		Ex3_Impl t2 = new Ex3_Impl();
		//현재 클래스가 가지고 있는 test 함수를 호출하기 위해
		//현재 객체 생성
		Ex3_main main = new Ex3_main();
		
		main.test(t1);
		main.test(t2);
		
		t1.getValue();
		t2.getvalue();
	}
}
