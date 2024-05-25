package beginner_java_ex05;

//使用StringBuilder进行大量字符串拼接时更高效：
public class StringExample02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ");
        sb.append("world!");
        String concatenated = sb.toString();
        System.out.println(concatenated); //Hello, world!
    }
}