package Java.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Vamsi on 7/16/2016.
 */
public class LargestNumber {

    public static void main(String[] args){

        //[3, 30, 34, 5, 9]

        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);

        LargestNumber largestNumber = new LargestNumber();

        System.out.println(largestNumber.largestNumber(list));

    }

    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
        StringBuilder output = new StringBuilder();
        ArrayList<Integer> out = new ArrayList<>();
        if(a.stream().filter(i->i>0).toArray().length==0){
            return "0";
        }
        IntStream.range(0,a.size()).forEach(x->out.add(a.get(x)));
        Collections.sort(a, (x, y) -> (y.toString() + x.toString()).compareTo((x.toString()+y.toString())));
        a.stream().forEach(output::append);
        return output.toString();

    }
}
