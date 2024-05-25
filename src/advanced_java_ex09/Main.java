package advanced_java_ex09;

/*
然后，我们在一个程序中抛出这个自定义异常：
 */
public class Main {
    public static void main(String[] args) {
        try {
            performOperation();
        } catch (InvalidOperationException e) {
            e.printStackTrace();
        }
    }

    public static void performOperation() throws InvalidOperationException {
        // 这里假设有一些操作
        boolean isValid = false; // 假设条件不满足，操作无效

        if (!isValid) {
            throw new InvalidOperationException("Invalid operation detected.");
        }

        // 如果isValid为true，则继续执行其他操作..

    }
}

/*
在这个程序中，我们定义了一个performOperation方法，它可能会抛出一个InvalidOperationException。
如果isValid为false，我们就抛出一个新的InvalidOperationException实例。在main方法中，我们调用performOperation，
并捕获可能抛出的InvalidOperationException。如果捕获到异常，我们就打印出异常的堆栈跟踪。
注意，performOperation方法的声明中包含了throws InvalidOperationException，这表示这个方法可能会抛出InvalidOperationException。
在调用这个方法的地方，我们需要处理这个可能的异常，要么通过try-catch块捕获它，要么在调用它的方法中也声明抛出这个异常。

 */