package Questions.Concurrency.question1114;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waitnotify{

    public synchronized void waitMethod(){
        Lock lock = new ReentrantLock();
        try{
            System.out.println("wait start");
            wait();
            System.out.println("wait notify");
            notify();
            System.out.println("wait end");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void notifyMethod() {
        System.out.println("notify start");
        notify();
        System.out.println("notify wait");
        try{
            wait();
        }catch (InterruptedException e){

        }
        System.out.println("notify end");
    }
}
