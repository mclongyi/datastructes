package com.ly.queue;

import java.util.Arrays;
import java.util.Objects;

/**
 * @className: ArrayQueue
 * @description: 通过数组的方式实现队列
 * @author: ly
 * @date: 2021/3/30 19:15
 **/
public class ArrayQueue<E> {



    //定义数组容器
    private E[] arr;
    //定义队列头
    private int front;
    //定义队列尾部
    private int real;
    //定义队列的容量
    private int size;
    public ArrayQueue(int size){
        this.size=size;
        arr=(E[])new Object[size];
        front=-1;
        real=-1;
    }

    public boolean isEmpty(){
        return real == front;
    }

    public boolean isFull(){
        return real==size-1;
    }

    /**
     * 入队操作
     * @param e
     */
    public void addQueue(E e){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        real++;
        arr[real]=e;
    }

    /**
     * 出队操作
     * @return
     */
    public E getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    /**
     * 获取队首元素
     * @return
     */
    public E peekQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", front=" + front +
                ", real=" + real +
                ", size=" + size +
                '}';
    }
}
