package org.nastya.tasks;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task1());
        t1.start();
        t1.join();
    }

    public static class Task1 implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Через Runnable " + i);
            }
        }
    }
}
