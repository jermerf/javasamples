package sample;

public class RopedNeedle {
    int ropeCount = 0;

    public RopedNeedle(){
        Thread manufacturing = new Thread(manufactureRopes);
        Thread shipping = new Thread(shipRopes);
        manufacturing.start();
        shipping.start();
    }

    private synchronized void changeRopeBy(int amount, String changedBy){
        ropeCount += amount;
        System.out.println(changedBy + " changed amount by " + amount);
    }

    Runnable manufactureRopes = () -> {
        try {
            while (true) {
                changeRopeBy(2, "manufacturing");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable shipRopes = () -> {
        try {
            while (true) {
                if (ropeCount >= 10) {
                    changeRopeBy(-10, "shipping");
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };



}
