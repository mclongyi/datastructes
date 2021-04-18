package com.ly.soft;

import java.util.Arrays;

/**
 * @author leiyi
 * @Description 插入排序 O(N^2)
 * @date 2021/4/17 22:43
 **/
public class InsertSoft {

    public static void main(String[] args) {
        int [] array={10,2,1,6,-1};
        insertSort(array);
    }

    /**
     * @code {10 2 1 6 -1}
     * @param array
     */
    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int insertIndex=i-1;
            int insertValue=array[i];
            while (insertIndex>=0 && insertValue<array[insertIndex]){
                array[insertIndex+1]=array[insertIndex];
                insertIndex--;
            }
            array[insertIndex+1]=insertValue;
            System.out.println("第"+i+"次排序结果"+ Arrays.toString(array));
        }
        System.out.println("最后排序结果："+Arrays.toString(array));

    }
}
