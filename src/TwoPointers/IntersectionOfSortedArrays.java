/*

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]

    NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays
    should be included multiple times in the final output.



 */
package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(3);
        B.add(5);
        System.out.println(intersect(A,B));

        int[] C = { 1, 5, 7, 8, 9, 10, 10, 14, 16, 16, 17, 19, 20, 20, 20, 20, 21, 23, 26, 27, 29, 30, 30, 30, 31, 32, 33, 33, 34, 35, 35, 36, 37, 39, 39, 41, 42, 43, 43, 44, 44, 45, 46, 46, 47, 49, 51, 52, 53, 55, 55, 56, 57, 58, 59, 60, 65, 66, 66, 68, 68, 69, 69, 70, 70, 70, 71, 73, 75, 75, 75, 79, 80, 80, 81, 82, 85, 87, 91, 92, 98, 98, 98, 99, 100, 101 };
        int[] D = { 4, 7, 10, 10, 15, 17, 19, 20, 24, 27, 27, 30, 31, 35, 40, 41, 42, 46, 48, 49, 50, 51, 54, 57, 62, 62, 63, 66, 67, 68, 69, 70, 71, 73, 74, 78, 80, 81, 92, 94, 99, 101 };

        System.out.println(Arrays.toString(intersectArr(C,D)));

        int[] E = { 1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101 };
        int[] F = { 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98 };

        System.out.println(Arrays.toString(intersectArr(E, F))); // 35 38 53 67 69 94 98
    }

    public static int[] intersectArr(int[] A, int[] B) {
        int p2= 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< A.length && p2 < B.length; i++){
//            System.out.println(A[i]+"   "+B[p2]);
            if(A[i] == B[p2]){
                result.add(A[i]);
                if(++p2 == B.length) break;
            }else if(B[p2] < A[i]){
                while(B[p2] < A[i]) {
                    p2++;
                    if (p2 >= B.length) break;
                }
                if(p2 >= B.length) break;
                if(B[p2] == A[i]){
                    result.add(A[i]);
                    p2++;
                }
                if(p2 >= B.length) break;
            }
        }
        int[] res = new int[result.size()];
        for(int i=0; i< result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int p2= 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< A.size(); i++){
            if(A.get(i).equals(B.get(p2))){
                result.add(A.get(i));
                if(++p2 == B.size()) break;
            }else if(B.get(p2) < A.get(i)){
                p2++;
            }
        }
        return result;
    }
}
