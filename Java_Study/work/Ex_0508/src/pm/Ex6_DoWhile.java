package pm;

public class Ex6_DoWhile {

	public static void main(String[] args) {
		// do while문의 구성
		/*
		 do{
		 	실행할 문장들;
		 }while(조건식);<--세미콜론 잊지말기
		 
		 앞서 배운 for와 while문과 다륵 선처리 후비교
		 무조건 한번은 수행하는 형태다
		 
		 : '@'문자를 5번 반복하는 문장을 do while로 구현하자
		 */
		int i=0;
		do {
			System.out.printf("%-2c",'@');
			i++;
			if(i%3==0) break;
		}while(i<5);
		
		System.out.println("\n---------------------------");
//		1~10까지 반복수행. 이 때 3의 배수는 출력xz
		
		i = 1;
		do {
			if(i%3!=0) 
				System.out.printf("%d\s",i);
			i++;
		}while(i<=10);
		
		System.out.println("\n---------------------------");
		
		int k = 0;
		do {
			k++;
			if(k%3 == 0 || k>10) 
				continue;
			
			System.out.printf("%d\s",k);
		}while(k<=10);
	}

}
