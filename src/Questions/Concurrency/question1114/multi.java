package Questions.Concurrency.question1114;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class multi extends Thread {

    public static ThreadLocal<Integer> tl = ThreadLocal.withInitial(() -> 0);
    public int getNum(){
        tl.set(tl.get()+1);
        return tl.get();
    }
    @Override
    public void run(){
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi" + Thread.currentThread().getName());
    }
    public static void main(String[] argv) throws InterruptedException, ExecutionException {
//
//        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
//        Future<Integer> future = executorService.submit(() -> {
//            sleep(3000);
//            return 3;
//        });
//        System.out.println(future.get());
//        System.out.println("done");
//        executorService.shutdown();
//        executorService.awaitTermination(10,TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(()->{
            System.out.println("hi first");
            return 3;
        }).thenApplyAsync((a)->{
            System.out.println("a:" + a);
            System.out.println("second");
            return 4;
        }).thenAcceptAsync((a)->{
            System.out.println("a:" + a);
            System.out.println("finish");
        });
    }
}