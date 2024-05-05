package beginner_java_exercise03;

import java.util.Scanner;

/*
下面是Java代码示例，演示了如何使用条件语句（if-else和switch）以及循环结构（for和while）来解决一些问题，如判断一个数是奇数还是偶数，以及打印九九乘法表。
判断一个数是奇数还是偶数：
 */
public class OddOrEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " 是偶数。");
        } else {
            System.out.println(number + " 是奇数。");
        }

        scanner.close();
    }
}
