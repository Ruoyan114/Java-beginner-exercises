package advanced_java_exercise01;

import java.util.Timer;
import java.util.TimerTask;

/*
在Java中，内部类可以是静态的或非静态的。静态内部类不需要外部类的实例就可以创建，而非静态内部类需要外部类的实例。
对于你的需求，我们可以创建一个简单的计时器功能作为非静态内部类，因为计时器通常与外部类的实例关联。
以下是一个示例，其中外部类TimerHolder包含一个内部类SimpleTimer，这个内部类使用java.util.Timer和java.util.TimerTask来实现计时器功能：
 */
public class TimerHolder {
    private Timer timer;

    public TimerHolder() {
        this.timer = new Timer();
    }

    public void startTimer(int seconds, final Runnable task) {
        timer.schedule(new SimpleTimer(seconds, task), 0, seconds*1000);
    }

    public void stopTimer() {
        timer.cancel();
    }

    // 内部类实现计时器功能
    class SimpleTimer extends TimerTask {
        private int seconds;
        private Runnable task;

        public SimpleTimer(int seconds, Runnable task) {
            this.seconds = seconds;
            this.task = task;
        }

        @Override
        public void run() {
            System.out.println("Timer ticked: " + seconds + " seconds have passed.");
            task.run(); // 执行传入的任务
        }
    }

    public static void main(String[] args) {
        TimerHolder holder = new TimerHolder();
        holder.startTimer(5, () -> System.out.println("Performing a task every 5 seconds."));

        // 让主线程休眠一段时间以便观察计时器效果
        try {
            Thread.sleep(20000); // 休眠20秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        holder.stopTimer(); // 停止计时器
    }
}

/*
在这个例子中，TimerHolder类有一个startTimer方法，它接受一个时间间隔（以秒为单位）和一个Runnable任务。
这个方法使用内部类SimpleTimer来创建一个定时任务，该任务每隔指定的时间间隔就会执行一次。我们还提供了一个stopTimer方法来停止计时器。
在main方法中，我们创建了一个TimerHolder实例，并启动了一个每5秒执行一次的计时器。我们还让主线程休眠20秒以便观察计时器的效果。
最后，我们调用stopTimer方法来停止计时器。
 */