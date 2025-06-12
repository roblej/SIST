package am;

public class EmpVO {
	//emp테이블에서 필요로 하는 컬럼들을 멤버변수로 선언
	String empno,ename,job,hiredate,mgr;

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	// --- toString() 메서드 추가 시작 ---
    @Override
    public String toString() {
        return "EmpVO {" +
               "empno='" + empno + '\'' +
               ", ename='" + ename + '\'' +
               ", job='" + job + '\'' +
               ", hiredate='" + hiredate + '\'' +
               '}';
    }
    // --- toString() 메서드 추가 끝 ---
}
