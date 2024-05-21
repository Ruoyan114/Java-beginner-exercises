package operation_system_exercise01;

/*
在真实世界的操作系统中，进程调度是一个复杂的任务，涉及到许多硬件和软件层面的细节。然而，我们可以用Java来模拟一个简化的进程调度器，
该调度器能够按照优先级来调度进程。以下是一个简化的例子：
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class Process {
    int id;
    int priority;
    String name;

    Process(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}

class ProcessScheduler {
    private PriorityQueue<Process> readyQueue;

    public ProcessScheduler() {
        readyQueue = new PriorityQueue<>(Comparator.comparingInt((Process p) -> p.priority) // 接受一个 Process 对象并返回其 priority 值。
                .reversed());

        // 使用reversed()方法使得优先级高的进程先被调度 （3->2->1)
    }

    public void addProcess(Process process) {
        readyQueue.add(process);
    }

    public Process schedule() {
        return readyQueue.poll(); // 返回并移除优先级最高的进程
    }

    public boolean isEmpty() {
        return readyQueue.isEmpty();
    }

    public void displayProcesses() {
        readyQueue.forEach(System.out::println);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProcessScheduler scheduler = new ProcessScheduler();

        // 添加一些进程到调度器
        scheduler.addProcess(new Process(1, "ProcessA", 3));
        scheduler.addProcess(new Process(2, "ProcessB", 1));
        scheduler.addProcess(new Process(3, "ProcessC", 2));

        // 显示就绪队列中的进程
        System.out.println("Ready Queue:");
        scheduler.displayProcesses();

        // 调度并执行进程
        while (!scheduler.isEmpty()) {
            Process process = scheduler.schedule();
            if (process != null) {
                System.out.println("Executing: " + process);
            }
            // 这里可以模拟进程的执行时间，例如使用Thread.sleep()方法
            Thread.sleep(1000);
        }
        System.out.println("All processes have been scheduled and executed.");
    }
}

/*
在这个例子中，我们定义了一个Process类来代表进程，它包含了进程的ID、名称和优先级。ProcessScheduler类是我们的进程调度器，
它使用一个优先级队列来存储待调度的进程。addProcess方法用于向调度器中添加进程，schedule方法用于从调度器中取出优先级最高的进程进行执行。
我们还提供了一个displayProcesses方法来显示就绪队列中的进程。
在main方法中，我们创建了一个ProcessScheduler对象，并向其中添加了一些进程。然后，我们显示就绪队列中的进程，
并使用一个循环来不断调度并执行进程，直到就绪队列为空。
请注意，这个例子是一个非常简化的进程调度器模型，并不涉及实际的操作系统级别的进程管理。在真实的操作系统中，进程调度要复杂得多，
并且需要考虑许多其他的因素，如进程状态、资源分配、上下文切换等。此外，Java本身也提供了线程调度机制，
可以通过Thread类和相关的并发工具类来实现多线程编程。

 */
