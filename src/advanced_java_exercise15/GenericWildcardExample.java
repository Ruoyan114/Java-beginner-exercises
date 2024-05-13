package advanced_java_exercise15;

import java.util.List;

/*
在Java中，你可以使用泛型通配符<?>来创建一个可以接受任意类型List的方法。泛型通配符<?>表示未知类型，它可以匹配任何类型。
下面是一个使用泛型通配符的Java代码例子，该方法接受任意类型的List并打印其内容：
 */
public class GenericWildcardExample {
    // 使用泛型通配符<?>的方法，接受任意类型的List
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // 创建不同类型的List
        List<String> stringList = List.of("Apple", "Banana", "Cherry");
        List<Integer> integerList = List.of(1,2,3,4,5);
        List<Double> doubleList = List.of(1.0,2.0,3.5,4.2);

        // 调用printList方法，打印不同类型List的内容
        printList(stringList);
        printList(integerList);
        printList(doubleList);
    }
}

/*
在这个例子中，printList方法使用List<?>作为参数类型，这表示它可以接受任何类型的List。在方法体中，我们遍历列表并打印每个元素。
由于我们不知道列表的确切类型，所以我们只能将列表中的元素视为Object类型。
在main方法中，我们创建了三个不同类型的List：String类型、Integer类型和Double类型，然后分别调用printList方法来打印它们的内容。
注意，泛型通配符<?>是不变的（invariant），这意味着你不能向这样的列表中添加元素，因为编译器无法保证列表的类型兼容性。
如果你需要向列表中添加元素，你应该使用扩展通配符（例如List<? extends SomeType>），但这将限制你可以添加到列表中的元素类型。
在本例中，我们仅需要读取列表的内容，所以使用List<?>是合适的。

 */