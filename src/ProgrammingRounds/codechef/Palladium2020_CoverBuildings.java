/*
// Received CODILITY GOLDEN AWARD:
// https://app.codility.com/cert/view/cert6DCRSG-94S4KDG537Z8A4NJ/



There are N rectangular buildings standing along the road next to each other. The K-th building is of size H[K] × 1.

Because a renovation of all of the buildings is planned, we want to cover them with rectangular banners until the renovations are finished. Of course, to cover a building, the banner has to be at least as high as the building. We can cover more than one building with a banner if it is wider than 1.

For example, to cover buildings of heights 3, 1, 4 we could use a banner of size 4×3 (i.e. of height 4 and width 3), marked here in blue:

Buildings of sizes (3 × 1), (1 × 1), (4 × 1), covered with scaffolding of size 4×3

We can order at most two banners and we want to cover all of the buildings. Also, we want to minimize the amount of material needed to produce the banners.

What is the minimum total area of at most two banners which cover all of the buildings?

Write a function:

    class Solution { public int solution(int[] H); }

that, given an array H consisting of N integers, returns the minimum total area of at most two banners that we will have to order.

Examples:

1. Given H = [3, 1, 4], the function should return 10. The result can be achieved by covering the first two buildings with a banner of size 3×2 and the third building with a banner of size 4×1:

Illustration of first example

2. Given H = [5, 3, 2, 4], the function should return 17. The result can be achieved by covering the first building with a banner of size 5×1 and the other buildings with a banner of size 4×3:

Illustration of second example

3. Given H = [5, 3, 5, 2, 1], your function should return 19. The result can be achieved by covering the first three buildings with a banner of size 5×3 and the other two with a banner of size 2×2:

Illustration of third example

4. Given H = [7, 7, 3, 7, 7], your function should return 35. The result can be achieved by using one banner of size 7×5:

Illustration of fourth example

5. Given H = [1, 1, 7, 6, 6, 6], your function should return 30. The result can be achieved by using banners of size 1×2 and 7×4:

Illustration of fifth example

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array H is an integer within the range [1..10,000].


 */

package ProgrammingRounds.codechef;

public class Palladium2020_CoverBuildings {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 4}));  // 10
        System.out.println(solution(new int[]{5, 3, 2, 4}));  // 17
        System.out.println(solution(new int[]{5, 3, 5, 2, 1})); // 19
        System.out.println(solution(new int[]{7, 7, 3, 7, 7}));  // 35
        System.out.println(solution(new int[]{1, 1, 7, 6, 6, 6})); // 30
        System.out.println(solution(new int[]{})); // 0
        System.out.println(solution(new int[]{3})); // 3
        System.out.println(solution(new int[]{-43})); // 0
        System.out.println(solution(new int[]{2,2,20,2})); // 44
        System.out.println(solution(new int[]{20,2,20,2})); // 62
    }

    public static int solution(int[] H) {
        // write your code in Java SE 8
        if(H.length == 0) return 0;
        int maxHeight = Integer.MIN_VALUE;
        int[] leftMax = new int[H.length+1];
        int[] rightMax = new int[H.length+1];
        for (int i = 0; i <= H.length; i++) {
            if(i < H.length) maxHeight = Math.max(maxHeight, H[i]);
            if (i == 0) {
                leftMax[i] = 0;
                if(H[i] <= 0) return 0;
            } else {
                if(H[i-1] <= 0) return 0;
                leftMax[i] = Math.max(leftMax[i - 1], H[i-1]);
            }
        }
        for (int i = H.length; i >= 0; i--) {
            if (i == H.length) {
                rightMax[i] = 0;
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], H[i]);
            }
        }
        int res = maxHeight * H.length;
        for (int i = 0; i <= H.length; i++) {
            int newVal = leftMax[i] * (i ) + rightMax[i] * (H.length - i );
            res = Math.min(res, newVal);
        }

        return res;
    }
}