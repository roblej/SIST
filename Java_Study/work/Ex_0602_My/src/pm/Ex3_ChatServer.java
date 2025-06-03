package pm;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Ex3_ChatServer {

ServerSocket ss;
	
	ArrayList<Ex3_CopyClient> list;//접속자들의 정보
	Thread thread = new Thread() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Socket s = ss.accept();
					
					Ex3_CopyClient cc = new Ex3_CopyClient(s,Ex3_ChatServer.this);
					
					list.add(cc);
					cc.start();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}//while
		}
		
	};
	public Ex3_ChatServer() {
		list = new ArrayList<>();// 접속자들이 저장될 곳
		try {
			ss = new ServerSocket(5555);
			System.out.println("서버 시작!");
			
			thread.start();//접속자들을 맞이하는 스레드 시작!
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeClient(Ex3_CopyClient cc) {
		list.remove(cc);
	}
	
	public void sendProtocol(Ex3_Protocol p) {
		for(int i=0; i<list.size(); i++) {
			//각 클라이언트 복사본들을 하나씩 얻어낸다.
			Ex3_CopyClient cc = list.get(i);
			try {
				cc.out.writeObject(p);//각 원본들에게 보낸다.
				cc.out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex3_ChatServer();
	}
}
