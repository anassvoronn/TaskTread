package org.nastya.tasks;

public class Main9 {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();

        Thread pingT1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    pingPong.ping();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread pongT2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    pingPong.pong();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        pingT1.start();
        pongT2.start();
    }
}

class PingPong{
    private boolean pingGive = true;

    public synchronized void ping() throws InterruptedException {
        while (!pingGive) {
            wait();
        }
        System.out.println("Ping");
        pingGive = false;
        notify();
    }

    public synchronized void pong() throws InterruptedException {
        while (pingGive) {
            wait();
        }
        System.out.println("Pong");
        pingGive = true;
        notify();
    }
}
