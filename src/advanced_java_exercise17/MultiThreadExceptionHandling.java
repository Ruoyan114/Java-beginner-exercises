package advanced_java_exercise17;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
在多线程环境中处理异常是一个重要的任务，因为线程的异常如果不被正确处理，可能会导致整个应用程序的不稳定。
在Java中，你可以通过几种方式来确保线程的异常能够被正确捕获和处理。一种常见的方法是使用Future和ExecutorService来管理线程，
并通过Future.get()方法来捕获线程执行过程中抛出的异常。下面是一个简单的示例：
 */
public class MultiThreadExceptionHandling {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Void> future = executorService.submit(() -> {
            // 模拟线程中的任务
            try {
                // 执行一些操作。。
                throw new RuntimeException("An error occurred in the thread");
            } catch (Exception e) {
                // 可以在这里处理异常，但通常更好的做法是将异常抛出
                throw new RuntimeException("Thread exception wrapper", e);
            }
        });

        try {
            // 等待任务完成，并获取结果（如果线程中有未捕获的异常，这里会抛出ExecutionException
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            // 处理异常
            Throwable cause = e.getCause(); // 获取实际的异常原因
            cause.printStackTrace(); // 打印堆栈跟踪信息
        } finally {
            // 关闭执行器服务
            executorService.shutdown();
        }
    }
}

/*
在这个例子中，我们创建了一个ExecutorService并提交了一个任务到线程池执行。任务中我们故意抛出了一个RuntimeException来模拟异常情况。
当调用future.get()时，如果线程中抛出了未捕获的异常，get()方法会抛出ExecutionException，并且我们可以通过getCause()方法获取实际的异常原因。
另一种处理线程中异常的方式是自定义Thread类并重写run方法，在run方法内部捕获并处理异常。这种方式可以让你更加灵活地控制异常的处理逻辑。
 */