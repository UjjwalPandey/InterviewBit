/** Find if two rectangles overlap

 Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
 For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).
 Find and return whether the two rectangles overlap or not.
 Output Format:  Return 1 if the two rectangles overlap else return 0.

 Note: Simply check if the two rectangles are up/down or left/right of each other.
 *
 */
public class OverlappingRectangle {
    public static void main(String[] args) {
//        int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;
//        int A = 0,   B = 0,
//        C = 4,   D = 4,
//        E = 2 ,  F = 2,
//        G = 3 ,  H = 3;
        int A = 0, B = 0,C = 1,D = 1,E = 1,F = 1,G = 6,H = 6;
        System.out.println(isOverlap(A,B,C,D,E,F,G,H));
    }

    private static int isOverlap(int a, int b, int c, int d, int e, int f, int g, int h) {
        // one rectangle is to the top of the other
        if (d <= f || b >= h) {
            return 0;
        }
        // one rectangle is to the left of the other
        if (c <= e || a >= g) {
            return 0;
        }
        return 1;
    }
}
