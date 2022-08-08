package Sort;

public class insertSort {
    public static void insertsort(int[] arry){
        //如果这个输入的数组小于两位数，则没有排序的必要了
        if(arry.length < 2){
            System.out.println("没有排序的必要了！");
            return;
        }
        //分两部分，一部分是已经排好序的，另一部分为还未排序的
        //对未排好序的部分进行遍历
        for(int i = 1; i < arry.length; i++){
            //对已排好序的部分进行遍历
            for(int j = i; j > 0 && arry[j] < arry[j - 1]; j--){
                int temp = arry[j - 1];
                arry[j - 1] = arry[j];
                arry[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {3,1,2,4,8,6,9,23};
        int[] input2 = {3};
        insertSort.insertsort(input);
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + ",");
        }

    }
}
