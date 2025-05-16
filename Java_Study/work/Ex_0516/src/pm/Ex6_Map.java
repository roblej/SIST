package pm;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex6_Map {
	public static void main(String[] args) {
		//사원을 의미하는 객체 Emp를 준비하자
		Ex6_Emp e1 = new Ex6_Emp();
		e1.setEmpno("1000");
		e1.setEname("마루치");
		e1.setDept("개발팀");
		
		Ex6_Emp e2 = new Ex6_Emp();
		e2.setEmpno("2000");
		e2.setEname("홍범도");
		e2.setDept("아트");
		
		Ex6_Emp e3 = new Ex6_Emp();
		e3.setEmpno("3000");
		e3.setEname("셰리");
		e3.setDept("뮤직");
		/*		 
		HashMap<String, Ex6_Emp> map = new HashMap<String, Ex6_Emp>();
		
		map.put("1000", e1);
		map.put("3000", e3);
		map.put("2000", e2);
		 */
		
		//위 3개의 객체를 ArrayList에 저장
		ArrayList<Ex6_Emp> list = new ArrayList<Ex6_Emp>();
		list.add(e1);
		list.add(e3);
		list.add(e2);
		//사원정보들을 모두 가진 List 구조를 Map에 저장
		HashMap<String, ArrayList<Ex6_Emp>> map = new HashMap<String, ArrayList<Ex6_Emp>>();
		map.put("list", list); //Json으로 변환할때 좋음

		ArrayList<Ex6_Emp> al = map.get("list");
		
		for(int i=0;i<al.size();i++) {
			Ex6_Emp res = al.get(i);
			
			System.out.println(res.getEmpno());
			
		}
		/*
		 
		 String[] item = {"소나타","렉스톤","제규어"}
		 for(String n : item) <<<<<< item 배열 속 요소를 for문을 돌아
		 */
	}
}
