package advanced_java_exercise12;

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println(intStack.pop()); // 3
        System.out.println(intStack.peek()); // 2
        System.out.println(intStack.size()); // 2

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println(stringStack.pop()); // World
        System.out.println(stringStack.peek()); // Hello


    }
}

/*
在上面的示例中，我们分别创建了一个Integer类型的栈和一个String类型的栈，并展示了它们的基本操作。
由于使用了泛型，GenericStack类可以很容易地扩展到任何类型的栈。
 */