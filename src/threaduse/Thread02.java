package threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

    }
}

class Dog implements Runnable { //通过实现runnable接口，开发线程
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (count == 10) {
                break;
            }
        }
    }
}