package Questions.File;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    public static void main(String[] argv) throws IOException {
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
//                new FileInputStream("C:\\Users\\leung\\Desktop\\jmeter\\leotest.txt")))) {
//            String line;
//            while ((line = bf.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\leung\\Desktop\\jmeter\\leotest.txt"))) {
//            String line;
//            while((line = bf.readLine()) != null){
//                System.out.println(line);
//            }
//        }

        Path path = Paths.get("C:\\Users\\leung\\Desktop\\jmeter\\leotest.txt");
//        System.out.println(Files.readAllLines(path));
//        System.out.println(Files.newBufferedReader(path).readLine());
        try(FileChannel fileChannel = FileChannel.open(path)){
            ByteBuffer bf = ByteBuffer.allocate(8192);
            while(fileChannel.read(bf) != -1){
                System.out.println(new String(bf.array(), Charset.forName("UTF-8")));
                bf.flip();
            }
        }
        try(SeekableByteChannel seekableByteChannel = Files.newByteChannel(path)){
            ByteBuffer bf = ByteBuffer.allocate(8192);
            while(seekableByteChannel.read(bf) != -1){
                System.out.println(new String(bf.array(), Charset.defaultCharset()));
                bf.flip();
            }
        }
    }
}
