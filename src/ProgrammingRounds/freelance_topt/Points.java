/*
There are N given points (numbered from 0 to N-1) on a plane. The K-th point is located at coordinates (X[K], Y[K]) and its tag is S[K]. We want to draw a circle centered on coordinates (0, 0). The circle should not contain two points with the same tag. What is the maximum number of points that can lie inside the circle?

Write a function:
class Solution { public int solution(String S, int[] X, int[] Y); } that, given a string S of length N and two arrays X, Y consisting of N integers each, returns the maximum number of points inside the circle. The circle may contain only points with distinct tags, and is centered on coordinates (0, 0). Points that are on the border of the circle are included within it.

Examples

    Given S = "ABDCA", X = [2, -1, -4, -3, 3] and Y = [2, -2, 4, 1, -3], the function should return 3. There are three points that can be included in the circle: ("A", 2, 2), ("B", -1, -2), ("C", -3, 1). The next point ("A", 3, -3) has the same tag as ("A", 2, 2), so it cannot be included.
    image
    (Sorry for the partial image)

    Given S = "ABB", X = [1, -2, -2] and Y = [1, -2, 2], the function should return 1. here are two points that cannot be included together: ("B", -2, -2) and ("B", -2, 2). They both have the tag "B" and the same distance from coordinates (0, 0). (I guess, if two point have same distance, it cannot be included, though I am not sure because it's written nowhere in problem statement)
    image

    Given S = "CCD", X = [1, -1, 2] and Y = [1, -1, -2], the function should return 0. The points with tag "C" have the same distance from coordinates (0, 0).
    image

Can you tell me how to solve this? Solution with code is highly appreciated. Thanks in advance.

I have some more questions about this problem:

    If it were a LeetCode problem, would this be Easy, Medium or Hard?
    Is this a real interview question?

https://leetcode.com/discuss/interview-question/602200/maximum-enclosed-points-with-distinct-tags
 */


package ProgrammingRounds.freelance_topt;

import java.util.*;

public class Points {
    public static void main(String[] args) {
        String S1 = "ABDCA";
        String S2 = "ABB";
        String S3 = "CCD";
        int[] X1 = {2, -1, -4, -3, 3}, Y1 = {2, -2, 4, 1, -3};
        int[] X2 = {1, -2, -2}, Y2 = {1, -2, 2};
        int[] X3 = {1, -1, 2}, Y3 = {1, -1, -2};
        System.out.println(solve(S1, X1, Y1));
        System.out.println(solve(S2, X2, Y2));
        System.out.println(solve(S3, X3, Y3));

    }

    private static int solve(String s, int[] x, int[] y) {
        Queue<Point> minHeap = new PriorityQueue<>((a, b)->a.dist - b.dist);
        for(int i=0;i<s.length();i++) {
            minHeap.offer(new Point(s.charAt(i), x[i], y[i]));
        }
        Set<Character> visited = new HashSet<>();
        int res = 0;
        while(!minHeap.isEmpty()) {
            Set<Character> set = new HashSet<>();
            Point cur = minHeap.poll();
            set.add(cur.tag);
            boolean isDup = false;
            while(!minHeap.isEmpty() && minHeap.peek().dist == cur.dist) {
                Point next = minHeap.poll();
                if(!set.add(next.tag))
                    isDup=true;
            }
            if(isDup) {
                break;
            }else {
                boolean isVisited = false;
                for(char c : set) {
                    if(!visited.add(c))
                        isVisited = true;
                }
                res += isVisited ? 0 : set.size();
                if(isVisited)
                    break;
            }
        }
        return res;
    }

    static class Point{
        int dist;
        char tag;

        public Point(char tag, int x, int y) {
            this.dist = x*x + y*y;
            this.tag = tag;
        }
    }
}
