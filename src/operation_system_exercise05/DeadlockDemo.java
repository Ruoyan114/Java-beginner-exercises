package operation_system_exercise05;
/*
最后，我们创建一个主类来启动这些线程：
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Process process1 = new Process(resource, 1);
        Process process2 = new Process(resource, 2);

        process1.start();
        process2.start();
    }
}

/*
在这个例子中，我们只有一个资源和一个简单的策略来避免死锁：当进程尝试获取资源时，它会立即阻塞，直到能够获取到资源。
一旦进程获取到资源并处理完毕后，它会立即释放资源。由于我们只有一个资源，所以不存在多个进程相互等待的情况，因此不会发生死锁。
然而，这个例子是非常简化的，真实的并发系统通常涉及多个资源和复杂的交互模式。在这种情况下，预防死锁可能需要更复杂的策略，
如资源分级、避免循环等待等。此外，死锁检测通常涉及到监控系统的状态并检测潜在的死锁条件，这通常是一个更复杂的问题，可能需要专门的算法和工具来解决。
 */