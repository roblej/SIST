package am;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex1_Reader {
	public static void main(String[] args) {
		InputStream key = System.in;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(key));
		
		try {
			System.out.println("입력:");
			String str = br.readLine();
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
