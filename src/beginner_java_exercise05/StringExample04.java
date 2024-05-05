package beginner_java_exercise05;

//字符串替换：使用String类的replace或replaceAll方法。
public class StringExample04 {
    public static void main(String[] args) {
        String str = "Hello, world!";
        String replaced = str.replace("world", "Java");
        System.out.println(replaced); //Hello, Java!
    }
}
