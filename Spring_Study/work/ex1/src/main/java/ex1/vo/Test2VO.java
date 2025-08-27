package ex1.vo;

public class Test2VO {
    private String  str;
    private int value;

    public Test2VO(String str) {
        System.out.println("test2VO");
        this.str = str;
    }
    public Test2VO(String str, int value) {
        System.out.println("test2VO 123");
        this.str = str;
        this.value = value;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
