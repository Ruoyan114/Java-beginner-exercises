package advanced_java_exercise18;

import java.util.ArrayList;
import java.util.Iterator;

/*
在Java中，如果你尝试在遍历集合（如使用迭代器或for-each循环）的同时修改该集合的结构（例如添加或删除元素），
则会抛出ConcurrentModificationException。下面是一个简单的示例来说明这个异常：
 */
public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        // 创建一个ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        // 使用迭代器遍历集合
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String element =  iterator.next();
//            System.out.println("Current element: " + element);
//            // 在遍历过程中尝试修改集合（添加元素）
//            list.add("New element"); // 这会导致ConcurrentModificationException

            /*
            当你运行上面的代码时，你会在尝试添加新元素时遇到ConcurrentModificationException。
            如果你需要在遍历集合的同时修改它，有几种方法可以避免这个异常：
            使用Iterator的remove方法：如果你只是想在遍历过程中删除元素，可以使用Iterator的remove方法，而不是直接修改集合。
            */

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element =  iterator.next();
            System.out.println("Current element: " + element);

            // 使用Iterator的remove方法删除元素
            if ("Element 2".equals(element)) {
                iterator.remove();
            }
        }
    }
}



