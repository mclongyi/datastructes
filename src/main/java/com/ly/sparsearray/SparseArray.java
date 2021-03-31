package com.ly.sparsearray;

/**
 * @className: SparseArray
 * @description:
 * 当一个数组中大部分元素为零或同一值时，可以使用稀疏数组来保存该数组。
 * 稀疏数组定义：一个二维数组
 * 第一行 定义 数组行 列 多少个非0值
 * 第二行一次定义 第一个非0值的行 列 值
 * @author: ly
 * @date: 2021/3/30 16:03
 **/
public class SparseArray {

    public static void main(String[] args) {
        int[][] arr=new int[11][11];
        arr[1][2]=1;
        arr[2][3]=2;
        System.out.println("原始数据:");
        for(int[] temp:arr){
            for(int res:temp){
                System.out.printf("%d\t",res);
            }
            System.out.println();
        }
        //统计数组中非0的个数
        int sum=0;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //计算每个非0数据的位置
        int count=0;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    count++;
                    //非0值行
                    sparseArr[count][0]=i;
                    //非0值的列
                    sparseArr[count][1]=j;
                    //非0值
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }
        System.out.println("稀疏数组：");
        for(int[] temp:sparseArr){
            for(int res:temp){
                System.out.printf("%d\t",res);
            }
            System.out.println("");
        }

        //还原稀疏数组到之前的数据
       int[][] orgArr=new int[sparseArr[0][0]][sparseArr[0][1]];
       //赋值
       for(int i=1;i< sparseArr.length;i++){
           orgArr[sparseArr[i][0]][sparseArr[i][1]]= sparseArr[i][2];
       }
        System.out.println("还原后的数组:");
        for(int[] temp:orgArr){
            for(int res:temp){
                System.out.printf("%d\t",res);
            }
            System.out.println("");
        }
    }
}
