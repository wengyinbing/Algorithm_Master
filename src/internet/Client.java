package internet;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author wengyinbing
 * @data 2021/3/16 16:13
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "0.0.0.0";
        System.out.println("连接到主机 "+host + port);
        Socket s = new Socket(host,port);
        System.out.println(s.getRemoteSocketAddress());
        //System.out.println(s.g);

        //传递和接收数据
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF(s.getLocalSocketAddress() + "我来了");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        System.out.println("我接收到的信息：");
        System.out.println(dis.readUTF());

        s.close();

    }
}
