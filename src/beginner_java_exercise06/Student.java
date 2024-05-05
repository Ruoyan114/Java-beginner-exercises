package beginner_java_exercise06;
/*
好的，面向对象编程是一种编程范式，它使用“对象”来设计应用程序和软件。
对象通常包含数据（属性）和代码（方法），用于操作这些数据。
面向对象编程的三大主要特性是：封装、继承和多态。
封装：将数据和操作数据的函数捆绑在一起，作为一个独立的单元。
继承：允许我们根据一个类来定义另一个类，这使得创建和维护一个应用程序变得更容易。
多态：允许将父对象设置成为和一个或更多的他的子对象相等的技术，赋值之后，
父对象就可以根据当前赋值给它的子对象的特性以不同的方式运作。
下面是一个简单的Java代码示例，它创建了一个“学生”类，包含姓名、年龄等属性，以及一个计算年龄的方法。
 */

public class Student {
    // 封装：属性（字段）私有化
    private String name;
    private int age;

    // 构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 封装：提供公共的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 方法：计算年龄（这里假设有一个简单的计算，即返回年龄本身）
    public int calculateAge() {
        return this.age;
    }

    // 方法：打印学生信息
    public void printStudentInfo() {
        System.out.println("姓名: " + this.name);
        System.out.println("年龄: " + this.age);
    }

}
