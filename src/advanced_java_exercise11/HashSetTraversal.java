package advanced_java_exercise11;

import java.util.HashSet;

public class HashSetTraversal {
    public static void main(String[] args) {
        // 创建一个HashSet并添加一些元素
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("cherry");

        // 使用foreach循环遍历HashSet
        for (String element : hashSet) {
            // 打印出HashSet中的每个元素
            System.out.println(element);
        }
    }
}

/*
在上面的代码中，我们首先创建了一个HashSet对象，并向其中添加了一些字符串元素。然后，我们使用foreach循环遍历这个HashSet。
foreach循环会自动迭代HashSet中的每一个元素，并将每个元素的值赋给element变量。接着，我们在循环体内打印出这个元素的值。
运行这段代码，你会在控制台看到如下输出：
apple
banana
cherry
注意，由于HashSet不保证元素的顺序，因此每次运行程序时输出的顺序可能会有所不同。如果你需要保持元素的插入顺序，
可以考虑使用LinkedHashSet，它是HashSet的一个子类，能够按照元素的插入顺序来遍历元素。

 */