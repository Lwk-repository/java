package IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class lessonIp {
    public static void main(String[] args) throws UnknownHostException {
        // 查询本机地址
        InetAddress byName1 = InetAddress.getByName("localhost");
        InetAddress byName2 = InetAddress.getByName("127.0.0.1");
        InetAddress localHost = InetAddress.getLocalHost();
        // 查询百度地址
        InetAddress byName3 = InetAddress.getByName("www.baidu.com");
        System.out.println(localHost);
    }
}
