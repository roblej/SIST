package am;

import java.util.Scanner;

public class Ex3_main {
	public static void main(String[] args) {
		String res;
		Ex3_Library lb = new Ex3_Library();
		lb.setAr();
		System.out.println("책 이름을 입력하세요");
		
		Scanner scan = new Scanner(System.in);
		String x = scan.nextLine();
		res = lb.search(x);
		if(res.trim().length()<1)
			System.out.println("검색된 정보가 없습니다.");
		else
			System.out.println(res);
	}
}