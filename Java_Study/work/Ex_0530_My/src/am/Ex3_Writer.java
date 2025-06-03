package am;

import java.io.File;
import java.io.PrintWriter;

public class Ex3_Writer {
	public static void main(String[] args) {
		PrintWriter pw = null;
		File selectedFile = new File("C:/Users/TEN/Documents/GitHub/SIST/io_test/inputTest.txt");
		try {
			pw = new PrintWriter(selectedFile);
			
			pw.write("금요일");
			pw.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(pw!=null)
				pw.close();
		}
	}
}
