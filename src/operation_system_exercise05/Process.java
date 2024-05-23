package operation_system_exercise05;
/*
然后，我们可以创建一些线程来模拟进程，这些线程会尝试获取资源：
 */
public class Process extends Thread {
    private final Resource resource;
    private final int id;

    public Process(Resource resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Process " + id + " is trying to acquire the resource.");
            resource.acquire();
            System.out.println("Process " + id + " has acquired the resource.");
            // 模拟处理时间
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println("Process " + id + " is releasing the resource.");
            resource.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
