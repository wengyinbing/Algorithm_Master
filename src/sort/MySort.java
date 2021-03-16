package sort;

import javax.management.openmbean.ArrayType;
import java.util.Arrays;
import java.util.Random;

/**
 * @author wengyinbing
 * @data 2021/3/12 21:55
 **/
public class MySort {
    /*
    冒泡排序
    不停的将最大的往后边挪
     */
    public int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }
        int temp = 0;
        for(int i = 0; i < array.length;i++){
            for(int j = 0;j < array.length - i -1;j++)
            {
                if(array[j] > array[j+1]){//比较相邻元素
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    /*
    选择排序
    每次都从没排好中选一个最小的放到排好的后边
    表现最稳定的都是o(n^2)  不稳定算法？？
     */
    public int[] selectSort(int[] array){
        if(array.length == 0){
            return array;
        }
        for(int i=0;i<array.length-1;i++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = i;j < array.length;j++){
                if(array[j] < min){
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
        return array;
    }

    /*
    插入排序
    将未排好序的第一个元素插入到前面排好序之中
    稳定排序
     */
    public int[] insertionSort1(int[] array){
        if(array.length == 0){
            return array;
        }
        for(int i = 1;i < array.length;i++){
            int j = 0;
            while(array[i] > array[j]){
                j++;
            }
            int temp = array[i];

            for(int k = i;k > j ;k--){
                array[k] = array[k-1];
            }
            array[j] = temp;
        }
        return array;
    }
    public int[] insertionSort(int[] array){
        for(int i = 1;i<array.length;i++){
            int cur = array[i];
            int j = 0;
            for(j=i-1;j >= 0;j--){
                if(array[j] > cur){
                    array[j+1] = array[j];
                }
                else{
                   // j++;
                    break;
                }
            }
            //j =  j == -1 ? 0 : j;
            j++;
            array[j] = cur;
        }
        return array;
    }
    /*
    希尔排序
    改良版的插入排序，第一次降低复杂度
    增量序列 5 2 1
     */
    public int[] shellSort(int[] array){
        int[] a = {5,2,1};
        for(int step : a){
            for(int j=0;j<step;j++){
                for(int i=j+step;i<array.length;i+=step){
                    int cur = array[i];
                    int k = 0;
                    for(k = i-step;k >= 0;k-=step){
                        if(array[k] > cur){
                            array[k+step] = array[k];
                        }
                        else{
                            break;
                        }
                    }
                    k += step;
                    array[k] = cur;
                }
            }
        }
        return array;
    }

    /*
    归并排序

     */
    public int[] mergeSort(int[] array){
        if(array.length < 2){
            return array;
        }
        int mid = array.length/2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array,0,mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array,mid,array.length));
        return merge(leftArray,rightArray);
    }
    //合并函数
    public int[] merge(int[] left,int[] right){
        int[] array = new int[left.length + right.length];
        int i = 0,j = 0,k = 0;
        for(;i < left.length && j < right.length;){
            if(left[i] < right[j]){
                array[k] = left[i];
                i++;
            }
            else{
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            array[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            array[k] = right[j];
            j++;
            k++;
        }
        return array;
    }
    /*
    快速排序
     */
    public int[] quickSort(int[] array){
        int index = new Random().nextInt(10);

        return array;
    }
    /*
    堆排序
     */
    public void printarray(int[] array){
        for(int a:array){
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        int[] array = {9,2,1,4,3,7,6,8,5,0};
        MySort ms = new MySort();
       // ms.printarray(ms.mergeSort(array));
        //System.out.println(Math.);
        //System.out.println(Arrays.toString(array));//打印字符串
    }
}
