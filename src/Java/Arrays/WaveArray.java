package Java.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Vamsi on 7/16/2016.
 */
public class WaveArray {


    public static void main(String[] args){

        //Didn't  write test cases yet!!


    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {

        ArrayList<Integer> output = new ArrayList<>();

        Collections.sort(a);
        int i=0;


        while(i<a.size()){
            if(i<a.size()-1){
            output.add(i+1);
            output.add(i);
            i=i+2;}
            else{
                output.add(i);
                i++;
            }
        }

        return output;
    }

}
