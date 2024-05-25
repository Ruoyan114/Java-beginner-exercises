package advanced_java_ex16;

import java.io.IOException;

/*
在Java中，如果你想要捕获一个异常，并基于该异常抛出一个新的异常，同时保留原始异常的信息，你可以使用构造器将原始异常作为参数
传递给新异常。这被称为异常链。以下是一个简单的代码示例，演示了如何实现这一功能：
 */
public class ExceptionChainDemo {
    public static void main(String[] args) {

        try {
            // 假设有一个可能抛出异常的方法
            someMethodThatThrowsException();
        } catch (IOException e) {
            // 捕获到IOException后，抛出一个自定义的RuntimeException，同时保留原始异常信息
            throw new MyCustomRuntimeException("A custom error occurred", e);
        }
    }

    public static void someMethodThatThrowsException() throws IOException {
        // 模拟一个可能抛出IOException的场景
        throw new IOException("An I/O error occurred");
    }

    // 自定义运行时异常，用于包装原始异常
    static class MyCustomRuntimeException extends RuntimeException {
        public MyCustomRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

/*
在这个例子中，someMethodThatThrowsException方法模拟了一个可能抛出IOException的场景。在main方法中，我们尝试调用这个方法，
并在catch块中捕获IOException。一旦捕获到IOException，我们立即抛出一个新的MyCustomRuntimeException，
同时传递原始异常e作为新异常的cause参数。MyCustomRuntimeException类继承自RuntimeException，
并重写了其构造器以接受一个消息字符串和一个Throwable类型的cause。这样，当新的异常被抛出时，它会包含原始异常的信息。
通过这种方式，当你查看异常堆栈跟踪时，你可以看到原始异常和新异常的信息，从而更容易地理解和调试问题。
注意：在生产代码中，通常最好避免抛出RuntimeException，除非确实需要。如果可能的话，最好使用检查型异常（checked exceptions），
并在方法的签名中声明它们，这样调用者就知道需要处理这些异常。
 */
