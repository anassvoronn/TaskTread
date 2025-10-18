package org.nastya.tasks;

public class Main5 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(t.getState());
        }
    }
}
