public class Main {
    public static void main(String[] args) {

        System.out.println(m(1,2,3));
    }

    static int m(int...x) {
        int b = 0;
        for(int a:x){
            b+=a;
        }
        return b;
    }
}
