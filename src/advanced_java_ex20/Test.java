package advanced_java_ex20;

/*
在Java中，注解（Annotation）是JDK 5.0引入的一种用于给代码添加元数据的机制。在单元测试中，注解可以用于标记测试方法、测试类等，
从而简化测试代码的编写和执行。下面是一个使用注解的简单单元测试框架的例子：
首先，我们定义一个注解@Test，用于标记测试方法：
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
