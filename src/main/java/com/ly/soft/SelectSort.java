package com.ly.soft;

import java.util.Arrays;

/**
 * @author leiyi
 * @Description 选择排序 每次选择最小的 进行排序 时间复杂都O(N^2)
 * @date 2021/4/17 20:05
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] array={10,2,1,6,-1};
        selectSort(array);
    }

    public static void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            int min=array[i];
            for(int j=i+1;j<array.length;j++){
                if(min>array[j]){
                    minIndex=j;
                    min=array[j];
                }
            }
            System.out.println("第"+(i+1)+"轮排序");
            if(minIndex!=i){
                array[minIndex]=array[i];
                array[i]=min;
            }
            System.out.println("数组顺序为："+ Arrays.toString(array));
        }
        System.out.println("最后的排序结果为:"+Arrays.toString(array));
    }
}
