package exercise02;/*
下面是一个Java代码示例，该示例声明了不同类型的变量（int, double, char, boolean），
并对它们进行了赋值和运算：
 */

public class VariableTypes {
    public static void main(String[] args) {
        // 声明并初始化一个int类型的变量
        int intVar = 10;
        System.out.println("intVar的值是: " + intVar);

        // 声明并初始化一个double类型的变量
        double doubleVar = 20.5;
        System.out.println("doubleVar的值是: " + doubleVar);

        // 声明并初始化一个char类型的变量
        char charVar = 'A';
        System.out.println("charVar的值是: " + charVar);

        // 声明并初始化一个boolean类型的变量
        boolean booleanVar = true;
        System.out.println("booleanVar的值是: " + booleanVar);

        // 对int和double类型的变量进行运算
        int sum = intVar + 5;
        double product = doubleVar * 2;
        System.out.println("intVar加5的结果是: " + sum);
        System.out.println("doubleVar乘以2的结果是: " + product);

        // 对boolean类型的变量进行逻辑运算
        booleanVar = !booleanVar; // 逻辑非操作
        System.out.println("booleanVar的逻辑非结果是: " + booleanVar);
    }
}

/*
在这段代码中：
    intVar 是一个整数类型的变量，初始值为10。
    doubleVar 是一个双精度浮点类型的变量，初始值为20.5。
    charVar 是一个字符类型的变量，初始值为字符'A'。
    booleanVar 是一个布尔类型的变量，初始值为true。
    然后我们对intVar和doubleVar进行了基本的数学运算，并输出了结果。对于booleanVar，我们使用了逻辑非操作（!）来改变其值，并输出了结果。
    要运行这个程序，你需要将代码保存为 exercise02.VariableTypes.java 文件，然后在命令行中使用 javac 命令编译它，再使用 java 命令运行它。
 */
