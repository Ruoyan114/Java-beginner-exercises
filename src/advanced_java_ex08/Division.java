package advanced_java_ex08;

/*
然后，我们编写一个除法方法divide，它接受两个整数作为参数，并返回它们的商。如果除数为0，我们就抛出一个DivideByZeroException异常：
 */
public class Division {
    public static int divide(int dividend, int divisor) throws DivideByZeroException {
        if (divisor == 0) {
            throw new DivideByZeroException("除数不能为0");
        }
        return dividend / divisor;
    }
}
