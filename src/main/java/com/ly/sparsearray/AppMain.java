package com.ly.sparsearray;

import java.util.Scanner;

/**
 * @className: AppMain
 * @description: TODO 类描述
 * @author: ly
 * @date: 2021/3/30 19:24
 **/
public class AppMain {

    public static void main(String[] args) {
/*        ArrayQueue<Integer> arrayQueue=new ArrayQueue(4);
        arrayQueue.addQueue(12);
        arrayQueue.addQueue(20);
        arrayQueue.addQueue(30);
        arrayQueue.addQueue(40);
        System.out.println(arrayQueue.toString());
        System.out.println("出队");
        arrayQueue.getQueue();
        System.out.println("获取队首元素");
        System.out.println(arrayQueue.peekQueue());
        arrayQueue.getQueue();
        System.out.println("获取队首元素");
        System.out.println(arrayQueue.peekQueue());*/

        CycleQueue<Integer> queue=new CycleQueue<>(4);
        char key;
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出系统");
            System.out.println("a(add):添加队列数据");
            System.out.println("g(get):取出队列数据");
            System.out.println("h(head):查看队列头部元素");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.printf();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int val=scanner.nextInt();
                    queue.addQueue(val);
                    break;
                case 'g':
                    queue.getQueue();
                    break;
                case 'h':
                    queue.peekQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }

        }


    }
}
