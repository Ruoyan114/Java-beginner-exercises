package operation_system_ex06;

public class DecrementTask extends Thread {
    private final SharedResource sharedResource;

    public DecrementTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.decrement();
            try {
                Thread.sleep(150); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
