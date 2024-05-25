package beginner_java_ex03;

import java.util.Scanner;

public class SwitchStatementExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字（1-3）：");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("你选择了1");
                break;
            case 2:
                System.out.println("你选择了2");
                break;
            case 3:
                System.out.println("你选择了3");
                break;
            default:
                System.out.println("无效的选择");
        }

        scanner.close();
    }
}

/*
在这些例子中：
第一个例子使用了if-else语句来判断输入的整数是奇数还是偶数。
第二个例子使用了嵌套的for循环来打印九九乘法表。
第三个例子使用了switch语句来根据用户输入的数字输出不同的消息。
要运行这些程序，你需要将代码分别保存为OddOrEven.java、MultiplicationTable.java和
SwitchStatementExample.java文件，然后在命令行中使用javac命令编译它们，再使用java命令运行它们
 */