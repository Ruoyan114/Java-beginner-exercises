package beginner_java_exercise08;

// 接下来是写入文件内容的例子：

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {
        String filePath = "output.txt"; //将要写入的文件
        BufferedWriter writer = null;
        Scanner scanner = new Scanner(System.in);
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            System.out.println("请输入内容，输入'end'结束：");
            String input;
            while (!(input = scanner.nextLine()).equals("end")) {
                writer.write(input);
                writer.newLine(); //换行
                writer.flush(); //刷新缓冲区，确保内容被写入文件
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

/*
在上面的例子中，BufferedReader和BufferedWriter被用于高效地读取和写入文件。
FileReader和FileWriter分别用于创建读取和写入字符文件的便捷流。
当读取文件时，我们逐行读取文件内容，直到文件的末尾。当写入文件时，
我们使用Scanner从控制台读取用户输入，直到用户输入"end"为止。
每次读取一行输入后，我们将其写入文件，并在每行之间添加换行符。
需要注意的是，在读写文件时，我们使用了try-catch-finally语句来处理可能发生的异常，
并确保在读写操作完成后，文件流被正确关闭。
 */