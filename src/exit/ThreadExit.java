package exit;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        Thread.sleep(10 * 1000); //休眠10s再通知t1线程退出
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中" + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}