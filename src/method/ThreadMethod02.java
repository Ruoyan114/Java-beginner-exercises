package method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 1; i <= 20 ; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃了 " + i + " 包子");
            if (i == 5) {
                System.out.println("主线程让子线程先吃");
                t2.join();
                System.out.println("子线程吃完了，主线程接着吃");
            }
        }
    }
}


class T2 extends Thread {
    @Override
    public void run() {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程吃了 " + i + " 包子");
            }
        }
    }
