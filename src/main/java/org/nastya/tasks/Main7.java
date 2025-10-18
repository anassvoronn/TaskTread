package org.nastya.tasks;

public class Main7 {

    public static final int ITERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread d = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(50);
            }
        });

        Thread w = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                account.withdraw(60);
            }
        });

        d.start();
        w.start();

        d.join();
        w.join();

        System.out.println("Итоговый счёт: " + account.get());

    }

    public static class BankAccount {
        volatile int wallet = 0;

        public synchronized void deposit(int amount) {
            wallet += amount;
            System.out.println("Зачисление +" + amount);
        }

        public synchronized void withdraw(int amount) {
            if (wallet < amount) {
                throw new IllegalStateException("Недостаточно денег на счету");
            }

            wallet -= amount;
            System.out.println("Списывание -" + amount);

        }

        public int get() {
            return wallet;
        }
    }
}
