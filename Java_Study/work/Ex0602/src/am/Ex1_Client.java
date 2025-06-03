package am;

import java.io.IOException;
import java.net.Socket;

public class Ex1_Client {

	public static void main(String[] args) throws IOException {
		// 클라이언트는 소켓을 생성하는 그 자체가 접속하는 것이다.
		Socket socket = new Socket("192.168.10.99", 5555);
	}

}
