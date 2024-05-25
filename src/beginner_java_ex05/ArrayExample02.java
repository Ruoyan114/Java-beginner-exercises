package beginner_java_ex05;

//查找数组中的最大值：通过遍历数组比较每个元素。
public class ArrayExample02 {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1, 4};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("最大值: " + max); // 输出: 最大值: 5
    }
}

