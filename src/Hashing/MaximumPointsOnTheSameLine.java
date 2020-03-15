/*  MAXIMUM POINTS ON THE SAME LINE

    Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2-D plane.
    A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane.
    Find and return the maximum number of points which lie on the same line.
    Input Format
    The arguments given are integer arrays A and B.
    Output Format
    Return the maximum number of points which lie on the same line.
    Constraints
    1 <= (length of the array A = length of array B) <= 1000
    -10^5 <= A[i], B[i] <= 10^5
    For Example
    Input 1:
        A = [-1, 0, 1, 2, 3, 3]
        B = [1, 0, 1, 2, 3, 4]
    Output 1:
        4
        The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}

    Input 2:
        A = [3, 1, 4, 5, 7, -9, -8, 6]
        B = [4, -8, -3, -2, -1, 5, 7, -4]
    Output 2:
        2

 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnTheSameLine {
    static class Point {
        int x;
        int y;
        Point(int a, int b) { x = a; y = b; }
    }

    public static int solve(int[] A, int[] B) {
        Point[] p = new Point[A.length];
        for(int i=0; i< A.length; i++){
            p[i] = new Point(A[i],B[i]);
        }
        return maxPoints(p);
    }

    public static int maxPoints(Point[] points) {
        //declare hashmap and result variable
        int result = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        //iterate over length of points array of obj
        for (int i = 0; i < points.length; i++) {
            //reset map when considering for every point obj
            map.clear();

            //reset overlap and max declaration to 0 when considering for every fresh point obj in i
            int overlap = 0;
            int max = 0;

            //iterate j from i+1 to points length
            for (int j = i+1; j < points.length; j++) {

                //compute the slope numerator and denominator
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;

                //if both x and y == 0 then both the points in consideration are same, so inc overlap
                //and continue the loop since there is no slope for overlapping points
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }

                //compute the gcd of x and y; so that 2/4 is considered same as 1/2
                int gcd = generateGCD(x, y);

                //if gcd != 0 then bring the x and y to its simplest form
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                //if the map contains x ie slope numerator
                if(map.containsKey(x)) {

                    //if thats the case check whether x is mapped to y ie slope denominator
                    if(map.get(x).containsKey(y)) {
                        //if thats the case then we have found one more point on the same line so get x get y and increment
                        //the value and store it back with an internal key of y mapped overall to x
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        //otherwise new point having a new slope with current point detected so map x with y,1
                        map.get(x).put(y, 1);
                    }
                } else {
                    //if x itself is not present, then create a new map m and map y,1 to m and x,m to map
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                //local max will be max of running value max, and the no of points with slope x/y given by map.get(x).get(y)
                max = Math.max(max, map.get(x).get(y));
            }
            //global result will be max of running result and sum of max + overlap (to consider points that overlap) + 1 to consider current point in consideration
            result = Math.max(result, max + overlap + 1);
        }

        return result; //T O(n^2) S O(1)
    }

    //recurisve function to compute gcd, if remainder is 0 then return divisor else nr = divisor and dr = nr % dr
    private static int generateGCD(int a, int b) {
        if (b == 0) return a;

        return generateGCD(b, a % b);
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 5, 7, -9, -8, 6};
        int[] B = {4, -8, -3, -2, -1, 5, 7, -4};
        System.out.println(solve(A,B));

        int[] C = {-1, 0, 1, 2, 3, 3};
        int[] D = {1, 0, 1, 2, 3, 4};
        System.out.println(solve(C,D));
    }
}
