package operation_system_exercise05;
/*
死锁是操作系统和并发编程中一个非常重要的问题，它发生在两个或更多的进程无限期地等待一个资源，而该资源又被另一个进程持有，
后者也在等待另一个进程释放它所需的资源。为了避免死锁，我们可以采用多种策略，如资源分级法、请求和保持法、资源预分配法等。
在Java中实现死锁预防和检测机制是一个相对复杂的任务，因为它通常涉及到并发控制和资源管理的底层细节。
然而，我可以向你展示一个简化的例子来说明如何避免死锁。在这个例子中，我们将使用Java的ReentrantLock来模拟资源的获取和释放，
并使用一种简单的策略来避免死锁。
首先，我们需要一个资源类，该类封装了ReentrantLock来模拟资源的获取和释放：
 */

import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private final ReentrantLock lock = new ReentrantLock();

    public void acquire() {
        lock.lock();
    }

    public void release() {
        lock.unlock();
    }
}

