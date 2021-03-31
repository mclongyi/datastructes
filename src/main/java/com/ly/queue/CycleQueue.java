package com.ly.queue;

import java.util.Arrays;

/**
 * @className: CycleQueue
 * @description: 循环队列
 * front 是队列的第一个元素从0开始 real是队列的最后一个元素
 * [real+1]%size == front表示队列满
 * real==front表示队列空
 * [real+size-front]%size 表示的是可用大小
 * @author: ly
 * @date: 2021/3/30 22:31
 **/
public class CycleQueue<E> {
    private E[] arr;
    //定义队列头
    private int front;
    //定义队列尾部
    private int real;
    //定义队列的容量
    private int size;

    public CycleQueue(int size){
        this.size=size;
        arr=(E[])new Object[size];
    }

    /**
     * 判断队列为空
     * @return
     */
    public boolean isEmpty(){
        return real == front;
    }

    /**
     * 判断队列满
     * @return
     */
    public boolean isFull(){
        return (real+1)%size == front;
    }

    /**
     * 入队操作
     * @param e
     */
    public void addQueue(E e){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[real]=e;
        real=(real+1)%size;
    }

    /**
     * 出队操作
     * @return
     */
    public E getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
       E val=arr[front];
       front=(front+1)%size;
        return val;
    }

    /**
     * 获取当前队列有效元素
     * @return
     */
    public int getRealSize(){
        return (real+size-front)%size;
    }

    public void  printf() {
        for(int i=front;i<front+getRealSize();i++){
            System.out.printf("arr[%d]=%d\n",i%size,arr[i%size]);
        }
    }

    /**
     * 获取队首元素
     * @return
     */
    public E peekQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
