package operation_system_ex06;
/*
在Java中，你可以使用java.util.concurrent包中的类和接口来实现多线程、同步和互斥。下面是一个简单的例子，
其中有两个线程分别执行不同的任务，并使用synchronized关键字确保线程间的同步和互斥。
首先，我们定义一个共享资源类，它包含一个需要被同步访问的字段：
 */
public class SharedResource {
    private int sharedData = 0;

    public synchronized void increment() {
        sharedData++;
        System.out.println("Thread " + Thread.currentThread().getId() +
                " incremented the shared data to " + sharedData);
    }

    public synchronized void decrement() {
        sharedData--;
        System.out.println("Thread " + Thread.currentThread().getName() +
                " decremented the shared data to " + sharedData);
    }

    public int getSharedData() {
        return sharedData;
    }
}

