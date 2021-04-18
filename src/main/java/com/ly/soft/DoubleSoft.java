package com.ly.soft;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author leiyi
 * @Description 冒泡排序算法 时间复杂都O(N^2)
 * @date 2021/4/17 17:57
 **/
public class DoubleSoft {

    public static void main(String[] args) {
        int[] array={1,-1,2,5,8};
        doubleSoft(array);

        IntStream.rangeClosed(1,10000000).parallel().forEach(x->{

        });

    }

    public static void doubleSoft(int[] array){
        //对冒泡排序进行优化
        boolean flag=false;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    flag=true;
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag=false;
            }
            System.out.println("第"+(i+1)+"次排序"+ Arrays.toString(array));
        }
        System.out.println("最终排序结果："+Arrays.toString(array));
    }


}
