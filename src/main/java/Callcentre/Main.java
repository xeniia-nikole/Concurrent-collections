package Callcentre;

public class Main {
    public static void main(String[] args) {
        int DELAY = 5000;
        int NUMBER_OF_OPERATORS = 3;
        CallCentre callCentre = new CallCentre();

        Thread atc = new Thread(null, callCentre::newCall,
                "АТС " + Thread.currentThread().getId());
        atc.start();


        for (int i = 0; i <= NUMBER_OF_OPERATORS ; i++) {
            try {
                Thread.sleep(DELAY);
                new Thread(null, callCentre::TakeACall,
                        "Оператором № " + (i+1)).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
