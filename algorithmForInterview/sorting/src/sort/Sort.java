package sort;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        int[] nums={4,5,3,2,1};
        System.out.println(Arrays.toString(nums));
        new Sort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] arr){  //需要记住的局部变量: rear,flag
        if(arr==null || arr.length<=1) return;
        int rear=arr.length-1;
        boolean flag=false;
        for(int i=0;i<arr.length;i++){  //经过arr.length-1此冒泡操作，数组排序完成
            flag=false;
            for(int j=0;j<rear;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    flag=true;
                }
            }
            rear--;  //尾部下标rear的元素排序完成，rear--
            if(flag==false) break;
        }
    }



//    public void quickSort(int[] arr) {
//        qsort(arr, 0, arr.length - 1);
//    }
//
//    private void qsort(int[] arr, int low, int high) {
//        if (low < high) {
//            int pivot = partition(arr, low, high);        // 将数组分为两部分
//            qsort(arr, low, pivot - 1);                   // 递归排序左子数组
//            qsort(arr, pivot + 1, high);                  // 递归排序右子数组
//        }
//    }
//
//    private int partition(int[] arr, int low, int high) {
////        int index=(int)(Math.random()*(high-low)+low+1);  //生成[low,high]之间的随机下标，Math.random()生成[0,1.0)之间的随机数
////        int pivot=arr[index];  //随机选择枢轴值
////        arr[index]=arr[low];
////        arr[low]=pivot;
//        int pivot = arr[low];               // 枢轴记录
//        while (low < high) {
//            while (low < high && arr[high] >= pivot) --high;
//            arr[low] = arr[high];           // 交换比枢轴小的记录到左端
//            while (low < high && arr[low] <= pivot) ++low;
//            arr[high] = arr[low];           // 交换比枢轴大的记录到右端
//        }
//        // 扫描完成，枢轴到位
//        arr[low] = pivot;
//        // 返回的是枢轴的位置
//        return low;
//    }


    public void quickSort(int[] arr,int low,int high){
        if(low>=high) return;
        int pivot=partition(arr,low,high);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }

    public int partition(int[] arr,int low,int high){
        /*快排划分算法，返回arr[low]元素对应的划分位置j。使得比arr[low]小的元素都在j的左边，比arr[low]大的元素都在j的右边，
        arr[Low]交换到j位置*/
        if(low>=high) return low;
        int pivot=arr[low];
        int i=low+1;  //此处需要保留low的位置，故需要用i,j来完成比较和对换
        int j=high;
        while (i<=j){
            while (i<=j&&arr[j]<=pivot) i++;
            while (i<=j&&arr[j]>pivot) j--;
            if(i<j){
                int tmp=arr[j];
                arr[j]=arr[i];
                arr[j]=tmp;
            }
        }
        arr[low]=arr[j];  //j处的元素<=pivot，故交换pivot和arr[j]的值
        arr[j]=pivot;
        return j;  //j即pivot的正确位置
    }



    /*归并排序的三个子程序*/
    public void mergeSort(int[] arr) {  //提供标准接口
        if (arr == null || arr.length <= 1) return;

        int[] temp = new int[arr.length];  //归并排序需要一个辅助数组
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp){  //归并排序主程序
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp){  //合并两个有序数组的方法
        if(left==right) return;

        int i=left,j=mid+1,k=left;

        while(i<=mid && j<=right){  //合并两个有序数组的"3 while"操作
            if(arr[i]<arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=right) temp[k++]=arr[j++];

        for(k=left;k<=right;k++){  //这一步必不可少！将排序好的数组放回arr中
            arr[k]=temp[k];
        }
    }



}
