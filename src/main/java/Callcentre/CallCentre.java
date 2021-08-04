package Callcentre;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCentre {
    public ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private static final int MIN_PROCESSING_TIME = 3000;
    private static final int DELAY = 1000;
 //   private static final int NUMBER_OF_CALLS = 60;
    private int callMax = 5;
    private int iterationsMax = 5;
    private int iterations = 1;



    public void newCall(){
        try {
            while (iterations != iterationsMax) {
                for (int i = 1; i < (callMax + 1); i++) {
                    String call = "Запрос " + iterations + "/" + i;
                    queue.add(call);
                    System.out.printf("%s добавил в очередь %s\n", Thread.currentThread().getName(), call);
                }
                iterations++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void TakeACall() {
        String call;
        while ((call = queue.poll()) != null) {
            try {
                Thread.sleep(MIN_PROCESSING_TIME + DELAY);
                System.out.println(call + " обработан " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
