package operation_system_ex10;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class JobScheduler {
    private Queue<Job> readyQueue;
    private long currentTime;

    public JobScheduler() {
        this.readyQueue = new PriorityQueue<>(Comparator.comparingInt(Job::getPriority).reversed()); // ClassName::methodName
        this.currentTime = 0;
    }

    public void addJob(Job job) {
        // 当作业到达时，将其加入就绪队列
        long arrivalTime = job.getArrivalTime();
        if (arrivalTime > currentTime) {
            // 如果作业尚未到达，则等待其到达时间
            try {
                Thread.sleep(arrivalTime - currentTime);
                currentTime = arrivalTime;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Scheduler thread interrupted", e);
            }
        }
        readyQueue.add(job);
    }

    public void scheduleJobs() {
        while (!readyQueue.isEmpty()) {
            Job currentJob = readyQueue.poll(); // 取出优先级最高的作业
            currentJob.setWaitTime(currentTime - currentJob.getArrivalTime()); // 计算等待时间
            System.out.println("Executing job: " + currentJob);

            // 模拟作业执行时间
            try {
                Thread.sleep(currentJob.getExecutionTime()); // 模拟作业的执行时间
                currentTime += currentJob.getExecutionTime();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Scheduler thread interrupted", e);
            }

            System.out.println("Job executed with wait time: " + currentJob.getWaitTime() + "ms");
        }
    }

    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();

        // 添加一些作业到调度器
        scheduler.addJob(new Job("Job1", 3, 5, 0)); // 优先级3，执行时间5ms，到达时间0ms
        scheduler.addJob(new Job("Job2", 1, 3, 2)); // 优先级1，执行时间3ms，到达时间2ms
        scheduler.addJob(new Job("Job3", 2, 4, 4)); // 优先级2，执行时间4ms，到达时间4ms

        // 开始调度作业
        scheduler.scheduleJobs();
    }
}

/*
在上面的代码中，我们定义了一个Job类来表示作业，其中包含作业ID、优先级、执行时间、到达时间和等待时间。
JobScheduler类使用了一个优先级队列来根据作业的优先级进行排序。当作业到达时，它们被添加到就绪队列中，调度器按照优先级顺序从队列中取出作业并执行。
请注意，这只是一个简化的示例，并没有考虑其他重要的调度因素，如作业的截止时间、资源需求或系统负载。
在实际操作系统中，调度算法会更为复杂，并可能涉及到动态优先级调整、抢占式调度、时间片轮转等多种机制。
此外，该示例使用了Thread.sleep()来模拟作业的执行时间和等待时间，这在实际应用中可能并不适用，因为操作系统调度器通常不会直接控制线程睡眠。
 */