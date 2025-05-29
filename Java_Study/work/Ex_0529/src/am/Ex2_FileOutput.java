package am;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex2_FileOutput {
	public static void main(String[] args) {
		
		String path = "c:/my_study/sist/test/abc.txt";
		
		//위의 존재하지 않는 경로로 File객체 생성
		File f = new File(path);
		try {
			if(!f.exists()) {
				FileOutputStream fos = new FileOutputStream(f);
				//위 스트림을 생성하면 파일이 무조건 만들어진다
				//만약
				//같은 파일이 있다면 덮어쓰기가 된다
				
			}else {
				int cmd =
				JOptionPane.showConfirmDialog(new JFrame(), "덮어쓰기 하시겠습니까?",
						"경고",JOptionPane.YES_NO_OPTION);
//				System.out.println(cmd+":"+JOptionPane.YES_OPTION+":"+JOptionPane.CANCEL_OPTION);//yes:0 no:1 cancel:2
				if(cmd==JOptionPane.YES_OPTION) {
					System.out.println("덮어쓰기");
					FileOutputStream fos = new FileOutputStream(f);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
