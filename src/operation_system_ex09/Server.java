package operation_system_ex09;
/*
在Java中，进程间通信（IPC）通常不是直接支持的，因为Java是跨平台的，并且其设计初衷是简化内存管理和并发性，而不是进程管理。
然而，你可以使用套接字（Sockets）或文件等方式来模拟进程间通信。以下是一个使用套接字的简单示例。
在这个例子中，我们创建两个Java程序：一个服务器进程和一个客户端进程。服务器进程会等待客户端的连接，并在连接建立后读取从客户端发送的消息。
服务器进程（Server.java）:
 */
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket在端口12345监听客户请求
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("服务器启动成功，等待客户端连接...");

        // 使用accept()方法阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接！");

        // 获取输入流，读取客户端发送的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("我是服务器，客户端说： " + info);
        }

        // 关闭资源
        br.close();
        socket.close();
        serverSocket.close();
    }
}
