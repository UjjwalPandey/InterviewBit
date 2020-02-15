/*
    Given an array of integers A of size N and an integer B.
    array A is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
    You are given a target value B to search. If found in the array, return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
    NOTE:- Array A was sorted in non-decreasing order before rotation.

    NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

    Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

    Output Format
        Return index of B in array A, otherwise return -1

    Constraints
        1 <= N <= 1000000
        1 <= A[i] <= 10^9
        all elements in A are disitinct.
    For Example
    Input 1:
        A = [4, 5, 6, 7, 0, 1, 2, 3]
        B = 4
    Output 1:
        0
    Explanation 1:
     Target 4 is found at index 0 in A.

    Input 2:
        A = [5, 17, 100, 3]
        B = 6
    Output 2:
        -1

 */

package Binary_Search;

public class Rotated_Sorted_Array_Search {
    public static void main(String[] args) {
        int[] A = {1, 7, 67, 133, 178};
        int B = 1;
        int[] C = {5, 17, 100, 3};
        int D = 6;
        int[] E = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177 };
        int F = 42;
        int[] G = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int H = 202;
        int[] I = {43, 56, 57, 67, 67, 67, 133, 178, 1, 1, 7};
        int J = 133;
        System.out.println(search(A,B));
        System.out.println(search(C,D));
        System.out.println(search(E,F));
        System.out.println(search(G, H));
        System.out.println(search(I, J));
    }
    public static int search(final int[] A, int B) {
        int len = A.length-1;
        int rotatedAt = rotatedAt(A, 0, len);
        System.out.println("rotated At ="+rotatedAt+" A[i] = "+A[rotatedAt]);
        if(rotatedAt <= 0) return binarySearch(A, B, 0, len);
        int res1 = binarySearch(A, B, 0, rotatedAt-1);
        int res2 = binarySearch(A, B, rotatedAt, len);
        if(res1 != -1) return res1;
        if(res2 != -1) return res2;
        return -1;
    }

    private static int rotatedAt(int[] A, int l, int r) {
        if(A[l] < A[r]) return l;
        int mid = l + (r - l) / 2;
        if (A[mid] > A[r])
            return rotatedAt(A, mid + 1, r);
        return rotatedAt(A,l,mid - 1);
    }

    public static int binarySearch(final int[] A, int B, int first, int last) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (A[mid] == B)
                return mid;
            if (A[mid] > B)
                return binarySearch(A, B, first, mid - 1);
            return binarySearch(A, B,mid + 1, last);
        }
        return -1;
    }

}
