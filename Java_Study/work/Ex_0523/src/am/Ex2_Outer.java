package am;

public class Ex2_Outer {
	private String msg = "쌍용교육센터";
	
	class Inner{//내부클래스의 장점 : 바깥쪽 클래스의 멤버를 
				//자신의 것 처럼 사용이 가능하다.	
		int value = 100;
		public void print() {
			System.out.println(msg+":"+value);
			
		}
		
	}
}
