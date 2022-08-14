package Sort;

public class MergeSort {

    public static void mergeSort(int[] arry){
        if(arry.length < 2){
            return;
        }
        mergeSort(arry,0,arry.length - 1);
    }

    public static void mergeSort(int[] arry,int l,int r){
        //递归求解
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        mergeSort(arry,l,mid);
        mergeSort(arry,mid + 1,r);
        //递归结束后，需要将两部分进行merge操作
        merge(arry,l,mid,r);
    }

    public static void merge(int[] arry, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        //第一次自己使用三目运算符，三目运算符适合两个分支的选择的情况
        //当左右两部分都还未到边界的情况
        while(p1 <= m && p2 <=r){
            help[i++] = arry[p1] < arry[p2] ? arry[p1++] : arry[p2++];
        }
        //第一种情况之后，要么是p1<m，p2>l要么是p2<m,p1>r了，所以可以分为以下两种情况
        //当右部分到边界的情况
        while(p1 <= m){
            help[i++] = arry[p1++];
        }
        //当左部分到边界的情况
        while(p2 <= r){
            help[i++] = arry[p2++];
        }
        for(int j = 0; j < help.length; j++){
            arry[l + j] = help[j];
        }
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arry = {3,2,7,0,1};
        mergeSort(arry);
        printArray(arry);
    }
}
