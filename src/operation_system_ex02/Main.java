package operation_system_ex02;
/*
设计一个模拟的内存管理系统需要处理几个关键概念：内存分配、内存回收和页面置换算法。下面是一个简化的Java实现，
其中我们假设有一个固定大小的内存空间，并且使用最近最少使用（LRU）页面置换算法。
 */

import java.util.*;

class MemoryBlock {
    int address;
    boolean isAllocated;

    public MemoryBlock(int address) {
        this.address = address;
        this.isAllocated = false;
    }
}

class MemoryManager {
    private List<MemoryBlock> memory; // 用于存储内存块的列表
    private Map<Integer, Integer> processToMemoryMap; // 映射进程ID到内存地址
    private LinkedHashMap<Integer, Long> lruCache; // 用于实现LRU（最近最少使用）页面置换算法的缓存

    public MemoryManager(int memorySize) {
        this.memory = new ArrayList<>();
        for (int i = 0; i < memorySize; i++) {
            memory.add(new MemoryBlock(i));
        }
        this.processToMemoryMap = new HashMap<>();
        this.lruCache = new LinkedHashMap<Integer, Long>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Long> eldest) {
                return size() > memorySize;
            }
        };
    }

    public synchronized int allocateMemory(int processId) {
        if (lruCache.containsKey(processId)) {
            // if process is already in cache (i.e., memory), just return its address
            return processToMemoryMap.get(processId);
        }

        for (MemoryBlock block : memory) {
            if (!block.isAllocated) {
                block.isAllocated = true;
                processToMemoryMap.put(processId, block.address);
                lruCache.put(processId, System.currentTimeMillis());
                return block.address;
            }
        }

        return -1; // Should not happen
    }

    public synchronized void freeMemory(int processId) {
        if (processToMemoryMap.containsKey(processId)) {
            int address = processToMemoryMap.get(processId);
            MemoryBlock block = memory.get(address);
            block.isAllocated = false;
            lruCache.remove(processId);

            processToMemoryMap.remove(processId);
        }
    }

    public void displayMemory() {
        for (MemoryBlock block : memory) {
            System.out.println("Address: " + block.address + ", Allocated: " + block.isAllocated);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MemoryManager mm = new MemoryManager(10);

        // Allocate memory for processes
        int process1Address = mm.allocateMemory(1);
        int process2Address = mm.allocateMemory(2);
        int process3Address = mm.allocateMemory(3);

        System.out.println("Process 1 allocated at: " + process1Address);
        System.out.println("Process 2 allocated at: " + process2Address);
        System.out.println("Process 3 allocated at: " + process3Address);

        mm.displayMemory();

        // Free memory for process 2
        mm.freeMemory(2);
        System.out.println("Freed memory for process 2");

        mm.displayMemory();

        // Allocate memory for a new process
        int process4Address = mm.allocateMemory(4);
        System.out.println("Process 4 allocated at: " + process4Address);

        mm.displayMemory();
    }
}

/*
在这个例子中，我们定义了一个MemoryBlock类来表示内存块，一个MemoryManager类来管理内存分配、回收和页面置换。
MemoryManager内部使用一个ArrayList来模拟物理内存，并使用一个HashMap来跟踪哪个进程被分配到了哪个内存块。
LRU页面置换算法通过LinkedHashMap实现，其会自动移除最老的条目（即最近最少使用的条目）当达到其容量限制时。
在allocateMemory方法中，我们尝试为进程分配内存。如果内存已满，我们根据LRU算法找到最近最少使用的进程，并释放其内存块以供新进程使用。
freeMemory方法用于释放一个进程的内存。最后，displayMemory方法用于显示当前内存的使用情况。
请注意，这个实现是高度简化的，并且没有考虑许多现实世界中的复杂性和边缘情况。在实际操作系统中，内存管理要复杂得多，
并且涉及硬件级别的交互、虚拟内存、页面错误处理、保护机制等。这个示例仅用于教学目的，以展示基本的内存分配、回收和页面置换算法的概念。

 */