package advanced_java_ex07;
/*
最后，创建一个带有@Execute注解的类：
 */
public class MyService {
    @Execute
    public void methodToExecute1() {
        System.out.println("Executing methodToExecute1");
    }

    @Execute
    public void methodToExecute2() {
        System.out.println("Executing methodToExecute2");
    }

    // 这个方法没有@Execute注解，所以不会被执行
    public void anotherMethod() {
        System.out.println("This method is not annotated and will not be executed.");
    }
}

/*
当运行AnnotationExecutor的main方法时，它会扫描MyService类，查找所有带有@Execute注解的方法，并使用反射调用它们。
在这个例子中，methodToExecute1和methodToExecute2将会被自动执行，而anotherMethod则不会。
请注意，这个框架非常基础，并且假设所有带有注解的方法都是无参数的，且类有一个无参数的构造器。
在实际应用中，你可能需要处理更复杂的场景，例如方法参数、异常处理、方法执行顺序等。
此外，使用AOP框架（如Spring AOP或AspectJ）可能是处理这种需求的更优雅和强大的方式。

 */