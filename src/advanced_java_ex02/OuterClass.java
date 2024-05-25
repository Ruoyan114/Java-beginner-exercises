package advanced_java_ex02;
/*
在Java中，你可以在一个类中定义一个内部接口，并在同一个类中实现这个接口作为内部类。
下面是一个简单的示例，演示了如何在一个外部类中定义内部接口和内部实现类：
 */
public class OuterClass {
    // 内部接口
    interface InnerInterface {
        void doSomething();
    }

    // 内部实现类
    class InnerClass implements InnerInterface {
        @Override
        public void doSomething() {
            System.out.println("Doing something in InnerClass.");
        }
    }

    // 外部类方法，用于创建和返回内部实现类的实例
    public InnerInterface getInnerClassInstance() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        InnerInterface inner = outer.getInnerClassInstance();
        inner.doSomething(); // 输出：Doing something in InnerClass.
    }
}

/*
在这个例子中，OuterClass是一个外部类，它包含一个内部接口InnerInterface和一个内部类InnerClass。
InnerClass实现了InnerInterface接口，并提供了doSomething方法的实现。
OuterClass还提供了一个getInnerClassInstance方法，它返回InnerInterface类型的对象，实际上是InnerClass的一个实例。
这样做的好处是，外部类可以隐藏内部实现类的具体类型，只通过接口与外部世界交互，这符合面向接口编程的原则。
在main方法中，我们创建了OuterClass的一个实例，并通过调用getInnerClassInstance方法获取了内部实现类的实例。
然后，我们通过这个接口引用来调用doSomething方法，展示了内部类的使用。
 */
