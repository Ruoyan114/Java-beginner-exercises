package advanced_java_exercise08;

/*
以下是一个简单的Java代码示例，演示了如何编写一个除法方法，并在除数为0时抛出一个自定义异常。
首先，我们定义一个自定义异常类DivideByZeroException，它继承自Java的内置异常类Exception：
 */
public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}
