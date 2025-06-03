package am;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex1_Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(5555);
		System.out.println("Server started:"+ss.getLocalPort());
		
		Thread thread = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					Socket s = null;//접속자의 정보
					try {
						s = ss.accept();
					} catch (Exception e) {}
						// TODO: handle exception
						
						InetAddress ip = s.getInetAddress();
						String clientIP = ip.getHostAddress();
						System.out.println("접속자 IP:"+clientIP);
					
				}//while
			}
			
		};
		
		thread.start();
	}
}
