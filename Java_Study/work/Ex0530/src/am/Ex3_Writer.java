package am;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Ex3_Writer {

	public static void main(String[] args) {
		// 문자기반의 출력스트림
		PrintWriter pw = null;
		File selectedFile = new File("c:/my_study/test/123.txt");
		try {
			//pw =new PrintWriter("c:/my_study/test/123.txt");
			//pw = new PrintWriter(selectedFile);
			pw = new PrintWriter(new FileOutputStream(selectedFile));
			
			pw.write("와~~~~ 금요일이다");
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pw != null)
				pw.close();
		}
	}

}
