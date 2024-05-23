package operation_system_exercise04;
/*
接下来，我们定义一个FileManager类来管理文件系统的操作，并使用synchronized关键字来确保线程安全：
 */

import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private Map<String, FileSystemFile> files = new HashMap<>();

    public synchronized void createFile(String name, String content) {
        if (files.containsKey(name)) {
            throw new IllegalArgumentException("File with name " + name + " already exists");
        }
        FileSystemFile file = new FileSystemFile(name, content);
        files.put(file.getId(), file);
    }

    public synchronized FileSystemFile getFile(String id) {
        return files.get(id);
    }

    public synchronized void deleteFile(String id) {
        FileSystemFile file = files.get(id);
        if (file != null) {
            file.delete();
            files.remove(id);
        } else {
            throw new IllegalArgumentException("File with id " + id + " does not exist");
        }
    }

    public synchronized void updateFileContent(String id, String newContent) {
        FileSystemFile file = files.get(id);
        if (file != null) {
            file.setContent(newContent);
        } else {
            throw new IllegalArgumentException("File with id " + id + " does not exist");
        }
    }

    // 其他可能需要的方法，比如列出所有文件等
    public synchronized Map<String, String> listAllFiles() {
        Map<String, String> fileList = new HashMap<>();
        for (FileSystemFile file : files.values()) {
            fileList.put(file.getId(), file.getName());
        }
        return fileList;
    }
}

/*
请注意，上面的示例非常简化，仅用于说明如何开始实现一个文件管理系统。在实际应用中，你可能需要考虑更多的细节，
比如错误处理、日志记录、性能优化、安全性以及更复杂的并发控制策略（如使用读写锁、信号量或其他并发工具）。
此外，上面的示例中文件被存储在内存映射的HashMap中，并且文件的实际内容被存储在磁盘上的files目录中。
每个文件都有一个唯一的ID作为键。当然，在真实场景中，你可能还需要处理文件的元数据、访问权限、文件路径的持久化存储等问题。
为了测试这个系统，你可以创建一些线程来模拟并发访问，并观察FileManager中的synchronized方法如何确保线程安全。
但是，请注意，synchronized关键字可能会导致性能瓶颈，特别是在高并发场景下。因此，在生产环境中，你可能需要考虑使用更高效的并发控制策略。

 */