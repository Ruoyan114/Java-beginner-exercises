package beginner_java_ex05;

//查找数组中的最小值：同样通过遍历数组比较每个元素。
public class ArrayExample03 {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1, 4};
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("最小值: " + min); // 输出: 最小值: 1
    }
}