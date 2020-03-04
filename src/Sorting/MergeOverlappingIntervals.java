/* Given a collection of intervals, merge all overlapping intervals.
    Problem Constraints
    1 <= Total number of intervals <= 100000.

    Input Format
    First argument is a list of intervals.

    Output Format
    Return the sorted list of intervals after merging all the overlapping intervals.

    Example Input
    Input 1:
    [1,3],[2,6],[8,10],[15,18]

    Example Output
    Output 1:
    [1,6],[8,10],[15,18]

    Example Explanation
    Explanation 1:
    Merge intervals [1,3] and [2,6] -> [1,6].
    so, the required answer after merging is [1,6],[8,10],[15,18].
    No more overlapping intervals present.


 */
package Sorting;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
    static public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args) {
        Interval i1 = new Interval(5,20);
        Interval i2 = new Interval(6,8);
        Interval i3 = new Interval(9,17);
        Interval i4 = new Interval(10,13);
        Interval i5 = new Interval(15,18);
        Interval i6 = new Interval(1,6);
        Interval i7 = new Interval();

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        intervals.add(i6);
        intervals.add(i7);
        printIntervals(intervals);
        ArrayList<Interval> result = merge(intervals);
        printIntervals(result);
    }

    private static void printIntervals(ArrayList<Interval> result) {
        for (Interval interval : result) {
            System.out.print("[ " + interval.start + " , " + interval.end + "]  ");
        }
        System.out.println();
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((interval1,interval2) -> {
            int s1 = interval1.start;
            int s2 = interval2.start;
            return Integer.compare(s1,s2);
        });
        ArrayList<Interval> result = intervals;
        int resultSize = intervals.size();
        int updatedResultSize = resultSize+1;
        while(resultSize < updatedResultSize) {
            updatedResultSize = resultSize;
            result = mergeIntervals(result);
            resultSize = result.size();
        }
        return result;
    }

    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        for (int i =0; i< intervals.size(); ){
            Interval interval = intervals.get(i);
            int begin = interval.start;
            int end = interval.end;
//            System.out.println(begin+" , "+end);
            int j = i+1;
            if(j < intervals.size()) {
                while (intervals.get(j).start <= end) {
                    end = Math.max(intervals.get(j).end, end);
                    j++;
                    if (j == intervals.size()) break;
                }
            }
            j--;

            result.add(new Interval(begin, end));
            i = j+1;
        }
        return result;
    }
}
