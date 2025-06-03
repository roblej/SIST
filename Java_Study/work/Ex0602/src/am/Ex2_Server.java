package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex2_Server {

	public static void main(String[] args) throws IOException {
		// 서버 준비
		ServerSocket ss = new ServerSocket(5555);
		System.out.println("Server start:"+ss.getLocalPort());
		
		Thread t = new Thread() {

			@Override
			public void run() {
				// 접속자를 받고 메세지를 하나 받기 위해 스트림을 준비하여
				// 읽기한 후 화면에 출력
				Socket s = null;//접속자의 정보
				BufferedInputStream bis = null;
				try {
					s = ss.accept();// 접속자가 올 때까지 대기!!!!!!!!!!
					
					// 접속자의 IP알아내기
					String clientIP = s.getInetAddress().getHostAddress();
					
					//접속자 보내오는 메세지를 받기위해 스트림 얻기
					bis = new BufferedInputStream(s.getInputStream());
										
					byte[] buf = new byte[2048];
					int size = -1;
					
					StringBuffer sb = new StringBuffer(clientIP);
					sb.append(":");
					while((size = bis.read(buf)) != -1) {
						String str = new String(buf, 0, size);
						sb.append(str);
					}
					//서버 콘솔창에 출력!
					System.out.println(sb.toString());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		};//스레드객체의 끝
		t.start();//스레드 시작
	}

}
