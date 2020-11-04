package Questions.Tecent.mypPackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] argv) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8444);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());
        socket.close();
        serverSocket.close();
        inputStream.close();

    }
}
