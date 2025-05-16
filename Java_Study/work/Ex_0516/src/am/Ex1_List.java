package am;

import java.util.ArrayList;

public class Ex1_List {
//	List구조는 배열과 같이 index로 요소를 접근하고
//	중복된 값을 허용한다.
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		String s = new String("SiST");
		String s1 = "SiST";
//	저장기능
		list.add("SiST");
		list.add(s1);
		list.add("123");
		list.add("abc");
		list.add(s);
		System.out.println(list.size());
		
//		변수 s와 같은 객체가 어디에 저장되었는지? 알아보는 반복문
		for(int i=0;i<list.size();i++) {
//			ArrayList에서 하나씩 얻어내기
			String v1 = list.get(i);
			//주소비교
			if(v1 == s1) {
				System.out.printf("찾으시는 s가 index %d에 있습니다\n",i);
			}
		}
		System.out.println("---------------------------");
		if(list.contains(s1)) {
			int idx = list.indexOf(s1);
			System.out.println("s1이 존재");
			System.out.println(idx);
		}
		else
			System.out.println("s1이 존재하지않음");
		
	}
}
