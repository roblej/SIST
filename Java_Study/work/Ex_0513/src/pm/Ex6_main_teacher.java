package pm;

import java.util.Scanner;

public class Ex6_main_teacher {

   public static void main(String[] args) {
      // 숫자야구게임을 하기 위해 필요한 객체(Ex6_BaseBall) 준비
      Ex6_Baseball_teacher bb = new Ex6_Baseball_teacher();
      
      bb.init();//컴퓨터가 가지는 수를 설정하자!
      String msg = bb.getCom();
      System.out.printf("com: %s\r\n", msg);
      System.out.println("---------------------------------");
      
      //키보드로부터 값을 받기위해 스케너 객체 생성
      Scanner scan = new Scanner(System.in);
      int cnt = 0;
      int s1 = 0;
      do {
         //반복 수행하는 곳!
         ++cnt;
         System.out.printf("%d차:", cnt);
         String str = scan.nextLine();//키보드로부터 한줄 입력받기!
         if(str.length() > 3) {
            System.out.println("3자 입력하셔야 합니다.");
            continue;
         }
         bb.setUser(str);// 사용자가 입력한 문자열을 숫자화 시켜서 user배열에 저장함
         
         s1 = bb.countStrike(); //스트라이크 수
         int b1 = bb.countBall(); // 볼의 수
         System.out.printf("\r\n%d차시도-%d스트라이크, %d볼\r\n", cnt, s1, b1);
      }while(s1 != bb.com.length);
      System.out.printf("%d차에 성공!-프로그램 끝",cnt);
   }

}
