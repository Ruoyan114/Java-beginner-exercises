package beginner_java_ex06;

// 主类，用于创建对象并测试
public class Main {
    public static void main(String[] args) {
        // 创建学生对象
        Student student = new Student("张三", 20);

        // 调用对象的方法
        student.printStudentInfo();
        System.out.println("计算年龄：" + student.calculateAge());
    }
}

/*
在这个示例中，我们创建了一个Student类，它有两个私有属性name和age，以及一些公共的getter和setter方法。
我们还定义了一个calculateAge方法（在这个简单的例子中，它只是返回年龄本身），
以及一个printStudentInfo方法，用于打印学生的信息。
在Main类的main方法中，我们创建了一个Student对象，并调用了它的方法来测试其功能。
请注意，这只是一个简单的示例，实际的面向对象编程可能会涉及更复杂的结构和概念。
 */