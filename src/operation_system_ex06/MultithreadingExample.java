package operation_system_ex06;
/*
最后，我们创建一个主类来启动这两个线程：
 */
public class MultithreadingExample {
    public static void main(String[] args) {
        // 实例化 SharedResource 对象，这个对象将在两个线程间共享，用于演示共享数据的操作。
        SharedResource sharedResource = new SharedResource();

        Thread incrementThread = new IncrementTask(sharedResource);
        Thread decrementThread = new DecrementTask(sharedResource);

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final shared data: " + sharedResource.getSharedData());
    }
}

/*
在这个例子中，IncrementTask和DecrementTask分别执行增加和减少操作，它们通过调用SharedResource类中的increment和
decrement方法来实现。这两个方法都是synchronized的，这意味着在任何时候只能有一个线程执行这些方法，从而确保了线程间的同步和互斥。
main方法中创建了两个线程对象，并启动它们。join方法用于等待线程执行完毕。最后，输出最终的共享数据值。
请注意，虽然synchronized关键字提供了一种简单的同步机制，但在复杂的并发场景中，可能还需要使用更高级的并发控制工具，如
ReentrantLock、Semaphore、CountDownLatch、CyclicBarrier等。
此外，Java 8引入的Stream API和CompletableFuture类也提供了强大的并行处理能力。
 */
