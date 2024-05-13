package advanced_java_exercise14;

// 演示类
public class GenericInheritanceDemo {
    public static void main(String[] args) {
        // 使用泛型父类
        GenericParent<String> parent = new GenericParent<>("Parent Value");
        System.out.println("Parent Value: " + parent.getValue());
        parent.printMessage();

        // 使用继承泛型父类的子类
        GenericChild<Integer> child = new GenericChild<>(123);
        System.out.println("Child Value: " + child.getValue());
        child.printMessage();

        // 使用继承泛型父类并定义自己类型参数的子类
        GenericChildWithOwnType<Double, Boolean> childWithOwnType = new GenericChildWithOwnType<>(3.14, true);
        System.out.println("ChildWithOwnType Value: " + childWithOwnType.getValue());
        System.out.println("Another Value: " + childWithOwnType.getAnotherValue());

    }
}

/*
在这个示例中，GenericParent是一个泛型类，它有一个类型参数T和一个泛型方法getValue。
GenericChild是GenericParent的子类，它继承了父类的类型参数T。
GenericChildWithOwnType也是GenericParent的子类，但它还定义了自己的类型参数U。
在main方法中，我们创建了GenericParent、GenericChild和GenericChildWithOwnType的实例，并展示了如何使用它们。
可以看到，GenericChild继承了GenericParent的泛型特性，并覆盖了非泛型方法printMessage。
而GenericChildWithOwnType不仅继承了GenericParent的泛型特性，还添加了自己的泛型特性。
这个示例演示了泛型类和泛型方法如何在继承关系中工作，子类可以继承父类的泛型特性，并可以定义或覆盖自己的泛型方法。
 */