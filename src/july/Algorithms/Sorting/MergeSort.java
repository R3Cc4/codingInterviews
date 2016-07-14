package july.Algorithms.Sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Vamsi on 7/14/2016.
 */
public class MergeSort  {




    public void mergeSort(int[] unsortedArray){


        int length = unsortedArray.length;

        if(length<2){
            return;
        }
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        left =IntStream.range(0,left.length).map(i->unsortedArray[i]).toArray();
        right=IntStream.range(0,right.length).map(i -> unsortedArray[mid+i]).toArray();

        mergeSort(left);
        mergeSort(right);
        merge(left,right,unsortedArray);




    }



    public int[] merge(int[] left, int[] right,int [] sorted){

        int lLength = left.length;
        int rLength = right.length;
        int sLength = sorted.length;
        int i=0,j=0,k=0;


        while(i<lLength && j<rLength){

            if(left[i]<right[j]){
                sorted[k]=left[i];
                i++;
            }else{
                sorted[k]=right[j];
                j++;
            }
            k++;

        }

        while(i<lLength){
            sorted[k]=left[i];
            i++;k++;
        }

        while(j<rLength){
            sorted[k]=right[j];
            j++;k++;
        }

        return sorted;
    }
    
    public static void main(String[] args){
        
      int[] unsortedArray = {23,54,23,42,64};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(unsortedArray);
        Arrays.stream(unsortedArray).forEach(System.out::println);


    }

}
