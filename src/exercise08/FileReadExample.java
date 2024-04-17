package exercise08;

/*
在Java中，文件读写操作通常涉及到使用java.io包中的类。以下是一个简单的例子，
展示了如何使用Java的IO类库来读取文本文件的内容并显示到控制台，以及将用户输入写入到文件中。
首先是读取文件内容的例子：
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    /*
    n the given code, FileReader is instantiated and immediately wrapped
    by a BufferedReader. This setup allows the program to read from example.txt
    efficiently and comfortably, handling each line of text within a loop until
    the end of the file is reached (readLine() returns null).
    This approach minimizes the complexity of the code while maximizing performance
    for reading text files.
     */
    public static void main(String[] args) {
        String filePath = "example.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); //打印每一行的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close(); //读取完毕后关闭文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}