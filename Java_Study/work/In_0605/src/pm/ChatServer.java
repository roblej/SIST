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
		u_list = new ArrayList<>();//대기자들이 접속하면 저장될 곳
		r_list = new ArrayList<ChatRoom>();//방이 만들어지면 저장될 곳
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
		
		//대기실 명단과 방 목록을 갱신하도록 프로토콜 작업
		Protocol p = new Protocol();
		p.setCmd(1);
		p.setUser_names(getNames());
		//방 목록 수집
		p.setRoom_names(getRoomNames());
		
		//대기실 모두에게 전달
		sendProtocol(p);
	}
	public void addClient(CopyClient cc) {
		u_list.add(cc);

		//대기실 명단과 방 목록을 갱신하도록 프로토콜 작업
		Protocol p = new Protocol();
		p.setCmd(1);
		p.setUser_names(getNames());
		//방 목록 수집
		p.setRoom_names(getRoomNames());

		//대기실 모두에게 전달
		sendProtocol(p);
	}
	
	public void removeRoom(ChatRoom rr) {
		if(rr.ru_list.size()<1)
			r_list.remove(rr);
		
		Protocol p = new Protocol();
		
		p.setCmd(1);
		p.setUser_names(getNames());
		p.setRoom_names(getRoomNames());//방 목록 수집
		
		sendProtocol(p);//접속자 모두에게 전달!

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
	
	public String[] getRoomNames() {
		//ArrayList에 있는 요소들에게 이름을 받아서 배열화시킨다.
		
		String[] names = new String[r_list.size()];
		int i=0;
		for(ChatRoom cr:r_list) {
			//채팅방 객체를 하나씩 얻어내어 방 제목을 수집한다.
			names[i++] = cr.roomName;
		}
		
		return names;
	}
	
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
}
