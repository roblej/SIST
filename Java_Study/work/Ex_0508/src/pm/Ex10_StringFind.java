package pm;

public class Ex10_StringFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Kwon Sun Ae";
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치 : " + index);
		
		index = s1.indexOf("Sun");
		System.out.println("문자 Sun의 위치 : " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치 : " + index);
		
		char c = s1.charAt(index); // 문자 추출
		System.out.println("추출한 문자 : "+ c);
	}

}
