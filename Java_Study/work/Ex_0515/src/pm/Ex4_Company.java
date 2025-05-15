package pm;

import java.util.ArrayList;

public class Ex4_Company {
	//ArrayList
	ArrayList<Ex4_Emp> al = new ArrayList<Ex4_Emp>();
	int idx = 0;
	public void init(){
		Ex4_Emp emp1 = new Ex4_Emp("2134", "홍길동", "대리", "재무");
		al.add(emp1);
		
		Ex4_Emp emp2 = new Ex4_Emp("2158", "김홍도", "사원", "인사");
		al.add(emp2);
		
		Ex4_Emp emp3 = new Ex4_Emp("1245", "장산범", "주임", "건축");
		al.add(emp3);
		
		Ex4_Emp emp4 = new Ex4_Emp("1578", "정도현", "사장", "총무");
		al.add(emp4);
//		System.out.println(al.get(0).getName());
	}
	public String which(int n) {
		String ans = "";
		switch(n){
		case 1: 
			ans = "사번";
			break;
		case 2:
			ans = "이름";
			idx = 1;
			break;
		case 3: 
			ans = "직책";
			idx = 2;
			break;
		case 4:
			ans = "부서";
			idx = 3;
			break;
		}return ans;
	}
	
	public String search(String info) {
		StringBuffer sb = new StringBuffer();
		int i=0;
		//	
		
			switch(idx) {
			case 0: 
				for(i=0;i<al.size();i++) {
				if(al.get(i).getNum().equals(info)) {					
					break;
				}
				}
				break;
			case 1:
				for(i=0;i<al.size();i++) {
				if((al.get(i).getName()).equals(info)) {
					break;
				}
				}break;
			case 2:
				for(i=0;i<al.size();i++) {
				if(al.get(i).getPosition().equals(info)) {
					break;
				}
				}break;
			case 3:
				for(i=0;i<al.size();i++) {
				if(al.get(i).getDepartment().equals(info)) {
					break;
				}
				}break;
			default:
				System.out.println("사용자가 존재하지 않습니다");
				System.exit(0);
			}
		
		sb.append("사번: ");
		sb.append(al.get(i).getNum());
		sb.append(" 이름: ");
		sb.append(al.get(i).getName());
		sb.append(" 직책: ");
		sb.append(al.get(i).getPosition());
		sb.append(" 부서: ");
		sb.append(al.get(i).getDepartment());
			
		
		return sb.toString();
	}
}

