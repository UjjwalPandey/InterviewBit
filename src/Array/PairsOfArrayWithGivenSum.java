package Array;

public class PairsOfArrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = {5,17,100,11};
        int B = 28;
        System.out.println(solve(A,B));
    }
    public static int solve(int[] A, int B) {
        int len = A.length;
        int[] hash = new int[B];
        int res =0;
        for (int i=0; i< len; i++){
            int remainder = A[i] %B;
            if(remainder !=0){
                res += hash[B-remainder];
            }else{
                res += hash[0];
            }
            hash[remainder]++;
        }
        return res;
    }
}
