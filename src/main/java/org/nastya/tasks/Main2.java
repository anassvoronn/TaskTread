package org.nastya.tasks;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task2());
        t1.start();
        t1.join();
    }

    public static class Task2 extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Через Thread " + i);
            }
        }
    }
}
