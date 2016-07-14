package Java.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi on 7/14/2016.
 */


public class SpiralMatrix {
    // DO NOT MODIFY THE LIST
    public static void main(String[] args){

        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        ArrayList<Integer> array3 = new ArrayList<Integer>();
        ArrayList<Integer> array4 = new ArrayList<Integer>();

        array1.add(1);
        array1.add(2);
    /*    array1.add(3);
        array1.add(4);
*/
        array2.add(5);
       array2.add(6);
  /*      array2.add(7);
        array2.add(8);
*/
       array3.add(9);
        array3.add(10);
   /*     array3.add(11);
        array3.add(12);
*/
         array4.add(13);
        array4.add(14);
     /*   array4.add(15);
        array4.add(16);

*/

        List<ArrayList<Integer>> finalArray = new ArrayList<ArrayList<Integer>>();

        finalArray.add(array1);
        finalArray.add(array2);
        finalArray.add(array3);
        finalArray.add(array4);

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> outputList=spiralMatrix.spiralOrder(finalArray);
        System.out.println("Output of the Program is : \n");
        outputList.stream().forEach(System.out::println);
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int columns = a.get(0).size();
        int rows = a.size();
        int top=0;
        int bottom=rows-1;
        int left=0;
        int right= columns-1;
        int direction = 0;

        //System.out.println("direction : "+direction+ " Top : "+top+" Bottom : "+bottom+ " Left : "+left+" Right : "+right);
        while(top<=bottom && left<=right){

            if(direction==0){
                if(right-left<0){
                    break;
                }
                for(int i = left; i<=right;i++){
                    //System.out.println(a.get(top).get(i));
                    result.add(a.get(top).get(i));

                }
                top++;
                direction++;
            }
            if(direction ==1){
                if(bottom-top<0){
                    break;
                }
                for(int i = top; i<=bottom;i++){
                    //System.out.println(a.get(i).get(right));
                    result.add(a.get(i).get(right));
                }

                right--;
                direction++;

            }
            if(direction==2){
                if(right - left <0){
                    break;
                }
                for(int i = right; i>=left;i--){
                    //System.out.println(a.get(bottom).get(i));
                    result.add(a.get(bottom).get(i));
                }
                bottom--;
                direction++;

            }
            if(direction==3){
                if(bottom-top < 0){
                    break;
                }
                for(int i = bottom; i>=top;i--){
                    //System.out.println(a.get(i).get(left));
                    result.add(a.get(i).get(left));
                }
                left++;
                direction=0;

            }
            //System.out.println("direction : "+direction+ " Top : "+top+" Bottom : "+bottom+ " Left : "+left+" Right : "+right);
        }



        // Populate result;
        return result;
    }
}