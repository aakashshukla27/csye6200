package edu.neu.csye6200.bg;

public class Tester {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("My thread running");
            System.out.println("My thread stopped.");
        }
    }
    public static class MyRunnable implements Runnable {
        @Override
        public void run(){
            System.out.println("My thread running");
            System.out.println("My thread stopped.");
        }
    }

    public static class MyThread2 implements Runnable{
        String threadName;
        public MyThread2(String threadName){
            this.threadName = threadName;
        }

        @Override
        public void run(){
            System.out.println(threadName + " starting.");
            try{
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("In " + threadName + ", count is " + i);
                }
            }
            catch (Exception ex){
                System.out.println(threadName + " interrupted.");
            }
            System.out.println(threadName + " terminating.");
        }

    }

    public static void main(String[] args) {
        System.out.println("Main thread starting.");
        MyThread2 mt = new MyThread2("Child #1");
        Thread newThread = new Thread(mt);
        newThread.start();
        for(int i=0;i<50; i++){
            System.out.print(i);
            try{
                Thread.sleep(1000);
            }
            catch (Exception ex){
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
//        MyThread thread = new MyThread();
//        thread.start();
//
//        Thread thread1 = new Thread(new MyRunnable());
//        thread1.start();
    }
}
