package advanced_java_ex07;

import advanced_java_ex06.MyService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
接着，实现一个能够扫描并执行带有@Execute注解的方法的框架：
 */
public class AnnotationExecutor {
    public static void executeMethodsWithAnnotation(Class<?> clazz) {
        List<Method> methodsWithAnnotation = new ArrayList<>();

        // 获取类中的所有方法
        for (Method method : clazz.getDeclaredMethods()) {
            // 检查方法是否带有@Execute注解
            if (method.isAnnotationPresent(Execute.class)) {
                methodsWithAnnotation.add(method);
            }
        }

        // 执行带有@Execute注解的方法
        for (Method method : methodsWithAnnotation) {
            try {
                // 假设这些方法都是无参数的，且都是public的
                method.invoke(clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 执行带有@Execute注解的类的方法
        executeMethodsWithAnnotation(MyService.class);
    }
}
