package am;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex1_Reader {

	public static void main(String[] args) {
		// 키보드와 연결된 스트림
		InputStream key = System.in;
		
		// 키보드로 부터 한줄단위로 읽기를 수행하기 위해 필요한 객체
		// 먼저 InputStream을 인자로 받아서 Reader로 변환하는 객체가 필요
		//InputStreamReader r = new InputStreamReader(key);
		//BufferedReader br = new BufferedReader(r);
		BufferedReader br = new BufferedReader(new InputStreamReader(key));
		
		try {
			System.out.println("입력:");
			String str = br.readLine();// 키보드로부터 입력받기 위해 대기한다.
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			if(br != null)
				br.close();
			} catch (Exception e) {}
		}

	}

}
