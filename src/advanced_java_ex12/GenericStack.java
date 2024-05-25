package advanced_java_ex12;
/*
在Java中，你可以创建一个泛型栈类来支持不同类型的栈操作。泛型允许你在编译时定义类、接口和方法可以操作的具体类型。
下面是一个简单的泛型栈类的实现，包括基本的栈操作，如push（压栈）、pop（出栈）、peek（查看栈顶元素但不移除）以及检查栈是否为空的方法：

 */
public class GenericStack<T> {
    private Node<T> top;
    private int size;

    // 栈节点内部类
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // 构造函数
    public GenericStack() {
        top = null;
        size = 0;
    }

    // 压栈操作
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // 出栈操作
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    // 查看栈顶元素
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // 检查栈是否为空
    public boolean isEmpty() {
        return top == null;
    }

    // 获取栈的大小
    public int size() {
        return size;
    }

}

/*
在这个实现中，GenericStack是一个泛型类，它接受一个类型参数T。这个类型参数被用来声明Node内部类的数据字段和栈操作的参数。
这样，GenericStack类就可以用于存储任何类型的对象。
 */