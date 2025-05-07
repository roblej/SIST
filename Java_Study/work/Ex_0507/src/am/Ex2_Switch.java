package am;

public class Ex2_Switch {
	public static void main(String[] args) {
		//switch문의 구성
		/*
		 * switch(조건){
		 * 	case 비교값1:
		 * 		조건값이 비교값1과 같을때 수행;
		 * 		break;
		 * 	case 비교값2:
		 * 		조건값이 비교값2와 같을때 수행;
		 * 		break;
		 * 	case 비교값n:
		 * 		조건값이 비교값n과 같을때 수행;
		 * 		break;
		 * 	default:
		 * 		조건값과 모든 비교값이 일치하지 않을때 수행;
		 * 		마지막에는 break문 생략 가능
		 * }
		 * 
		 * 문제)1~3까지 수들 중 난수를 발생시켜 변수 su에 저장
		 * 난수가 1일 경우 "초급"출력
		 * 2일 경우 "중급" 출력
		 * 3일 경우 "고급" 출력
		 */
		
		int su = (int)(Math.random()*3+1);
		System.out.println(su);
		switch(su){
		case 1:
			System.out.println("초급");
			break;
		case 2:
			System.out.println("중급");
			break;
		case 3:
			System.out.println("고급");
			break;
		default:
			System.out.println("1~3의 값이 아닌 경우!");
		}
	}
}
