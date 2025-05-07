package am;

public class Ex6_For {

public static void main(String[] args) {
	// 1~20까지 반복처리하는 반복문
	//단 3의 배수만 출력
	
	for(int i=1;i<=20;i++) {
		if(i%3==0) {
			System.out.println(i+"***");
		}else
			System.out.println(i);
	}
	
}

}
