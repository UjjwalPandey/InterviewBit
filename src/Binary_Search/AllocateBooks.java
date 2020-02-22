/* Given an array of integers A of size N and an integer B. College library has N books,the ith book has A[i] number of pages. You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
    A book will be allocated to exactly one student.
    Each student has to be allocated at least one book.
    Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
    Calculate and return that minimum possible number. NOTE: Return -1 if a valid assignment is not possible.


    Problem Constraints
    1 <= N <= 10^5
    1 <= A[i],B <= 10^5


    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.


    Output Format
    Return that minimum possible number


    Example Input
    A = [12, 34, 67, 90]
    B = 2


    Example Output
    113


    Example Explanation
    There are 2 number of students. Books can be distributed in following fashion :
            1) [12] and [34, 67, 90]
            Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
            2) [12, 34] and [67, 90]
            Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
            3) [12, 34, 67] and [90]
            Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
            Of the 3 cases, Option 3 has the minimum pages = 113.
 */

package Binary_Search;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(A,B));

        int[] C = {73, 58, 30, 72, 44, 78, 23, 9 };
        int D = 5;
        System.out.println(books(C,D));
        System.out.println(books(C,B));
        int[] G = { 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24 };
        int H = 26;
        System.out.println(books(G,H));
    }

    public static int books(int[] A, int B) {
        int N = A.length;
        if(B > N) return -1;
        int maxValue= Integer.MIN_VALUE, sum=0;
        for(int x: A){
            sum += x;
            maxValue = Math.max(x,maxValue);
        }
        int start=maxValue,end=sum,max=Integer.MIN_VALUE, mid=-1;
        while (end>=start) {
            mid=(start+end)/2;
//            System.out.println("Mid = "+mid+" Max = "+max+" Start =  "+start+" End = "+end);
            if (check(mid,A,B)==1) {
                max = Math.max(mid, max);
                start=mid+1;
            }else {
                end=mid;
            }
            if(start == mid && mid==end) break;
        }
        if(max == Integer.MIN_VALUE) return mid;
        return max;
    }

    public static int check(int num,int[] pages, int B) {
        int students=0, sum =0;
        for (int page : pages) {
            sum += page;
            if (sum >= num) {
                students++;
                sum = page;
                if (students == B) {
//                    System.out.println("Found for Mid = "+num+"  and B = "+B);
                    return 1;
                }
            }
        }
//        System.out.println("Returning with B = "+students);
        return 0;
    }
}
