package am;

public class Ex3_String {
	public static void main(String[] args) {
		String str = "안녕하세요! 금요일이군요.";
		int size = str.length();
		
//		str이 기억하고 있는 문자열에서 "하"가 있는 위치를 반환
//		index값(정수)을 알아내자!
		int idx = str.indexOf("하");
		System.out.println("str.indexOf(\"하\") : "+idx);
		
		//"요"의 위치를 찾아보자!
		int idx2 = str.indexOf("요"); //첫번째 "요"를 찾음
		int idx3 = str.indexOf("요", idx2+1);
		System.out.println("str.indexOf(\"요\") : "+idx3);
		
		int idx4 = str.lastIndexOf("요"); // 검색을 뒤에서부터 시작,하지만 index는 앞에서부터
		System.out.println("str.lastIndexOf(\"요\") : "+idx4);
		System.out.println("===========================");
		
		String file_name ="   Ex1.java    "; //외부에서 인자로 받았다고 가정,내용은 모른다고 가정
		String t_fname = file_name.trim();
//		받은 파일이 자바파일 또는 텍스트 파일인지 판단하자
		if(t_fname.endsWith(".java")||t_fname.endsWith(".txt"))//trim 공백제거
			System.out.println("자바 또는 텍스트파일입니다");
		else
			System.out.println("다른 파일ㅇ ㅣㅂ니다");
		
		//a를 찾아서 *로 변경하자
		String ss = t_fname.replaceAll("a", "*");
		System.out.println(t_fname);
		System.out.println(ss);
		int ar[] = new int[10];
		int ar_len = ar.length;
	}
}
