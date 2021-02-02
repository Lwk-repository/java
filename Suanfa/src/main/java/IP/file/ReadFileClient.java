package IP.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

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
        fs.close();
        os.close();
        socket.close();
    }
}
