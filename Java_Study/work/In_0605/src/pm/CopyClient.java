package pm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread {

	Socket s;
	ChatServer server;
	
	//통신을 위한 스트림들
	ObjectOutputStream out;
	ObjectInputStream in;
	
	String ip, nickName;
	
	ChatRoom currentRoom;//현재 참여하고 있는 방! 만약 currentROom이 null이라면
						//현재 사용자는 대기실에 있는 것이다.
	
	public CopyClient(Socket s, ChatServer ChatServer) {
		this.s = s;
		this.server = ChatServer;
		
		// in/out스트림들 생성, ip도 얻어내야 한다.
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			ip = s.getInetAddress().getHostAddress();//접속자 IP
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//생성자의 끝

	@Override
	public void run() {
		// 현재 스레드는 서버에서 실제 클라이언트를 대신하면서
		// 언제, 어느 때에 원격에 있는 클라이언트가 서버로 메세지를 보낼지 모르므로
		// 항상 inputstream을 read를 수행하여 메세지가 올 때까지 기다려야 한다.
		bk:while(true) {
			try {
				// 스트림으로부터 객체를 읽어낸다.
				Object obj = in.readObject();//<<<<<<<<<<<<<<<<중요!!
				if(obj != null) {
					Protocol protocol = (Protocol) obj;
					//protocol의 cmd값이 뭐냐에 따라 작업의 구분을 구현한다.
					switch(protocol.getCmd()) {
						case 3:{
							//원격의 클라이언트에 있는 스레드를 소멸시키기 위해 
							//메세지 보내온 것이다.
							out.writeObject(protocol);
							out.flush();

							break bk;
						}
						case 1:
							// 서버에 접속한 경우는
							// 사용자가 입력한 대화명을 얻어내어 nickName에 저장한다.
							this.nickName = protocol.getMsg();
							//환영메세지를 보내기 위해 Ex3_Protocol객체 생성
							Protocol p = new Protocol();
							p.cmd = 1;
							//명단수집
							p.setUser_names(server.getNames());
							p.setRoom_names(server.getRoomNames());//방 목록 수집
							
							server.sendProtocol(p);//접속자 모두에게 전달!
							break;
						case 2:
							//채팅메세지
							// 메세지 앞에 nickName을 붙여서 msg에 다시 저장하자!
							System.out.println("2받음");
							protocol.setMsg(nickName+":"+protocol.getMsg());
							
							currentRoom.sendMsg(protocol);
							break;
						case 4:
							//방 만들기
							currentRoom = new ChatRoom(protocol.msg, server);
							server.r_list.add(currentRoom);
							server.u_list.remove(this);
							
							//대기실에서 현재CopyClient를 삭제
							server.removeClient(this);
							currentRoom.joinUser(this);
							
							break;
						case 5:
							//방나가기
							if(currentRoom != null){

							currentRoom.getOut(this);
							currentRoom=null;

//							out.writeObject(protocol);
							out.flush();


//							server.removeRoom(currentRoom);
							}

							
							break;
						case 6:
							//방 참여
							String name = protocol.getMsg();
							for(ChatRoom cr:server.r_list) {
								System.out.println(cr.roomName);
								if(cr.roomName.equals(name)){
									currentRoom=cr;
									break;
								}
							}
							
							server.removeClient(this);
							currentRoom.joinUser(this);
							
							
								
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//무한반복의 끝
		
		try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
			if(currentRoom!=null) {
				currentRoom.getOut(this);
			}else {
				//서버의 ArrayList에서 현재객체를 삭제한다.
				server.removeClient(this);
				
				//서버에 다른 접속자들에게 현재객체가 접속해제하다는 메세지를 보낸다.
				Protocol p = new Protocol();
				
				p.cmd = 1;
				p.setUser_names(server.getNames());
				
				server.sendProtocol(p);//접속자 모두에게 전달!
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getNickName() {
		return nickName;                 
	}

}