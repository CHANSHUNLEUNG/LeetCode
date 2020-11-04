package Questions.Tecent.mypPackage;

import Questions.File.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Client {
    public static void main(String[] argv) throws IOException {
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
}
