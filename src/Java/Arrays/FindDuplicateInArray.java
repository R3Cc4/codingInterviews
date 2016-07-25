package Java.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vamsi on 7/24/2016.
 */
public class FindDuplicateInArray {


    public static void main(String[] args){



    }

    public int repeatedNumber(final List<Integer> a) {

        Set<Integer> newMap = new HashSet<>();
        int result=-1;
        for(Integer integer: a){

           if( !newMap.add(integer)){
                result = integer.intValue();
               break;
           }


        }
        return result;
    }




}
