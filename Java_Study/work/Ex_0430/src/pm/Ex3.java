package pm;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int형 미만(byte, short) - 32비트 미만 끼리 연산하면 32비트로 자동 승격이 일어난다.
		
		byte b1 = 10;
		byte b2 = 7;
//		byte b3 = b1+b2; 자동 형변환에 의한 에러
		byte b3 = (byte)(b1+b2); //byte를 사용시 타입캐스팅 사용
		System.out.println(b3);
	}

}
