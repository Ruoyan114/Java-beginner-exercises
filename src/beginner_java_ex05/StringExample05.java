package beginner_java_ex05;

//使用replaceAll可以进行基于正则表达式的替换：
public class StringExample05 {
    public static void main(String[] args) {
        String str = "apple1, banana2, cherry3";
        String replaced = str.replaceAll("\\d", ""); // 替换所有数字
        System.out.println(replaced); // 输出: apple, banana, cherry
    }
}
/*
以上代码示例涵盖了数组排序、查找最大/最小值以及字符串拼接、分割、替换的基本操作。
你可以根据实际需求进行调整和扩展。
 */