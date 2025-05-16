package am;

import java.util.HashSet;
import java.util.Iterator;

public class Ex2_Set {
	public static void main(String[] args) {
//		index가 없음,중복허용X
		HashSet<String> set = new HashSet<>();
		
		String s = new String("SiST");
		String s1 = "SiST";
		
		set.add(s);
		set.add(s1);
		set.add("123");
		set.add("abc");
		set.add("SiST");
		
		
		System.out.println(set.size());//new로 생성해도 내용이 같으면 중복처리
		System.out.println(set);
		
		//Set구조의 요소들을 반복처리하기 위해서는 Iterator(반복자)를 사용해야한다.
		//먼저 set구조로 부터 Iterator을 얻어낸다.
		Iterator<String> it = set.iterator();
		while(it.hasNext()){ // haseNext()는 현재 커서(반복자)의 위치에서 바로
							 // 다음 요소에 자원이 있다면 true, 없다면 false
			String n = it.next(); // next()는 다음 요소로 이동하여 그 자리에 있는
								  // 객체를 반환한다. 그것을 변수 n에 저장
			System.out.println(n);
		}
	}
}
