package Algorithms.math;

import java.util.ArrayList;

/**
 * Created by Vamsi on 7/14/2016.
 */
public class AllFactors {


    public static void main(String[]args){
        AllFactors allFactors = new AllFactors();
        ArrayList<Integer> output= allFactors.allFactors(234234);
            output.stream().forEach(System.out::println);
    }
        public ArrayList<Integer> allFactors(int a) {

            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(1);
            for(int i=2;i<=Math.sqrt(a);i++){

                if(a%i==0){
                    if(i!=a/i){
                    output.add(i);
                    output.add(a/i);}
                    else{
                      output.add(i);
                    }
                        }
            }
               if( !output.contains(a))output.add(a);
            output.sort((x,y)-> x-y);
            return output;
        }




}
