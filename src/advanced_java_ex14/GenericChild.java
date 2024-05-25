package advanced_java_ex14;

// 子类继承泛型父类，并使用父类的类型参数
public class GenericChild<T> extends GenericParent<T> {
    public GenericChild(T value) {
        super(value);
    }

    // 覆盖父类的非泛型方法
    @Override
    public void printMessage() {
        System.out.println("Generic Child");
    }
}
