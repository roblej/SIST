package am;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Client {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("보낼 메세지:");
		String msg = scan.nextLine();
		
		try {
			Socket s = new Socket("192.168.0.2", 5555);
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			bos.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
