package Sort;

public class HeapSort {
    public static void heapSort(int[] arry){
        if(arry.length < 2){
            return;
        }
        for(int i = 0; i < arry.length; i++){
            heapInsert(arry,i);
        }
        int size = arry.length;
        //这里将最大值堆顶元素放到最后结点，然后断开这个元素与堆的关系，即取出最大值,注意size的初始值是arry.length
        swap(arry,0,--size);
        while(size > 0){
            heapify(arry,0,size);
            swap(arry,0,--size);
        }
    }


    //堆上浮操作，heapinsert,一个场景就是新插入一个数的时候的入堆操作
    public static void heapInsert(int[] arry,int index){
        while(arry[index] > arry[(index - 1)/2]){
            swap(arry,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    //堆下沉操作，heapfy，使之成为大根堆,heapfy的过程其实就是让堆顶元素到对应的位置，堆顶的元素放好了，整个堆就是一个大根堆
    public static void heapify(int[] arry,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            //这里比较左孩子和右孩子，取大的那一个作为待比较
            int largest = left + 1 < size && arry[left] < arry[left + 1] ? left + 1 : left;
            //然后largest与index进行比较
            largest = arry[largest] > arry[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arry,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
