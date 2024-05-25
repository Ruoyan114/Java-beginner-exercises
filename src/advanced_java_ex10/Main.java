package advanced_java_ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // 创建一个ArrayList来存储学生对象
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("张三", 20));
        students.add(new Student("李四", 21));
        students.add(new Student("王五", 19));

        // 使用Collections的sort方法和自定义的Comparator对学生按姓名排序
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        // 打印排序后的学生信息
        for (Student student : students) {
            System.out.println(student);
        }

    }
}

/*
在这个例子中，我们首先创建了一个ArrayList来存储Student对象。然后，我们使用Collections的sort方法
对这个ArrayList进行排序。在排序时，我们传入了一个自定义的Comparator，这个Comparator会根据学生的姓名进行比较。
最后，我们遍历并打印排序后的学生信息。
注意：这个例子中的排序是按照姓名的字典顺序进行的。如果你需要按照其他方式进行排序（例如按照年龄），
你可以修改Comparator中的compare方法来实现。

 */