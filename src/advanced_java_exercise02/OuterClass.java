package advanced_java_exercise02;
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

}
