package advanced_java_ex14;

// 子类继承泛型父类，并定义自己的类型参数
public class GenericChildWithOwnType<T,U> extends GenericParent<T> {
    private U anotherValue;

    public GenericChildWithOwnType(T value, U anotherValue) {
        super(value);
        this.anotherValue = anotherValue;
    }

    // 泛型方法，使用自己的类型参数
    public U getAnotherValue() {
        return anotherValue;
    }

    public void setAnotherValue(U anotherValue) {
        this.anotherValue = anotherValue;
    }


}
