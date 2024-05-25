package advanced_java_ex08;

/*
最后，我们可以在main方法中调用这个divide方法，并处理可能出现的DivideByZeroException异常：
 */
public class Main {
    public static void main(String[] args) {
        try {
            int result = Division.divide(10, 0);
            System.out.println("结果是： " + result);
        } catch (DivideByZeroException e) {
            System.out.println("发生错误： " + e.getMessage());
        }
    }
}

/*
在这个例子中，当我们试图用10除以0时，divide方法会抛出一个DivideByZeroException异常。
这个异常被main方法中的catch块捕获，并打印出错误消息。如果我们尝试除以一个非零的数，那么就会正常计算出结果并打印出来。

 */