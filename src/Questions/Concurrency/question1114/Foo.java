package Questions.Concurrency.question1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public Foo(){

    }
    public void first(Runnable printFirst) throws InterruptedException{
        lock.lock();
        printFirst.run();
        count++;
        condition.signalAll();
        lock.unlock();
    }
    public void second(Runnable printSecond) throws InterruptedException{
        lock.lock();
        while(count != 1){
            condition.await();
        }
        printSecond.run();
        count++;
        condition.signalAll();
        lock.unlock();
    }
    public void third(Runnable printThird) throws InterruptedException{
        lock.lock();
        while(count != 2) {
            condition.await();
        }
        printThird.run();
        lock.unlock();
    }
}
