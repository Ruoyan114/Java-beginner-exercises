package advanced_java_ex10;
/*
下面是一个使用Java的ArrayList来存储学生信息，并根据姓名进行排序的代码示例。
首先，我们需要定义一个学生类（Student），然后创建一个ArrayList来存储学生对象，最后使用Collections的sort方法对ArrayList进行排序。
首先，定义学生类（Student.java）：
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
