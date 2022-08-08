package Sort;

import java.io.InputStream;

public class SelectionSort {
    //选择排序
    public static void selectSort(int[] arry){
        //如果数组的下标为0或者小于2，那么没有排序的必要了
        if(arry.length < 2){
            System.out.println("没必要进行排序！！");
            return;
        }
        //i为已排序好的数字，从0开始一直排序到arry.length-1
        for(int i = 0; i < arry.length; i++){
            int temp = 0;
            //i右边开始比较，较小的数字和i进行交换
            for(int j = i; j < arry.length; j++){
                if(arry[i] > arry[j]){
                    temp = arry[i];
                    arry[i] = arry[j];
                    arry[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args){
        int[] input = {2,1,3,4,5};
        SelectionSort.selectSort(input);
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + ",");
        }
    }

}
