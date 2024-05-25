package advanced_java_ex18;

import java.util.concurrent.CopyOnWriteArrayList;

/*
使用并发集合：如果你在多线程环境中工作，并且需要在遍历的同时修改集合，可以使用Java的并发集合，如CopyOnWriteArrayList。
 */
public class ConcurrentModificationExampleWithCopyOnWriteArrayList {
    public static void main(String[] args) {
        // 创建一个CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        // 遍历集合的同时在另一个线程中修改集合
        new Thread(() -> {
           list.add("New Element"); // 这不会导致ConcurrentModificationException
        }).start();

        // 这里遍历集合不会抛出ConcurrentModificationException，因为CopyOnWriteArrayList在修改时复制了底层数组
        for (String element : list) {
            System.out.println("Current Element: " + element);
        }
    }
}

/*
注意，CopyOnWriteArrayList在修改时复制底层数组，因此适用于读多写少的场景，因为写操作（修改）代价较高。
使用临时集合：如果你需要执行复杂的修改操作，可以先复制集合到一个临时集合中，在临时集合上进行修改，然后再将修改后的内容合并回原集合。
请记得，在使用并发集合或采取其他措施避免ConcurrentModificationException时，务必考虑线程安全性和性能的影响。

 */