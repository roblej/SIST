package am;

public class Ex3_Switch {
	public static void main(String[] args) {
		//1~12까지의 난수를 발생시켜 월의 값으로 가정
		//해당 월의 최대 날짜 수를 출력
		int month = (int)(Math.random()*12+1);
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println("31일 까지 입니다");
			break;
		case 4,6,9,11:
			System.out.println("30일 까지 입니다");
			break;
		case 2:
			System.out.println("28일 까지 입니다");
			break;
		default:
			System.out.println("error");
			
		}
	}
}
