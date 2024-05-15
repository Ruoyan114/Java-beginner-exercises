package syn;

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

//        sellTicket02 sellTicket02 = new sellTicket02();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();

        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口
    }
}

//使用thread方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出1张票"
                    + "剩余票数 = " + (--ticketNum));
        }
    }
}

// synchronized
class SellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();

    public void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出1张票"
                    + "剩余票数 = " + (--ticketNum));
        }
    }
    @Override
    public void run() {
        while (loop){
            sell();
        }
    }
}

//实现接口方式
class sellTicket02 implements Runnable {
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            //休眠50毫秒
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出1张票"
                    + "剩余票数 = " + (--ticketNum));
        }
    }
}