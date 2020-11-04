package Questions.Concurrency.question1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private Lock lock = new ReentrantLock();
    private boolean hasZero = false;
    private boolean hasOne = false;
    private Condition zeroCondition = lock.newCondition();

    //!hasZero -> 0
    //hasZero && !hasOne -> 1
    //hasZero && hasOne -> 2
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int index=0; index<n; index++){
            lock.lock();
            while(hasZero){
                zeroCondition.await();
            }
            printNumber.accept(0);
            hasZero=true;
            zeroCondition.signalAll();
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int index=2; index<=n; index+=2){
            lock.lock();
            while(!(hasZero && hasOne)){
                zeroCondition.await();
            }
            printNumber.accept(index);
            hasOne = false;
            hasZero = false;
            zeroCondition.signalAll();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int index=1; index<=n; index+=2){
            lock.lock();
            while(!hasZero || hasOne){
                zeroCondition.await();
            }
            printNumber.accept(index);
            hasOne = true;
            hasZero = false;
            zeroCondition.signalAll();
            lock.unlock();
        }
    }
}
