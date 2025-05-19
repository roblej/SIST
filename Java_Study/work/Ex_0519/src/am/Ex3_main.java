package am;

public class Ex3_main {
	public static void main(String[] args) {
		//원하는 객체 생성
		Ex3_TestRef c = new Ex3_TestRef();
		Ex3_Member m = new Ex3_Member();
		
		m.setName("SiST");
		System.out.println(m.getName());
		c.test(m);
		System.out.println(m.getName());
		
	}
}
