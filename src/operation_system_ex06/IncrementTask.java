package operation_system_ex06;
/*
然后，我们创建两个线程类，分别执行增加和减少操作：
 */
public class IncrementTask extends Thread {
    private final SharedResource sharedResource;

    public IncrementTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.increment();
        }
        /*
        使用 join 方法等待两个线程执行完毕。join 方法会阻塞主线程，直到调用 join 的线程
        （即 incrementThread 和 decrementThread）执行完毕。如果线程在等待过程中被中断，
        则捕获 InterruptedException 异常并打印堆栈跟踪信息。
         */
        try {
            Thread.sleep(100); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
