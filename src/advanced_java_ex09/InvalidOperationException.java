package advanced_java_ex09;

/*
在Java中，我们可以通过扩展Exception类（或其子类）来创建自定义异常。下面是一个创建名为
InvalidOperationException的自定义异常类的例子，并在一个程序中抛出这个异常。
首先，我们创建自定义异常类InvalidOperationException：
这个类继承了Java内置的Exception类，并重写了其构造函数。你可以根据需要添加更多的构造函数或者方法。
 */
public class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
