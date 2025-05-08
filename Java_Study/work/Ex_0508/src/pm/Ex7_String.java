package pm;

public class Ex7_String {

	public static void main(String[] args) {
//		문자열 객체 생성
		String str = "SiST";//str이라는 변수에 "SiST"라는 문자열 저장
							//암시적 객체생성
		String str2 = new String("SiST"); // str2라는 변수에 "SiST"라는 문자열을 저장
										  //명시적 객체생
//		str2에는 String객체의 주소가 담겨있음 객체는 힙에담김. 힙에 담기면 주소가 있다.
//		Stack:가벼운 객체 저장(heap에 담긴 값의 주소) Heap:무거운 객체 저장(실제 string)
		if(str==str2) {
			System.out.println("같음");
		}else System.out.println("다름");
		
		if(str.equals(str2)) {//equals:대소문자까지비교 equalsignoreCase:대소문자무시
			System.out.println("같음");
		}else System.out.println("다름");
		
		
		String str3 = "SiST";
		if(str==str3) {
			System.out.println("같음");
		}else System.out.println("다름");
		/*
		문자열 즉, String객체는 생성법이 2가지로 나뉜다.명시적,암시적
		명시적 객체 생성법 : new 라는 키워드로 생성,무조건 새로운 객체 생성
		암시적 객체 생성법 : 그냥 ""로 된 문자열을 저장하며
		이는 앞서 같은 암시적 생성법으로 같은 내용을 만든 것이 있다면 재사용
		
		그리고 정말 특이한 것은
		자바의 String 객체는 불변적 특징을 가진다는 것이다.
		 */
	}

}
