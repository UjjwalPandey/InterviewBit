public class LongestIncreasingSubsequence {
    static int lis(int input1, int[] input2)
    {
        int lis[] = new int[input1];
        int i,j,max = 0;
        for ( i = 0; i < input1; i++ )
            lis[i] = 1;

        for ( i = 1; i < input1; i++ )
            for ( j = 0; j < i; j++ )
                if ( input2[i] > input2[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        for ( i = 0; i < input1; i++ ) {
            System.out.println(input2[i] + " : " + lis[i]);
            if (max < lis[i]) max = lis[i];
        }
        return max;
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( n, arr ) + "\n" );
    }
}
