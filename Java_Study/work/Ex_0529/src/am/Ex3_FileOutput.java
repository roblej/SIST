package am;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex3_FileOutput {

	public static void main(String[] args) {
		// 파일에 저장할 문자열
		String str = "Test입니다.-파일에 저장할 문자열 \n12345";
		File f = new File("c:/my_study/sist/test/abc.txt");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			
			//준비된  OutputStream을 통해 쓰기를 수행한다.
			//먼저 저장할 문자열을 byte형 배열로 변환
			byte[] ar = str.getBytes();
			fos.write(ar, 0, ar.length);
			fos.flush();//스트림을 비우는 동작
			//즉, 스트림에 있는 자원들을 지금 당장 방출하라
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
