package com.ly.source;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @className: JDKAppMain
 * @description: TODO 类描述
 * @author: ly
 * @date: 2021/4/2 15:38
 **/
public class JDKAppMain {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue(4);
        queue.put(11);
        queue.put(22);
        queue.put(33);
        Integer take = queue.take();
        System.out.println(take);
        Integer peek = queue.peek();
        System.out.println(queue.size());

    }
}
