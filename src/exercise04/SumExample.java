package exercise04;

/*
在Java中，我们可以定义自己的方法来接受参数并返回值。下面是一个计算两个整数之和的简单例子：
 */

public class SumExample {
    // 定义一个方法，用于计算两个整数的和
    public static int sum(int a, int b) {
        // 计算两个数的和
        int result = a + b;
        // 返回结果
        return result;
    }

    public static void main(String[] args) {
        // 调用sum方法，并传入两个整数参数
        int sumResult = sum(5, 10);
        // 打印结果
        System.out.println("两数之和为: " + sumResult);
    }
}

/*
在这个例子中：
我们定义了一个名为sum的静态方法，它接受两个整数参数a和b。
在方法体内，我们计算两个参数的和，并将结果存储在变量result中。
然后我们使用return语句返回这个结果。
在main方法中，我们调用sum方法，并传入两个整数5和10作为参数。
我们将返回的结果存储在变量sumResult中，并打印出来。
当你运行这个程序时，它将在控制台输出：“两数之和为: 15”。
记住，在Java中，方法可以有不同的访问修饰符（如public、private等），
返回类型（包括void，表示不返回任何值），以及任意数量的参数。通过定义和使用方法，
我们可以将代码组织成可重用的块，这有助于编写更清晰、更易于维护的程序。
 */