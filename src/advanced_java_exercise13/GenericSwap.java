package advanced_java_exercise13;
/*
在Java中，你可以编写一个泛型方法来交换数组中任意两个元素的位置。泛型方法允许你在方法签名中定义类型参数，
这样方法就可以接受多种类型的参数。下面是一个简单的泛型方法，用于交换数组中任意两个元素的位置：
 */
public class GenericSwap {
    // 泛型方法，用于交换数组中两个元素的位置
    public static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            throw new IndexOutOfBoundsException("Indices are out of bounds or array is null");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // 整数数组示例
        Integer[] intArray = {1,2,3,4,5};
        System.out.println("Before swap: ");
        for (int i : intArray) {
            System.out.println(i + " ");
        }
        System.out.println();

        // 交换索引为1和3的元素
        swap(intArray, 1, 3);
        System.out.println("After swap: ");
        for (int i : intArray) {
            System.out.println(i + " ");
        }
        System.out.println();

        // 字符串数组示例
        String[] stringArray = {"a", "b", "c", "d", "e"};
        System.out.println("Before swap:");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 交换索引为0和4的元素
        swap(stringArray, 0, 4);

        System.out.println("After swap:");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
    }
}

/*
在这个示例中，swap方法是一个泛型方法，它接受一个泛型数组T[]和两个整数索引index1和index2作为参数。
它首先检查数组是否为null以及索引是否越界，然后交换数组中这两个索引对应的元素。
在main方法中，我们分别展示了如何使用swap方法来交换整数数组和字符串数组中元素的位置。
注意，泛型方法在编译时类型检查是静态的，因此你需要确保传递给泛型方法的参数类型是正确的，并且在运行时不会发生类型转换错误。
泛型方法使得代码更加灵活，因为它可以应用于多种数据类型，而不仅仅是预先定义好的类型。
 */