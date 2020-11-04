package Questions.Concurrency.question1114;

public class multi3 extends Thread{
    public Waitnotify waitnotify;

    public multi3(Waitnotify waitnotify) {
        this.waitnotify = waitnotify;
    }
    @Override
    public void run(){
        synchronized (waitnotify) {
            try {
                System.out.println("multi3 get the lock");
                Thread.currentThread().sleep(500);
            }catch (InterruptedException e){

            }
        }
    }
}
