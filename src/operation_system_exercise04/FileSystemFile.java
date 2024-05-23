package operation_system_exercise04;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

/*
实现一个完整的文件管理系统并考虑并发访问控制是一个复杂的任务，它涉及多个层面的设计，包括用户界面、数据存储、文件操作以及并发控制。
在这里，我将为你提供一个简化版的文件管理系统示例，使用Java编写，并展示基本的文件操作以及使用synchronized关键字实现简单的并发控制。
首先，我们定义一个File类来表示文件系统中的文件：
 */
public class FileSystemFile {
    private String id;
    private String name;
    private String content;
    private Path filePath;

    public FileSystemFile(String name, String content) {
        this.id = UUID.randomUUID().toString(); // 生成唯一的文件id
        this.name = name;
        this.content = content;
        try {
            this.filePath = Paths.get("files", this.id); // 创建文件路径
            Files.createDirectories(filePath.getParent()); // 创建文件所在的目录
            Files.write(filePath, content.getBytes()); //将内容写入文件
        } catch (IOException e) {
            throw new RuntimeException("Error creating file", e);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        try {
            return new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    public void setContent(String content) {
        try {
            Files.write(filePath, content.getBytes()); // 将新的内容写入文件
            this.content = content; // 更新对象的content属性，以反映新的文件内容
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    public void delete() {
        try {
            Files.deleteIfExists(filePath); // 删除文件。如果文件不存在，方法将无操作返回。
        } catch (IOException e) {
            throw new RuntimeException("Error deleting file", e);
        }
    }
}

