package pm;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient_my extends Thread{
	
	Socket s;
	ChatServer server;
	
	ObjectOutputStream out;
	ObjectInputStream in;
	
	String ip, nickName;
	
	public CopyClient_my(Socket s, ChatServer chatserver) {
		this.s = s;
		this.server = server;
		
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}//생성자의 끝

	@Override
	public void run() {
		// TODO Auto-generated method stub
		bk:while(true) {
			try {
				Object obj = in.readObject();
				if(obj != null) {
					Protocol_my protocol = (Protocol_my)obj;
					
					switch(protocol.getCmd()) {
					case 3:
						out.writeObject(obj);
						break bk;
					case 1:
						this.nickName = protocol.getName();
						Protocol_my p = new Protocol_my();
						p.cmd = 2;
						p.name = nickName;
						server.sendProtocol(p);
						break;
						
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}//while문의 끝
		
	}
}
