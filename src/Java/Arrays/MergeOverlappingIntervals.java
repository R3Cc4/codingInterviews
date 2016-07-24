package Java.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Vamsi on 7/24/2016.
 */
public class MergeOverlappingIntervals {



    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */

    /*Given [1,3],[2,6],[8,10],[15,18],

            return [1,6],[8,10],[15,18].*/

    public static void main(String[] args){


        ArrayList<Interval> intervals = new ArrayList<>();
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
        //intervals.add(new Interval(1, 2));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(12, 16));

        mergeOverlappingIntervals.merge(intervals).stream().forEach(System.out::println);




    }
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            ArrayList<Interval> result = new ArrayList<>();

            Collections.sort(intervals,(x,y)->(int)(x.start-y.start));

            for(Interval interval: intervals) {
                if (result.isEmpty()) {
                    result.add(interval);
                }
                if(result.get(result.size()-1).end>=interval.start){

                    result.set(result.size()-1,new Interval(Math.min(result.get(result.size()-1).start,interval.start),Math.max(interval.end,result.get(result.size()-1).end)));
                }else{
                    result.add(interval);
                }
            }
                   return result;
        }

}
/**
 * Definition for an interval.
 **/
