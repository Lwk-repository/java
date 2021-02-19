package IP.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 开放端口
        DatagramSocket ds = new DatagramSocket(9090);
        // 接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);//接收
        ds.receive(dp); //阻塞接收
        System.out.println(dp.getAddress().getHostAddress());
        System.out.println(new String(dp.getData()));


        ds.close();
    }
}
