package HashMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Maps map = new Maps();
        System.out.println("Размер мапы -> " + map.max);

        long startMapaConncurrent = System.currentTimeMillis();

        ExecutorService executorServiceConcurrentHashMap =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorServiceConcurrentHashMap.submit(map::writeConcurrentHashMap);
        executorServiceConcurrentHashMap.submit(map::writeConcurrentHashMap);
        executorServiceConcurrentHashMap.submit(map::writeConcurrentHashMap);

        executorServiceConcurrentHashMap.submit(map::readConcurrentHashMap);
        executorServiceConcurrentHashMap.submit(map::readConcurrentHashMap);
        executorServiceConcurrentHashMap.submit(map::readConcurrentHashMap);

        long finishConcurrentHashMap = System.currentTimeMillis();

        System.out.println("Время работы с ConcurrentHashMap, мс: " +
                (finishConcurrentHashMap - startMapaConncurrent));
        executorServiceConcurrentHashMap.shutdown();

        long startSynchronizedMap = System.currentTimeMillis();

        ExecutorService executorServiceSynchronizedMap =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorServiceSynchronizedMap.submit(map::writeSynchronizedMap);
        executorServiceSynchronizedMap.submit(map::writeSynchronizedMap);
        executorServiceSynchronizedMap.submit(map::writeSynchronizedMap);

        executorServiceSynchronizedMap.submit(map::readSynchronizedMap);
        executorServiceSynchronizedMap.submit(map::readSynchronizedMap);
        executorServiceSynchronizedMap.submit(map::readSynchronizedMap);

        long finishSynchronizedMap = System.currentTimeMillis();

        System.out.println("Время работы с Collections.synchronizedMap, мс: " +
                (finishSynchronizedMap - startSynchronizedMap));
        executorServiceSynchronizedMap.shutdown();

//        Размер мапы -> 10
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 2

//        Размер мапы -> 100
//        Время работы с ConcurrentHashMap, мс: 7
//        Время работы с Collections.synchronizedMap, мс: 3

//        Размер мапы -> 1_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 3

//        Размер мапы -> 10_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 9

//        Размер мапы -> 100_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 33

//        Размер мапы -> 1_000_000
//        Время работы с ConcurrentHashMap, мс: 10
//        Время работы с Collections.synchronizedMap, мс: 45

//        Размер мапы -> 10_000_000
//        Время работы с ConcurrentHashMap, мс: 17
//        Время работы с Collections.synchronizedMap, мс: 95

//        Размер мапы -> 100_000_000
//        Время работы с ConcurrentHashMap, мс: 18
//        Время работы с Collections.synchronizedMap, мс: 148

//        Размер мапы -> 1_000_000_000
//        Время работы с ConcurrentHashMap, мс: 17
//        Время работы с Collections.synchronizedMap, мс: 158
    }
}
