package org.nastya.tasks;

import java.util.LinkedList;

public class Main8 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int CAPACITY = 7;

        Producer producer = new Producer(list, CAPACITY);
        Consumer consumer = new Consumer(list);

        Thread producerT1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    producer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });


        Thread consumerT2 = new Thread(() -> {
            try {
                for (int i = 0; i < 7; i++) {
                    consumer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        producerT1.start();
        consumerT2.start();
    }
}

class Producer{
    private final LinkedList<Integer> list;
    private final int CAPACITY;

    Producer(LinkedList<Integer> list, int capacity) {
        this.list = list;
        CAPACITY = capacity;
    }


    public synchronized void produce(int number) throws InterruptedException {
        while (list.size() == CAPACITY) {
            System.out.println("Список полн, продюсер ждёт");
            list.wait();
        }

        list.add(number);
        System.out.println("Добавлено: " + number);
        notify();
    }
}

class Consumer{
    private final LinkedList<Integer> list;

    Consumer(LinkedList<Integer> list) {
        this.list = list;
    }

    public synchronized void consume() throws InterruptedException {
        if(list.isEmpty()){
            System.out.println("Лист пустой");
            wait();
        }
        int number = list.remove();
        System.out.println("Извлечено: " + number);
        notify();
    }
}
