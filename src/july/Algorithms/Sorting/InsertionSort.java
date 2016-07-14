package july.Algorithms.Sorting;

import java.util.Arrays;

/**
 * Created by Vamsi on 7/14/2016.
 */
public class InsertionSort {

    public void sort(int[] unsortedArray){
        int value=0;
        int hole=1;
        for(int i=1;i<unsortedArray.length;i++){
            value=unsortedArray[i];
            hole=i;
            while(hole>0 && unsortedArray[hole-1]>value){
                unsortedArray[hole]=unsortedArray[hole-1];
                hole--;
            }
                unsortedArray[hole]=value;
        }



    }


    public static void main(String[] args){

    int[] input = {1,3,5,2,7,8,4,9};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(input);

        Arrays.stream(input).forEach(System.out::println);
    }
}
