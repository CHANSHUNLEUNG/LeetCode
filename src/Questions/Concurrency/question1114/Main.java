package Questions.Concurrency.question1114;

class Chat {
    boolean flag = false;

    public synchronized void Question(String msg) {
            try {
                System.out.println("Question get lock");
                wait(500);
                System.out.println("Question finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Question:" + msg);
        flag = true;
        notify();

    }

    public synchronized void Answer(String msg) {
            try {
                System.out.println("Answer get lock");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Answer:"+msg);
        try {
            Thread.currentThread().sleep(1000);
        }catch (InterruptedException e){

        }
        flag = false;
        notify();
    }
}

class T1 implements Runnable {
    Chat m;
    String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "Question").start();
    }

    public void run() {
        for (int i = 0; i < s1.length; i++) {
            m.Question(s1[i]);
        }
    }
}

class T2 implements Runnable {
    Chat m;
    String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

    public T2(Chat m2) {
        this.m = m2;
        new Thread(this, "Answer").start();
    }

    public void run() {
        for (int i = 0; i < s2.length; i++) {
            m.Answer(s2[i]);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Chat m = new Chat();
//        new T2(m);
        new T1(m);
    }
}