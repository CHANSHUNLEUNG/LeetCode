package Questions.Concurrency;

import Questions.tree.question208.Trie;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringClass {
    private static StringBuilder stringBuffer = new StringBuilder();
    public static void addString(StringBuilder stringBuffer){
        for(int index=0; index<1000000; index++){
            stringBuffer.append("1");
        }
    }
    public static void main(String[] argv) throws InterruptedException, IOException {
//        Thread t1 = new Thread(()->{
//            addString(stringBuffer);
//        });
//        Thread t2 = new Thread(()->{
//            addString(stringBuffer);
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        Path path = Paths.get("C:\\Users\\leung\\Desktop\\jmeter\\leotest.txt");
        leotest leotest = new leotest(1,1,2);
        OutputStream outputStream= new FileOutputStream("C:\\Users\\leung\\Desktop\\jmeter\\leotest.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(leotest);
    }
}
