package sample;

import javafx.event.Event;

public class Controller {

    public void ropeClicked(){
        RopedNeedle company = new RopedNeedle();
    }

    public void manyThreads(){
        Thread t1 = new Thread(unlockedCounter);
        Thread t2 = new Thread(unlockedCounter);
        Thread t3 = new Thread(unlockedCounter);

        t1.start();
        t2.start();
        t3.start();
    }

    Runnable unlockedCounter = new Runnable() {
        @Override
        public void run() {
            try {
                for(int i=0; i<100; i++){
                    System.out.println(Thread.currentThread().getId() +": Part " + i);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void messageClicked(Event ev) {
        System.out.println("Hello world!");
    }

    public void sleepClicked(Event ev) {
        try {
            System.out.println("Part 1");
            Thread.sleep(1000);
            System.out.println("Part 2");
            Thread.sleep(1000);
            System.out.println("Part 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
