package operation_system_ex03;

import java.util.concurrent.Semaphore;

/*
信号量（Semaphore）是一种用于控制多个线程对共享资源访问的同步原语。P 操作（也称为 wait 或 down）通常用于请求资源，
如果资源不可用，则进程将阻塞。V 操作（也称为 signal 或 up）则用于释放资源，可能会唤醒等待该资源的进程。
下面是一个简单的 Java 示例，展示了如何使用 Semaphore 类来实现 P 和 V 操作。
首先，确保你的项目中已经包含了 Java 的并发库：
 */
public class SemaphoreDemo {
    // 假设我们有一个信号量，表示可用的资源数量
    private Semaphore semaphore;

    public SemaphoreDemo(int permits) {
        this.semaphore = new Semaphore(permits);
    }

    // P 操作：请求资源
    public void P() throws InterruptedException {
        semaphore.acquire(); // 如果资源不可用，当前线程将被阻塞
    }

    // V 操作：释放资源
    public void V() {
        semaphore.release(); // 释放一个资源，可能会唤醒等待该资源的线程
    }

    public static void main(String[] args) {
        SemaphoreDemo demo = new SemaphoreDemo(2); // 假设有 2 个资源可用

        Thread t1 = new Thread(() -> {
            try {
                demo.P(); // t1请求一个资源
                System.out.println("Thread t1 acquired a resource.");
                // 模拟 t1 使用资源
                Thread.sleep(1000);
                demo.V(); // t1 释放资源
                System.out.println("Thread t1 released the resource.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                demo.P(); // t2请求一个资源
                System.out.println("Thread t2 acquired a resource.");
                // 模拟 t2 使用资源
                Thread.sleep(1000);
                demo.V(); // t2 释放资源
                System.out.println("Thread t2 released the resource.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                demo.P(); // t3 请求一个资源，这时资源应该已经被占用，t3 将被阻塞
                System.out.println("Thread t3 acquired a resource.");
                Thread.sleep(2000); // 让 t3 占用资源 2 秒
                demo.V(); // t3 释放资源
                System.out.println("Thread t3 released the resource.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        /*
        t3 尝试请求一个资源，但由于 t1 和 t2 已经占用了全部资源，t3 将被阻塞，直到有资源可用。
        当 t1 或 t2 释放资源后，t3 将被唤醒并获取资源。
         */
        t3.start();
    }
}

/*
这个示例创建了一个 SemaphoreDemo 类，该类使用 java.util.concurrent.Semaphore 来管理资源。
P 方法用于请求资源，如果资源不可用，则当前线程将阻塞。V 方法用于释放资源，可能会唤醒等待该资源的线程。
在 main 方法中，我们创建了两个线程 t1 和 t2，它们都尝试使用 SemaphoreDemo 来管理资源。假设初始时有两个资源可用，
因此两个线程都可以成功请求资源。每个线程在获取资源后，都会模拟使用资源一段时间（通过 Thread.sleep），然后释放资源。
注意：这只是一个简单的示例，用于说明如何使用信号量来实现进程间的同步与互斥。在实际应用中，你可能需要更复杂的逻辑来处理多个线程和多个资源的情况。
 */