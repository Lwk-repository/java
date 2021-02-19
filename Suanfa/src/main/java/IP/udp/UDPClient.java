package IP.udp;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
//        建立一个socket
        DatagramSocket ds = new DatagramSocket();
//        发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
//        建个包
        String msg = "hello,server";
//        数据,数据长度起始,发送给谁
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,localhost,port);
//        发送包
        ds.send(dp);
        ds.close();
    }
}
