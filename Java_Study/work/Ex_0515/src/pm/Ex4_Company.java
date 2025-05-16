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
		
		Ex4_Emp emp3 = new Ex4_Emp("1245", "장산범", "주임", "총무");
		al.add(emp3);
		
		Ex4_Emp emp4 = new Ex4_Emp("1578", "정도현", "사장", "총무");
		al.add(emp4);
//		al에 넣는 이유 : 함수에서 생성한 변수는 함수가 끝나면 사라짐
//		그래서 멤버변수에 넣는것
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
		default:
			System.out.println("잘못된 입력값");
			System.exit(0);
		}return ans;
	}
	
	public String search(String info) {
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<al.size();i++) {
			boolean chk = false;
			switch(idx) {
			case 0: 
				if(al.get(i).getNum().equals(info)) {					
					chk = true;
				}
				break;
			case 1:
				if((al.get(i).getName()).contains(info)) {
					chk = true;
				}
				break;
			case 2:
				if(al.get(i).getPosition().contains(info)) {
					chk = true;
				}
				break;
			case 3:
				if(al.get(i).getDepartment().contains(info)) {
					chk = true;
				}
				break;
			}
			if(chk) {
			sb.append("사번: ");
			sb.append(al.get(i).getNum());
			sb.append(" 이름: ");
			sb.append(al.get(i).getName());
			sb.append(" 직책: ");
			sb.append(al.get(i).getPosition());
			sb.append(" 부서: ");
			sb.append(al.get(i).getDepartment());
			sb.append("\r\n");
			}
		}
		if(sb.isEmpty()) {
			sb.append("사용자가 존재하지 않습니다");
		}
		return sb.toString();
	}
}

