package beginner_java_ex07;

/*
在Java中，异常处理是程序设计中非常重要的部分，它允许我们在运行时检测和处理错误情况。
使用try-catch语句可以捕获和处理这些异常，确保程序的稳定性和健壮性。
下面是一个Java代码示例，它演示了如何处理除数为零和数组越界的异常：
 */
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int divisor = 0;
        // 尝试执行可能会抛出异常的代码
        try {
            // 可能会抛出ArrayIndexOutOfBoundsException
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // 处理数组越界异常
            System.out.println("数组越界异常：" + e.getMessage());
        } catch (ArithmeticException e) {
            // 处理除数为零的异常
            System.out.println("除数为零异常: " + e.getMessage());
        } catch (Exception e) {
            // 捕获其他类型的异常
            System.out.println("发生其他类型的异常: " + e.getMessage());
        } finally {
            // 无论是否发生异常，finally块中的代码都会执行
            System.out.println("程序继续执行...");
        }
    }
}

/*
在这个示例中，我们创建了一个try块，其中包含可能会抛出异常的代码。
catch块用于捕获并处理这些异常。对于每种类型的异常，我们有一个单独的catch块。
在这个例子中，我们分别处理了ArrayIndexOutOfBoundsException（数组越界）和
ArithmeticException（除数为零）两种异常。finally块是可选的，但它确保无论是否发生异常，
其中的代码都会被执行。这通常用于清理资源，比如关闭文件或网络连接。
请注意，在真实的应用程序中，你应该尽可能具体地处理异常，而不是使用通用的Exception类。
这样，你可以更准确地知道发生了哪种类型的异常，并据此采取相应的措施。同时，
对于可能抛出多种类型的异常的方法，你也可以考虑使用多个catch块来分别处理这些异常。
 */