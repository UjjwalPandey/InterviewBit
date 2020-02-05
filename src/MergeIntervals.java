/** Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1: Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. Make sure the returned intervals are also sorted.
 *
 */

import java.util.ArrayList;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class MergeIntervals {
    public static void main(String[] args) {
//        Interval i1 = new Interval(31935139, 38366404);
//        Interval i2 = new Interval(54099301, 76986474);
//        Interval i3 = new Interval(87248431, 94675146);
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(10,13);
        Interval i5 = new Interval(15,16);

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        Interval newInterval = new Interval(4, 8);
        printIntervals(intervals);
        ArrayList<Interval> result = insert(intervals, newInterval);

        printIntervals(result);
    }

    private static void printIntervals(ArrayList<Interval> result) {
        int totalIntervals = result.size();
        for(int i=0; i< totalIntervals; i++){
            System.out.print("[ "+result.get(i).start+", "+result.get(i).end+"],");
        }
        System.out.println();
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int totalIntervals = intervals.size();
        int startIndex = -1, endIndex = -1;
        System.out.println("New Interval: "+newInterval.start+",  "+newInterval.end);
        for(int i =0; i< totalIntervals; i++){
            if(newInterval.start < intervals.get(i).end){
                startIndex = i;
                int j =0;
                while(newInterval.end > intervals.get(i+j).end){
                    ++j;
                    if(i+j == totalIntervals){
                        break;
                    }
                }

                endIndex = i+j;
                System.out.println("Start: "+startIndex+", End: "+endIndex);
                break;
            }
        }

        ArrayList<Interval> resultArray = new ArrayList<>();
        if(startIndex == -1){
            intervals.add(newInterval);
            return intervals;
        }else if(startIndex == endIndex && newInterval.end < intervals.get(startIndex).start){
            for (int i = 0; i < startIndex; i++) {
                resultArray.add(intervals.get(i));
            }
            resultArray.add(newInterval);
            for (int i = startIndex; i < totalIntervals; i++) {
                resultArray.add(intervals.get(i));
            }
        }else {

            for (int i = 0; i < startIndex; i++) {
                resultArray.add(intervals.get(i));
            }
            int intervalStart, intervalEnd;
            intervalStart = (intervals.get(startIndex).start < newInterval.start) ? intervals.get(startIndex).start : newInterval.start;
            if (endIndex == totalIntervals) {
                intervalEnd = newInterval.end;
            }else if( newInterval.end < intervals.get(endIndex).start){
                intervalEnd = newInterval.end;
                Interval updatedInterval = new Interval(intervalStart, intervalEnd);
                resultArray.add(updatedInterval);
                endIndex--;
                for (int i = endIndex + 1; i < totalIntervals; i++) {
                    resultArray.add(intervals.get(i));
                }
                return resultArray;
            }else {
                intervalEnd = (intervals.get(endIndex).end > newInterval.end) ? intervals.get(endIndex).end : newInterval.end;
            }
            Interval updatedInterval = new Interval(intervalStart, intervalEnd);
            resultArray.add(updatedInterval);

            for (int i = endIndex + 1; i < totalIntervals; i++) {
                resultArray.add(intervals.get(i));
            }
        }
        return resultArray;
    }

}
