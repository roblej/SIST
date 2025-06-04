package pm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	ServerSocket ss;
	ArrayList<CopyClient> u_list;
	ArrayList<ChatRoom> r_list;
	
	Thread thread = new Thread(){

		@Override
		public void run() {
			while(true) {
				try {
					Socket s = ss.accept();
					CopyClient cc = new CopyClient(s,  ChatServer.this);
					
					u_list.add(cc);
					cc.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//while
		}
		
	};
	
	
	public ChatServer() {
		u_list = new ArrayList<>();
		try {
			ss = new ServerSocket(5555);
			System.out.println("서버시작!");
			
			thread.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void removeClient(CopyClient cc) {
		u_list.remove(cc);
	}
	
	public void removeRoom(ChatRoom rr) {
		r_list.remove(rr);
	}
	
	public void sendProtocol(Protocol p) {
		for(int i=0;i<u_list.size();i++) {
			CopyClient cc = u_list.get(i);
			
			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String[] getNames() {
		//ArrayList에 있는 요소들에게 이름을 받아서 배열화시킨다.
		
		String[] names = new String[u_list.size()];
		for(int i=0;i<u_list.size();i++) {
			names[i] = u_list.get(i).getNickName();
		}
		
		return names;
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
}
