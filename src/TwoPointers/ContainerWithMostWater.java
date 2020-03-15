/*  CONTAINER WITH MOST WATER

    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
    'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Your program should return an integer which corresponds to the maximum area of water that can be contained

    ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

    Note: You may not slant the container.

 */
package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] A = {1, 5, 4, 3};
        System.out.println(maxArea(A));
    }
    public static int maxArea(int[] A) {
        int max = 0;
        int l = 0, r = A.length-1;
        while (l < r){
            max = Math.max(max, Math.min(A[l],A[r])*(r-l));
            if(A[l] < A[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
