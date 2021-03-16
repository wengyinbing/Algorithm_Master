package internet;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author wengyinbing
 * @data 2021/3/16 16:14
 **/
public class Server extends  Thread{
    private ServerSocket server;
    public Server(int port ,int timeout) throws IOException {
        this.server = new ServerSocket(port,timeout);
    }

    public void run(){
        while(true){
            try{
                System.out.println(server.getLocalPort() + " " + server.getLocalSocketAddress());
                Socket s = server.accept();
                System.out.println("远程主机地址为；"+ s.getRemoteSocketAddress());

                //接收和传送数据
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println("接收客户端数据为：");
                System.out.println(dis.readUTF());//readUTF（）

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("谢谢连接我！"  + s.getLocalSocketAddress());


            }
            catch(SocketTimeoutException s){
                System.out.println("超时！！！！！");
                break;
            }
            catch(Exception e){
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        int timeout = 10000000;
        try{
            Server s = new Server(port,timeout);
            s.run();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
