package beginner_java_ex03;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println(); //换行
        }
    }
}
