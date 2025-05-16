package pm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex5_Map {
	public static void main(String[] args) {
//		Map구조 :KEY와 값을 쌍으로 저장하는 구조
//		KEY들은 중복 불가능
		HashMap<Integer, String> map = new HashMap<>();
		
		String s1 = new String("SiST");
		String s2 = "SiST";
		String s3 = "쌍용교육센터";
		String s4 = "SiST";
		
		map.put(100, s1);
		map.put(300, s3);
		map.put(400, s4);
		map.put(200, s2);
//		map.put(300, s2);
		System.out.println(map.size());
		System.out.println("+============================+");
		String v1= map.get(300);
		System.out.println(v1);
//		map.remove(300);
		System.out.println(map.size());
		
		//키를 모를 경우에는 모든 키를 먼저 얻어낸다.
		Set<Integer> set = map.keySet();
		
//		Iterator<Integer> it = set.iterator();//반복자 얻어내기
		
		ArrayList<Integer> al = new ArrayList<>(set);
		Collections.sort(al);
		
		Iterator<Integer> it = al.iterator();//반복자 얻어내기
		
		while(it.hasNext()) {
			int key = it.next();//200or300or400
			String value = map.get(key);
			System.out.println(key);
			if(value.equals("쌍용교육센터")) {
				System.out.println(key);
			}
		}
	}
}
