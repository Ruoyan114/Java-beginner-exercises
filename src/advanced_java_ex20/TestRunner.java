package advanced_java_ex20;

import java.lang.reflect.Method;

/*
然后，我们编写一个简单的单元测试框架TestRunner，用于执行标记有@Test注解的测试方法：
 */
public class TestRunner {
    public static void runTests(Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(testClass.getDeclaredConstructor().newInstance());
                    System.out.println(method.getName() + " passed.");
                } catch (Exception e) {
                    System.out.println(method.getName() + " failed: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        runTests(CalculatorTest.class);
    }
}

/*
在TestRunner中，我们通过反射获取测试类的所有方法，并检查它们是否带有@Test注解。如果带有注解，我们就调用该方法并执行测试。
如果测试方法执行成功，我们打印出通过的消息；如果抛出异常，我们打印出失败的消息和异常信息。
最后，在TestRunner的main方法中，我们调用runTests方法，并传入测试类CalculatorTest，执行所有的测试。
注意，这只是一个非常基础的示例，并没有考虑许多实际的测试框架所拥有的功能，比如测试套件的组织、测试顺序的控制、
测试前后的准备和清理工作、断言库的使用等。在实际开发中，通常会使用成熟的单元测试框架，如JUnit或TestNG，它们提供了更强大和灵活的功能。

 */