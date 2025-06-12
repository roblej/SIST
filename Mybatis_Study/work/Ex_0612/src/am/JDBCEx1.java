package am;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCEx1 {

	public static void main(String[] args) {
		
		try {
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.DB연결객체 얻기
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","1111");
			
			//3.연결 객체로 부터 구문객체 얻기
			PreparedStatement pst = con.prepareStatement("select * from emp");
			
			//4.구문객체 실행하여 결과 받기
			ResultSet rs = pst.executeQuery();
			
			//5.받은 결과 처리
			ArrayList<EmpVO> list = new ArrayList<EmpVO>();
			while(rs.next()) {
				//컬럼을 하나씩 얻어낸다.
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String hiredate = rs.getString("hiredate");
				
				//원하는 객체로 생성한다.************
				EmpVO vo = new EmpVO();
				vo.setEmpno(empno);
				vo.setEname(ename);
				vo.setJob(job);
				vo.setHiredate(hiredate);
				
				list.add(vo);
			}//while의 끝
			System.out.println(list.size()+"명 검출");
			System.out.println(list.get(0).getEname());
			
			//6.리소스 닫기
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
