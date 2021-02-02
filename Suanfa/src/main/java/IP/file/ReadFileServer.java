package IP.file;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadFileServer {
    public static void main(String[] args) throws IOException {
        // 创建服务
        ServerSocket ss = new ServerSocket(9000);
        // 监听客户端的连接
        Socket socket = ss.accept(); // 阻塞式监听,会一直等客户端连接
        // 获取输入流
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("receive.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        // 通知客户端接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
