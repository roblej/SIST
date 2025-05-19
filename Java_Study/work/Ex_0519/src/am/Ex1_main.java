package am;

public class Ex1_main {
	public static void main(String[] args) {
		int value = 100;//인자 생성
		
		Ex1_Value v1 = new Ex1_Value();//객체 생성
		v1.test(value);//test호출
		
		System.out.println(value);//test에서 n은 1을 증가했지만, 반환과정에서 소멸. value는 여전히 100
	}
}
