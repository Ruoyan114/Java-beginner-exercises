package advanced_java_exercise17;

public class CustomThread extends Thread {
    @Override
    public void run() {
        try {
            // 线程执行的代码
            // ... 执行一些操作 ...
            throw new RuntimeException("An error occurred in the custom thread");
        } catch (Exception e) {
            // 在这里处理异常
            e.printStackTrace();
            // 可以通过其他方式通知主线程异常发生，例如设置标志位或使用观察者模式
        }
    }

    public static void main(String[] args) {
        CustomThread thread = new CustomThread();
        thread.start();

        // 等待线程结束（这只是一个简单的示例，实际中你可能需要更复杂的同步机制）
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
在这个例子中，我们创建了一个自定义的Thread类并重写了run方法。在run方法中，我们捕获并处理了所有可能抛出的异常。
这种方式使得异常处理逻辑更加清晰，并且允许你更直接地控制线程的生命周期。
请注意，当处理多线程异常时，需要特别注意线程安全和并发控制的问题，以确保数据的一致性和避免竞态条件。
 */