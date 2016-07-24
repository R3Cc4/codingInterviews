package Java.Arrays;

import java.util.ArrayList;

/**
 * Created by Vamsi on 7/16/2016.
 */
public class InsertInterval {
    public static void main(String[] args) {

       /* Example 1:

        Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

        Example 2:

        Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
*/
        ArrayList<Interval> intervals = new ArrayList<>();
        InsertInterval insertInterval = new InsertInterval();
        //intervals.add(new Interval(1, 2));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(2, 5);
        insertInterval.insert(intervals, newInterval).stream().forEach(System.out::println);
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> newIntervals = new ArrayList<>();

        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                newIntervals.add(interval);
            }else if(interval.start > newInterval.end){
                newIntervals.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        newIntervals.add(newInterval);

        return newIntervals;
    }

}

/**
 * Definition for an interval.
 **/
class Interval {


    long start;
    long end;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

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


