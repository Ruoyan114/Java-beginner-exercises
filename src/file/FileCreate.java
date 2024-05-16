package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    //method1
    @Test
    public void create01() {
        String filePath = "/Users/ruoyanjiang/Desktop/news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("file created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method2
    @Test
    public void create02() {
        File parentFile = new File("/Users/ruoyanjiang/Desktop");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method3
    @Test
    public void create03() {
        String parentPath = "/Users/ruoyanjiang/Desktop";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
