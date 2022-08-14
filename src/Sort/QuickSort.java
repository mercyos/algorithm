package Sort;

public class QuickSort {
    public static void quickSort(int[] arry){
        if(arry.length < 2){
            return;
        }
        quickSort(arry,0,arry.length - 1);
    }
    public static void quickSort(int[] arry, int l, int r){
        //递归实现
        //随机取一个数与数组末尾数交换
        swap(arry,(int)(Math.random() * (r - l + 1)),r);
        //这个方法返回的是划分区域的左边界与右边界，看视频理解下，第P4视频最后部分
        int[] p = partition(arry,l,r);
        quickSort(arry, l, p[0] - 1);
        quickSort(arry, p[1] + 1, r);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int[] partition(int[] arry,int l, int r){
        //这里为什么要设置less和more要理解下，我们要分成三个部分，小于的等于的和大于的，没有less的话无法区分等于的
        int less = l;
        int more = r;
        while(l < more){
            if(arry[l] < arry[r]){
                swap(arry,++less,l++);
            }
            else if(arry[l] > arry[r]){
                swap(arry,--more,l);
            }
            else{
                l++;
            }
        }
        swap(arry,more,r);
        //这个方法返回的是划分区域的左边界与右边界，看视频理解下，第P4视频最后部分
        return new int[] { less + 1, more };
    }
}
