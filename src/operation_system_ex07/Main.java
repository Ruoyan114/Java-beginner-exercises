package operation_system_ex07;
/*
模拟实现一个操作系统的文件系统是一个相对复杂的任务，它涉及到文件的结构、存储、检索和操作等多个方面。
以下是一个简化的Java实现例子，它使用内存中的HashMap来模拟文件系统的目录结构，并实现了基本的文件创建、
读取、写入和删除操作。请注意，这个实现并不考虑并发控制、错误处理、持久化存储等高级特性，仅作为教学示例。
 */

import java.util.HashMap;
import java.util.Map;

class File {
    String name;
    String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class FileSystem {
    private Map<String, Object> fileSystem;

    public FileSystem() {
        fileSystem = new HashMap<>();
    }

    public void createFile(String path, String content) {
        String[] parts = path.split("/");
        String fileName = parts[parts.length - 1];
        String directoryPath = path.substring(0, path.lastIndexOf("/"));

        Map<String, Object> currentDirectory = fileSystem;
        for (String part : directoryPath.split("/")) {
            if (!currentDirectory.containsKey(part)) {
                currentDirectory.put(part, new HashMap<>());
            }
            currentDirectory = (Map<String, Object>) currentDirectory.get(part);
        }

        currentDirectory.put(fileName, new File(fileName, content));
    }

    public String readFile(String path) {
        String[] parts = path.split("/");
        String fileName = parts[parts.length - 1];
        String directoryPath = path.substring(0, path.lastIndexOf("/"));

        Map<String, Object> currentDirectory = fileSystem;
        for (String part : directoryPath.split("/")) {
            currentDirectory = (Map<String, Object>) currentDirectory.get(part);
            if (currentDirectory == null) {
                throw new RuntimeException("Directory not found: " + directoryPath);
            }
        }

        File file = (File) currentDirectory.get(fileName);
        if (file == null) {
            throw new RuntimeException("File not found: " + path);
        }
        return file.getContent();
    }

    public void writeFile(String path, String content) {
        String[] parts = path.split("/");
        String fileName = parts[parts.length - 1];
        String directoryPath = path.substring(0, path.lastIndexOf("/"));

        Map<String, Object> currentDirectory = fileSystem;
        for (String part : directoryPath.split("/")) {
            currentDirectory = (Map<String, Object>) currentDirectory.get(part);
            if (currentDirectory == null) {
                throw new RuntimeException("Directory not found: " + directoryPath);
            }
         }

        File file = (File) currentDirectory.get(fileName);
        if (file == null) {
            throw new RuntimeException("File not found: " + path);
        }
        file.setContent(content);
    }

    public void deleteFile(String path) {
        String[] parts = path.split("/");
        String fileName = parts[parts.length - 1];
        String directoryPath = path.substring(0, path.lastIndexOf("/"));

        Map<String, Object> currentDirectory = fileSystem;
        for (String part : directoryPath.split("/")) {
            currentDirectory = (Map<String, Object>) currentDirectory.get(part);
            if (currentDirectory == null) {
                throw new RuntimeException("Directory not found: " + directoryPath);
            }
        }

        currentDirectory.remove(fileName);
    }
}

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        // 创建文件
        fileSystem.createFile("/folder1/file1.txt", "Hello, world!");
        fileSystem.createFile("/folder2/file2.txt", "Another file content.");

        // 读取文件
        System.out.println(fileSystem.readFile("/folder1/file1.txt"));  // 输出: Hello, world!
        System.out.println(fileSystem.readFile("/folder2/file2.txt")); // 输出: Another file content.

        // 写入文件
        fileSystem.writeFile("/folder1/file1.txt", "Updated content.");
        System.out.println(fileSystem.readFile("/folder1/file1.txt")); // 输出: Updated content.

        // 删除文件
        fileSystem.deleteFile("/folder2/file2.txt");
        // fileSystem.readFile("/folder2/file2.txt"); // 这将抛出异常，因为文件已被删除

    }
}

/*
这个简单的实现使用了一个嵌套的HashMap来模拟文件系统的目录结构。每个目录都是一个Map，其键是子目录或文件的名称，
值是另一个Map或File对象。创建文件时，程序会遍历路径中的每个部分，并在当前目录中创建新的子目录或文件。
读取、写入和删除文件时，程序也会遍历路径并定位到相应的目录和文件。

 */












