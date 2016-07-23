package Java.Arrays;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by Vamsi on 7/16/2016.
 */
public class MergeInterval {

    public static void main(String[] args) {

       /* Example 1:

        Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

        Example 2:

        Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
*/
        ArrayList<Interval> intervals = new ArrayList<>();
        MergeInterval mergeInterval = new MergeInterval();
        //intervals.add(new Interval(1, 2));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(2, 5);
        mergeInterval.insert(intervals, newInterval).stream().forEach(System.out::println);
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        long newIntervalStart = newInterval.start;
        long newIntervalEnd = newInterval.end;
        int highIndex = 0;
        int lowIndex = 0;
        boolean lowFlag = false;
        boolean highFlag=false;
        if(newIntervalStart<=intervals.get(0).start && newIntervalEnd>=intervals.get(intervals.size()-1).end){
            intervals.clear();
            intervals.add(newInterval);
            return intervals;
        }
        if (newIntervalStart > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        if (newIntervalEnd < intervals.get(0).start) {
            intervals.add(0,newInterval);
            return intervals;
        }
        for (int i = intervals.size() - 1; i >= 0; i--) {
            if (newIntervalEnd <= intervals.get(i).end && newIntervalEnd >= intervals.get(i).start) {
                highIndex = i;
                highFlag=true;
            }
            if (newIntervalStart <= intervals.get(i).end && newIntervalStart >= intervals.get(i).start) {
                lowIndex = i;
                lowFlag=true;
            }
            if(newIntervalEnd< intervals.get(i).start && newIntervalStart>intervals.get(i-1).end ){
                intervals.add(i,newInterval);
                return  intervals;
            }
        }

        if(lowFlag&&highFlag) {
            return MergeInterval(intervals, lowIndex, highIndex);
        }



        return intervals;
    }
    public ArrayList<Interval> MergeInterval(ArrayList<Interval> intervals, int lowIndex, int highIndex) {
        ArrayList<Interval> newIntervals = new ArrayList<>();
        IntStream.range(0, lowIndex).forEach(x -> newIntervals.add(intervals.get(x)));
        newIntervals.add(new Interval(intervals.get(lowIndex).start, intervals.get(highIndex).end));
        IntStream.range(highIndex + 1, intervals.size()).forEach(x -> newIntervals.add(intervals.get(x)));
        return newIntervals;
    }
}

/**
 * Definition for an interval.
 **/
class Interval {
    long start;
    long end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(long s, long e) {
        this.start = s;
        this.end = e;
    }

    public String toString() {

        return "[" + start + "," + end + "]";

    }
}


