package Bit_Manipulation;

public class Number_of_1_Bits {
    public static void main(String[] args) {
        int N = 20;
        System.out.println(numSetBits(N));
    }
    public static int numSetBits(long a) {
        int res =0;
        while (a > 0)
        {
            if(a % 2 == 1) res++;
            a = a / 2;
        }
        return res;
    }
}
