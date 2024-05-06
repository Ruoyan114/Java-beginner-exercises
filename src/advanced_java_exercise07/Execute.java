package advanced_java_exercise07;
/*
要利用注解和反射实现一个能够自动执行带有特定注解的方法的框架，你需要做几件事：
定义注解。
扫描类和方法，查找带有注解的方法。
使用反射调用这些方法。
下面是一个简单的例子来实现这个框架：
首先，定义注解：
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Execute {
    // 可以添加一些属性，例如执行顺序、执行条件等
}
