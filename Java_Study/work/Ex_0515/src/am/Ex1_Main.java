package am;

public class Ex1_Main {
	public static void main(String[] args) {
		//원하는 객체 Ex1_Test를 생성하자!
//		객체가 생성될때 원하는 값으로 초기화하는 목적으로 생성자 사용		
		Ex1_Test t1 = new Ex1_Test();
		System.out.println("++++++++++++++++");
		Ex1_Test t2 = new Ex1_Test("wkdgks",5);
		t1.setAge(10);
		t1.setName("fhqmf");
		
		System.out.println(t1.getName());
		System.out.println(t1.getAge());
		System.out.println(t2.getName());
		System.out.println(t2.getAge());
	}
}
