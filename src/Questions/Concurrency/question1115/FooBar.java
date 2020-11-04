package Questions.Concurrency.question1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private boolean hasFoo = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while(hasFoo){
                condition.await();
            }
            printFoo.run();
            hasFoo = true;
            condition.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while(!hasFoo){
                condition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            hasFoo = false;
            condition.signal();
            lock.unlock();
        }
    }
}
