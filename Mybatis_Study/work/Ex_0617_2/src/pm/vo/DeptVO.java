package pm.vo;

import java.util.List;

public class DeptVO {
    String deptno,dname,loc_code;
    LocVO lvo;

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc_code() {
        return loc_code;
    }

    public void setLoc_code(String loc_code) {
        this.loc_code = loc_code;
    }

    public LocVO getLvo() {
        return lvo;
    }

    public void setLvo(LocVO lvo) {
        this.lvo = lvo;
    }
}
