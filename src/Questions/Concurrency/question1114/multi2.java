package Questions.Concurrency.question1114;

public class multi2 extends Thread{

    public Waitnotify waitnotify;

    public multi2(Waitnotify waitnotify) {
        this.waitnotify = waitnotify;
    }
    @Override
    public void run(){
        waitnotify.notifyMethod();
    }
}
