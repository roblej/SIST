package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Client {

	public static void main(String[] args) {
		// 일단 서버로 보낼 메세지를 스케너를 통해 받는다.
		Scanner scan = new Scanner(System.in);
		System.out.println("보낼 메세지:");
		String msg = scan.nextLine();
		
		try {
			//서버 접속
			Socket s = new Socket("192.168.0.2", 5555);
			
			// 서버로 메세지를 보내기 위해 스트림 생성(나의 분신과 연결됨)
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			
			// 접속을 끊을 때는 스트림 닫기
			bos.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
