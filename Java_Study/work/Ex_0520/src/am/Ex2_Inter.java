package am;

public interface Ex2_Inter {
//	상수와 추상메서드만 정의할 수 있다.
	final int MAX_VALUE = 100; //final 안붙여도됨(자동) 상수는 이름을 모두 대문자
	
//	추상메서드는 일반메서드와 달리 body(중괄호)를 가지지 못한다.
	public int getValue(); //추상메서드
//	{
//		return MAX_VALUE;
//	}
}
