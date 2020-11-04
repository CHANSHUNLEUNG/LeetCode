package Questions.Tecent.mypPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

public class FileNio {
    public void inDirectFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Leotest");
        FileOutputStream fileOutputStream = new FileOutputStream("Leotest2");
        FileChannel fileChannel = fileInputStream.getChannel();
        FileChannel fileChannel1 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            fileChannel1.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();;
        fileChannel1.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
    public void directFile() throws  IOException{
        FileChannel fileChannel = FileChannel.open(Paths.get("Leotest"));
        FileChannel fileChannel1 = FileChannel.open(Paths.get("Leotest3"),
                StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileChannel.size());
        MappedByteBuffer mappedByteBuffer1 = fileChannel1.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size());

        byte[] buffer = new byte[mappedByteBuffer.limit()];
        mappedByteBuffer.get(buffer);
        mappedByteBuffer1.put(buffer);

        fileChannel.close();;
        fileChannel1.close();

    }

    public void transfer() throws IOException {
        FileChannel fileChannel = FileChannel.open(Paths.get("Leotest"));
        FileChannel fileChannel1 = FileChannel.open(Paths.get("Leotest4"),
                StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        fileChannel.transferTo(0,fileChannel.size(),fileChannel1);
        fileChannel.close();
        fileChannel1.close();
    }
    public static void main(String[] argv) throws IOException, ClassNotFoundException {
        Class<?> fileNio = Class.forName("FileNio");
        Constructor<?>[] constructors = fileNio.getConstructors();
        
    }
}
