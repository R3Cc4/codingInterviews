package Java.Arrays;

import java.util.ArrayList;

/**
 * Created by Vamsi on 7/15/2016.
 */
public class AddOneToNumber {

    public static void main(String[] args){

        ArrayList<Integer> input = new ArrayList<>();
        //input.add(0);
        input.add(9);
        input.add(9);
        input.add(9);
        input.add(9);

        AddOneToNumber addToNumber = new AddOneToNumber();
        ArrayList<Integer> list = addToNumber.plusOne(input);

       list.stream().forEach(System.out::print);


    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> output = new ArrayList<>();
        output.add(0);
        a.stream().forEach(output::add);
        int carryOver=0;
        int temp =0;
        for(int i=output.size()-1;i>=0;i--){
            if(i==output.size()-1){
                if(output.get(i)==9) {
                    output.set(i, 0);
                    carryOver=1;
                }else{
                    output.set(i,output.get(i)+1);
                }
            }
            else{
                if (output.get(i) == 9 && carryOver==1) {
                    output.set(i, 0);
                    carryOver = 1;
                } else {
                    output.set(i, output.get(i) + carryOver);
                    carryOver = 0;
                    break;
                }
            }
        }
        ArrayList<Integer> out = new ArrayList<>();
        boolean flag = false;
        for(Integer i : output){
            if(i==0 && !flag ){
                continue;
            }else{
                flag=true;
                out.add(i);
            }
        }
        return out;
    }
}
