package Java.Arrays;

import java.util.ArrayList;

/**
 * Created by Vamsi on 7/14/2016.
 */
public class ArrayRotation {

    public static void main(String[]args){
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(3);
        input.add(4);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(2);

        int b =88;

        ArrayRotation arrayRotation = new ArrayRotation();
       ArrayList<Integer> output= arrayRotation.rotateArray(input, b);

        output.stream().forEach(System.out::println);

    }
        public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            if(B<0){
            B=-1*B;
            }
            if(B>A.size()){
                B= B%A.size();
            }

            for (int i = 0; i+B < A.size(); i++) {
                ret.add(A.get(i + B));
            }
            for(int i=0;i<B;i++){
                ret.add(A.get(i));
            }
            return ret;
        }



}
