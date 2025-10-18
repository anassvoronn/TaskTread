package org.nastya.tasks;

public class Main6 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                counter.increase();
                System.out.println("t1: " + counter.get());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                counter.increase();
                System.out.println("t2: " + counter.get());
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class Counter {
        volatile int counter = 0;

        public synchronized void increase() {
            counter++;
        }

        public int get() {
            return counter;
        }
    }
}
