package advanced_java_ex20;

import org.junit.jupiter.api.Test;

/*
接着，我们定义一个测试类CalculatorTest，其中使用@Test注解标记了测试方法：
 */
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assert result == 5 : "Addition failed";
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assert result == 2 : "Subtraction failed";
    }

    // 假设Calculator是一个简单的计算器类，包含add和subtract方法
    private static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }
    }
}
