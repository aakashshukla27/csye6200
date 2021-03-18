package edu.neu.csye6200.threadingPractice;

class MyThread3 implements Runnable{
    Thread thread;
    public MyThread3(String name){
        thread = new Thread(this, name);
        thread.start();
    }
    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");
        try{
            for (int i = 0; i < 10; i++) {
                Thread.sleep(2000);
                System.out.println("In " + thread.getName() + ", count is " + i);
            }
        }
        catch (Exception Ex){

        }
    }
}

public class UseThreadsImproved {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 mt1 = new MyThread3("Child #1");
        MyThread3 mt2 = new MyThread3("Child #2");
        MyThread3 mt3 = new MyThread3("Child #3");
        mt1.thread.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thread.setPriority(Thread.NORM_PRIORITY);
        mt3.thread.setPriority(Thread.NORM_PRIORITY - 2);
        mt1.thread.join();
        System.out.println("Child #1 joined");
        mt2.thread.join();
        System.out.println("Child #2 joined");
        mt3.thread.join();
        System.out.println("Child #3 joined");
    }
}
