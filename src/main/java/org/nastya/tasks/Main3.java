package org.nastya.tasks;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1A = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
            }
        });

        Thread t2B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }
        });

        t1A.start();
        t2B.start();

        t1A.join();
        t2B.join();
    }
}
