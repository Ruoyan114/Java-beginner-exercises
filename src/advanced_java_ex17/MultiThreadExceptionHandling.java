package advanced_java_ex17;

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
        /*
        创建一个单线程的ExecutorService，这个线程池会管理一个线程，并负责任务的提交和执行。
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*
        使用executorService.submit()方法提交一个Callable任务。Callable任务可以返回一个结果，
        submit方法会返回一个Future对象。这里我们提交的任务是一个抛出异常的任务
         */
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

        /*
        调用future.get()方法等待任务完成，并获取任务的结果。如果任务执行过程中抛出了异常，future.get()
        会抛出一个ExecutionException，这个异常的getCause()方法会返回任务中抛出的实际异常。
        在catch块中，我们处理了这个异常并打印了堆栈跟踪信息。在finally块中，我们关闭了ExecutorService以释放资源。
         */
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

/*
使用场景:
ExecutorService和Future适用于需要管理大量线程、任务需要返回结果、或需要更高效的线程管理的场景。
自定义Thread类适用于简单任务、需要在线程内部处理异常、或不需要线程池管理的场景。

代码复杂度:
ExecutorService和Future可能需要更多的代码来设置和管理线程池，但提供了更强大的功能和更高的效率。
自定义Thread类的方式更简单，但灵活性和效率不如前者。

异常处理:
ExecutorService和Future通过Future.get()在主线程中处理异常，更适合在主线程中统一处理异常的场景。
自定义Thread类在run方法中处理异常，适用于需要在线程内部处理的场景
 */