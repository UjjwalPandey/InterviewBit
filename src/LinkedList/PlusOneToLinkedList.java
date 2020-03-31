package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOneToLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        List<Integer> values = Arrays.asList(  9, 9, 9, 9, 9 );
        ip.addAll(values);
        System.out.println(plusOne(ip));
    }
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        System.out.println("A = "+A);
        ArrayList<Integer> res = new ArrayList<Integer>();
        Collections.reverse(A);
        int carry = 0;
        int i;
        int N = A.size();
        for(i=0; i < N; i++){
            int sum;
            int val = A.get(i);
            if(i==0){
                sum = val+1;
            }else{
                sum = val+carry;

            }
            System.out.println("i= "+i+" sum= "+sum+" val = "+val);
            res.add(sum%10);
            carry = sum/10;
        }
        System.out.println("Res = "+res);
        if(carry !=0){
            res.add(carry);
        }
        Collections.reverse(res);
        while (res.get(0)==0){
            res.remove(0);
        }
        return res;
    }
}
