package edu.neu.csye6200.threadingPractice;

class MyThread implements Runnable{
    String threadName;

    public MyThread(String name){
        threadName = name;
    }
    @Override
    public void run() {
        System.out.println(threadName + " starting.");
        try {
            for(int i=0; i<10; i++){
                Thread.sleep(4000);
                System.out.println("In " + threadName + ", count is " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " terminating");
    }
}

class MyThread2 implements Runnable{
    String threadName;

    public MyThread2(String name){
        threadName = name;
    }
    @Override
    public void run() {
        System.out.println(threadName + " starting.");
        try {
            for(int i=0; i<10; i++){
                Thread.sleep(5000);
                System.out.println("In " + threadName + ", count is " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " terminating");
    }
}


public class UseThreads {
    public static void main(String[] args) {
        MyThread mt = new MyThread("Child #1");
        MyThread2 mt2 = new MyThread2("Child #2");
        Thread newThread = new Thread(mt);
        Thread newThread2 = new Thread(mt2);
        newThread.start();
        newThread2.start();
    }
}
