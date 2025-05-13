package am;

import java.util.Scanner;

public class Ex2_main {
	public static void main(String[] args) {
		String name;
		int age;;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("이름을 입력 :");
		name = scan.nextLine();
		System.out.print("나이를 입력 :");
		age = scan.nextInt();
		
		
		Ex2_Pet p1 = new Ex2_Pet(); 
		p1.setInfo(name, age);
		String returnName = p1.getName();
		int returnAge = p1.getAge();
		System.out.printf("Name:%s, Age:%d\n",returnName,returnAge);
		System.out.println("펫의 이름 :"+returnName);
		System.out.println("펫의 나이 :"+returnAge);
		
		p1.setInfo("포동이", 2);
		returnAge = p1.getAge();
		returnName = p1.getName();
		System.out.printf("Name:%s, Age:%d",returnName,returnAge);
		
		Ex2_Pet p2 = new Ex2_Pet();
		
		p2.setInfo("바둑이", 5);
		
		String name1 = p2.getName();
		int age1 = p2.getAge();
		
		System.out.printf("Name:%s, Age:%d\n",name1,age1);
	}
}
