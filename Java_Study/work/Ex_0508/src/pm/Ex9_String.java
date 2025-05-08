package pm;

public class Ex9_String {

	public static void main(String[] args) {
		// "ABCDE"를 기억하는 변수 str을 만들자
		String str = "ABCDE";
		String str3 = "DE";
		
		//문자열의 길이를 구하는 법
		int len = str.length();
		System.out.println(("str.length():"+len));
		
		//str에서 특정 위치(index)에 있는 문자를 얻어내자
		char ch = str.charAt(1);//두번재 문자 값 얻기
		System.out.println(ch);
		
		//str에서 특정 문자"BC"의 index값 찾기->1이 나와야함
		int index = str.indexOf("BC");
		System.out.println("str.indexOf(\"BC\"):"+index);
		
		//str에서 앞서 얻어낸 index로부터 3자를 추출
		String str2 = str.substring(index, index+3);
		System.out.println("str.substring(index, index+3):"+str2);
		boolean bool = str.endsWith(str3);
		System.out.println(bool);
		char[] chars = {'a', 'b'};
		String str4 = new String(chars);
        char[] data = {'J', 'A', 'V', 'A', ' ', '서', '울', '호', '랑', '!', '!'};

        // 문자 배열을 문자열로 변환하는 방법
        String str5 = String.copyValueOf(data);

        // 결과 출력
        System.out.println("변환된 문자열: " + str5);
        
        System.out.println(str5.indexOf('A'));
        
        String name = "홍길동";
        int age = 30;
        double height = 175.5;

        String formattedString = String.format("이름: %s, 나이: %d세, 키: %.2fcm", name, age, height);

        // 출력
        System.out.println(formattedString);
        
        System.out.println(formattedString.replace("이름","name"));
        
        int count = 0;
        String msg = ++count + "little, "+ ++count + "little, " + ++count + "little Indian";
        System.out.println(msg);
        
	}

}
