package am;

public class Ex2_Main {
	public static void main(String[] args) {
		//내부클래스 생성 - 바깥쪽 클래스를 거쳐야 한다.
//		Ex2_Outer.Inner inner = new Ex2_Outer().new Inner(); // 아우터가 만들어지지 않았을때
		Ex2_Outer out = new Ex2_Outer();
		Ex2_Outer.Inner inner = out.new Inner();//아우터가 만들어졌을때
		inner.print();
		
	}
}
