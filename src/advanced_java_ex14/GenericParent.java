package advanced_java_ex14;
/*
在Java中，泛型类和泛型方法可以与继承一起使用。子类可以继承泛型父类，并且子类可以定义自己的类型参数，或者使用父类的类型参数。
同样，泛型方法也可以被子类继承并覆盖。下面是一个演示泛型类和泛型方法继承关系的Java代码例子：
 */

// 泛型父类
public class GenericParent<T> {
    private T value;

    public GenericParent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    // 非泛型方法
    public void printMessage() {
        System.out.println("Generic Parent");
    }
}



