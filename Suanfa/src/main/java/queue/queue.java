package queue;

import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据");
            System.out.println("g(get)：取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

// 使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数组存放数据

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部前一个位置
        rear = -1;  // 指向队列尾部的数据
    }

    // 判断队列是否满
    public boolean isFull() {
        // 数组长度为十，最后一位的下表为9
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 判断队列为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        front ++; // 取出第一位，查看头数据时会显示第二位
        return arr[front];
    }

    // 显示队列所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头部，注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}
