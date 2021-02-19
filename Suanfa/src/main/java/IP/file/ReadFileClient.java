package IP.file;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 传文件
 */
public class ReadFileClient {
    public static void main(String[] args) throws IOException {
        // 创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        // 创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3.读取文件
        FileInputStream fs = new FileInputStream("sj.png");
        byte[] buffer = new byte[1024];
        int len;
        while((len = fs.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        // 通知服务器我已经传输完
        socket.shutdownOutput();

        //确定服务器接收完毕才能断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len2;
        while((len2 = is.read(bytes))!=-1){
            baos.write(bytes,0,len2);
        }
        System.out.println(baos.toString());
        baos.close();
        is.close();
        fs.close();
        os.close();
        socket.close();
    }
}
