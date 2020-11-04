package Questions.Tecent.Dynamic;

import Questions.Tecent.mypPackage.Server;

import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ProxyFactory {
    public static Object getInstance(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces()
        ,myInvocationHandler);
    }
    public static void main(String[] argv) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        countDownLatch.await();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        Semaphore semaphore = new Semaphore(10);
    }
}
