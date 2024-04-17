package exercise05;

//字符串分割：使用String类的split方法。
public class StringExample03 {
    public static void main(String[] args) {
        String str = " apple,banana,cherry  ";
        String[] fruits = str.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit.trim()); //输出: apple, banana, cherry (trim()去除前后空格)
        }
    }
}
