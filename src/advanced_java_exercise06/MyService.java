package advanced_java_exercise06;
/*
在Java中，你可以通过定义一个新的注解类型来创建一个自定义注解。这个注解可以被用来标记需要记录日志的方法。以下是一个简单的例子：
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
在上述代码中，我们定义了一个名为Loggable的自定义注解。
@Retention(RetentionPolicy.RUNTIME)表示这个注解在运行时仍然可见，可以被反射API读取。
@Target(ElementType.METHOD)表示这个注解只能被用于方法上。
然后，你可以在你的方法上使用这个注解，例如：
 */
public class MyService {
    @Loggable
    public void doSomething() {
        // ... 方法实现 ...
    }
    public void doSomethingElse() {
        // 这个方法没有使用@Loggable注解
    }
}

/*
在上述代码中，doSomething方法使用了@Loggable注解，表示这个方法需要记录日志。而doSomethingElse方法则没有使用这个注解。
最后，你需要编写代码来读取这些注解，并在需要的时候记录日志。这通常需要使用Java的反射API。这个过程可能相对复杂，
因为你需要遍历类的所有方法，检查它们是否使用了@Loggable注解，然后在需要的时候记录日志。
这个过程可能会涉及到AOP（面向切面编程）的概念，你可以使用Spring AOP或者AspectJ等框架来实现这个功能。
注意，上面的例子只是一个基础的注解定义，并没有涉及到实际的日志记录功能。在实际使用中，你可能需要在这个注解中添加更多的属性，
例如日志级别、日志消息等，然后在处理这个注解的时候，根据这些属性来记录相应的日志。

 */
