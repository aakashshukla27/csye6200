package edu.neu.csye6200.bg;

public class Tester2 {

    public static class MyThread implements Runnable{
        Thread threadName;
        public MyThread(String name){
            threadName = new Thread(this, name);
        }

        public static MyThread createAndStart(String name){
            MyThread myThread = new MyThread(name);
            myThread.threadName.start();
            return myThread;
        }
        @Override
        public void run(){
            System.out.println(threadName.getName() + " starting.");
            try{
                for (int i = 0; i < 10; i++) {
                    System.out.println("\n" + threadName.getName() + " sleeping.");
                    Thread.sleep(5000);
                    System.out.println("In " + threadName.getName() + ", count is " + i);
                }
            }
            catch (Exception ex){
                System.out.println(threadName.getName() + " interrupted.");
            }
            System.out.println(threadName.getName() + " terminating.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread starting");
        MyThread mt = MyThread.createAndStart("Child #1");
//        for(int i=0;i<20; i++){
//            System.out.print(".");
//            try{
//                System.out.println("\nMain thread sleeping\n");
//                Thread.sleep(10000);
//            }
//            catch (Exception ex){
//                System.out.println("Main thread interrupted.");
//            }
//        }
        System.out.println("Main thread ending.");
    }
}
