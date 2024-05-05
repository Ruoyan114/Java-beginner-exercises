package advanced_java_exercise03;
/*
下面是一个使用静态内部类来记录外部类创建次数的Java代码示例：
 */
public class OuterClass {
    // 静态内部类，用于记录外部类的创建次数
    private static class Counter {
        private static int count = 0;

        public static int getCount() {
            return count;
        }

        public static void increment() {
            count++;
        }
    }

    // 外部类的构造器
    public OuterClass() {
        // 每次创建外部类实例时，增加计数
        Counter.increment();
    }

    // 获取外部类创建次数的静态方法
    public static int getCreationCount() {
        return Counter.getCount();
    }

    public static void main(String[] args) {
        // 创建几个外部类的实例
        OuterClass instance01 = new OuterClass();
        OuterClass instance02 = new OuterClass();
        OuterClass instance03 = new OuterClass();

        // 输出外部类的创建次数
        System.out.println("Number of OuterClass instances created: " + OuterClass.getCreationCount());
    }

}

/*
在这个例子中，OuterClass是一个外部类，它包含一个静态内部类Counter。
Counter类有一个静态变量count来记录OuterClass的实例创建次数，以及两个静态方法getCount和increment分别用于获取和增加计数。
OuterClass的构造器每次被调用时（即每次创建OuterClass的新实例时），都会调用Counter.increment()来增加计数。
OuterClass还提供了一个静态方法getCreationCount，它返回Counter类中静态变量count的当前值，即外部类的创建次数。
在main方法中，我们创建了三个OuterClass的实例，并输出创建次数，以验证静态内部类Counter是否正确地记录了外部类的创建次数。
 */