package july.Algorithms.Sorting;

import java.util.Arrays;

/**
 * Created by Vamsi on 7/16/2016.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] A = {2,7,4,5,6,1,3,0,-8,78,54};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(A,0,A.length-1);
        Arrays.stream(A).forEach(System.out::println);
    }
    public void quickSort(int[] A, int start,int end){
        if(start<end){
        int pIndex = partitionArray(A,start,end);
        quickSort(A,0,pIndex-1);
        quickSort(A,pIndex,end);}
        else{
            return;
        }
    }
    private int partitionArray(int[] A,int start, int end){
        int pivot = A[end];
        int pIndex=start;
        for(int i=start;i<end;i++){
            int temp;
            if(A[i]<pivot){
                temp=A[pIndex];
                A[pIndex]=A[i];
                A[i]=temp;
                pIndex++;
            }
        }
        A[end]=A[pIndex];
        A[pIndex]=pivot;
        return pIndex;
    }
}
