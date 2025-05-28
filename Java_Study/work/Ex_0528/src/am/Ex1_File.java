package am;

import java.io.File;

public class Ex1_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//자바에서 File객체는
		//파일 뿐만 아니라 폴더(디렉토리)를 객체화 시키는 클래스다
		//
		//실제 존재하지 않는 파일과 폴더도 객체화 시킬 수 있다.
		//그래서 존재여부 확인을 exists()로 구분할 수 있다.
		String path ="c:/my_study/sist/test/util"; //원하는 폴더의 경로
		
		File f = new File(path);
		if(f.exists()&&f.isDirectory()){
			System.out.println("폴더입니다");
			
			//폴더일 경우에는 폴더 안에 파일 또는 또다른 하위 폴더들이 있을 수 있다.
			//하위 목록들을 한번에 얻어낸다
//			String[] ar = f.list();
//			for(int i=0;i<ar.length;i++) {
//				System.out.println(ar[i]);
//			}
			File[] ar = f.listFiles();
			System.out.println("===============하위폴더들===============");
			for(int i=0;i<ar.length;i++) {
				if(ar[i].isDirectory())
					System.out.println(ar[i].getName());//문자열이 아니고 File객체다
			}
			System.out.println("===============하위파일들===============");
			for(int i=0;i<ar.length;i++) {
				if(ar[i].isFile())
					System.out.printf("%s(%dMB)\n",ar[i].getName(),(ar[i].length()/1024)/1024);
//					System.out.println(ar[i].getName()+"("+ar[i].length()+")");//문자열이 아니고 File객체다
			}
		}else {
			System.out.println("존재하지 않거나 폴더가 아닙니다");
		}
		
	}

}
