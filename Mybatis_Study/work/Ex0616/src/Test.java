public class Test {
    int cnt;
    int sum;
    public int getCnt(int i){

            i++;
        if(i != 10){
            sum += getCnt(i);
            System.out.printf("%d회, sum:%d\r\n",i,sum);
        }else
            sum = i;

        return i;

    }
    public static void main(String[] args) {
        Test t = new Test();
        t.getCnt(t.cnt);
        System.out.printf("합:%d", t.sum);
    }
}
