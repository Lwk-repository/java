package IP.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 */
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            // ip， 端口
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // socket连接
            socket = new Socket(serverIP, port);
            os = socket.getOutputStream();
            // 发送消息
            os.write("德玛西亚".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
