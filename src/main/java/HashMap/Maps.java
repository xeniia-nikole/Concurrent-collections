package HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
    private ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    private Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    Random random = new Random();
    int max = 1_000_000_000;


    public void writeSynchronizedMap(){
        try {
            for (int i = 1; i < max;  i++) {
                int a = random.nextInt();
                synchronizedMap.put(i,a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readSynchronizedMap(){
        try {
            for (int i = 1; i < max;  i++) {
                synchronizedMap.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeConcurrentHashMap(){
        try {
            for (int i = 1; i < max;  i++) {
                int a = random.nextInt();
                concurrentHashMap.put(i,a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readConcurrentHashMap(){
        try {
            for (int i = 1; i < max;  i++) {
                concurrentHashMap.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
