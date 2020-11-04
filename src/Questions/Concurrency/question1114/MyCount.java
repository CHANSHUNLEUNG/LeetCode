package Questions.Concurrency.question1114;

public class MyCount {
    public static int count = 0;
    public synchronized void add(){
        count++;
    }
}
