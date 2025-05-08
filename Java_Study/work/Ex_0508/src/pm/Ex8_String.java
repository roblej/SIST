package pm;

public class Ex8_String {

	public static void main(String[] args) {
//		자바의 String 객체는 불변적 특징을 가졌다.
		
		String str = "SiST";
		
		String str2 = "SiST";
		
		str.concat("1234");
		System.out.println(str); //SiST뒤에 1234가 붙지 않음
		String str3 = str.concat("1234");
		System.out.println(str3);
		
		if(str == str3)
			System.out.println("서로 주소가 같다");
		else
			System.out.println("서로 주소가 다르다");
	}

}
