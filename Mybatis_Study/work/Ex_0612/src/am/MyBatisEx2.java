package am;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx2 {

	public static void main(String[] args) throws Exception {
		// 1)환경설정파일(conf.xml)과 연결된 스트림 생성
		Reader r = Resources.getResourceAsReader("am/config/conf.xml");
		
		// 2)필요한것은 SqlSession이지만
		// 이전에 sqlSession을 만들어주는 Factory를 생성해야한다
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3) 사용된 스트림 닫기
		r.close();
		//----------한번만 수행하는 것 --------원래 생성자에다 해야함
		
		// 4) SQL문장을 모두 호출 및 실행할 수 있는
		// SqlSession객체를 factory를 통해 얻어낸다.
		
		SqlSession ss = factory.openSession();
		
		// 5)호출하고자 하는 SQL문의 id를 인자로 전달하여 수행한다. 
		List<EmpVO> list = ss.selectList("emp.ido");
	

		// list가 비어있지 않은지 먼저 확인하는 것이 좋습니다.
		if (list != null && !list.isEmpty()) {
		    System.out.println("--- 조회된 사원 목록 ---");
		    for (EmpVO emp : list) {
		        // EmpVO 객체의 내용을 출력합니다.
		        // EmpVO 클래스에 toString() 메서드가 오버라이딩되어 있어야 편리합니다.
		        System.out.println(emp);
		    }
		    System.out.println("---------------------");
		} else {
		    System.out.println("조회된 사원 정보가 없습니다.");
		}
		
		
		System.out.println(list.size()+"명 검출");
		System.out.println(list.get(0).getMgr());
		
		List<deptVO> list1 = ss.selectList("dept.all");
		System.out.println(list1.size()+"명 검출");
		System.out.println(list1.get(0).getDeptno());
	}

}
