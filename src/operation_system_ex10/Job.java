package operation_system_ex10;
/*
实现一个操作系统的作业调度算法是一个复杂的任务，通常需要考虑多种因素，如作业的优先级、等待时间、执行时间以及可能的I/O操作等。
以下是一个简化的Java实现，它考虑了作业的优先级和等待时间。
我们将定义一个Job类来表示作业，并创建一个JobScheduler类来执行调度。在这个示例中，我们假设作业的执行时间已知，
并且我们使用优先级队列来根据作业的优先级进行调度。
 */
import java.util.Objects;

public class Job {
    private String id;
    private int priority;
    private int executionTime;
    private long arrivalTime;
    private long waitTime;

    public Job(String id, int priority, int executionTime, long arrivalTime) {
        this.id = id;
        this.priority = priority;
        this.executionTime = executionTime;
        this.arrivalTime = arrivalTime;
        this.waitTime = 0;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return priority == job.priority &&
                executionTime == job.executionTime &&
                arrivalTime == job.arrivalTime &&
                waitTime == job.waitTime &&
                Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priority, executionTime, arrivalTime, waitTime);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", priority=" + priority +
                ", executionTime=" + executionTime +
                ", arrivalTime=" + arrivalTime +
                ", waitTime=" + waitTime +
                '}';
    }
}
