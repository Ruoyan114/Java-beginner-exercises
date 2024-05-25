package operation_system_ex09;
/*
客户端进程（Client.java）:
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建Socket连接
        Socket socket = new Socket("localhost", 12345);
        System.out.println("客户端已连接服务器！");

        // 获取输出流，向服务器发送消息
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println("你好，服务器！");
        pw.println("我是客户端，很高兴和你通信！");

        // 关闭资源
        pw.close();
        socket.close();
    }
}

/*
首先运行服务器进程，然后运行客户端进程。你会看到服务器接收到客户端发送的消息，并打印出来。
注意：在实际应用中，你可能需要处理更多的异常情况，以及更复杂的通信协议。此外，如果你的应用需要在同一台机器上的不同进程间通信，
可能使用Java的java.nio.channels.Pipe或java.nio.channels.Selector等类会更为合适。
如果你需要在不同的Java虚拟机或不同的机器上的进程间通信，那么使用套接字或网络协议会是更好的选择。
 */