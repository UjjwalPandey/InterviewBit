package Maths;

import java.util.ArrayList;
import java.util.Collections;

public class PowerOf3 {
    public static void main(String[] args) {
        int A = 100431;
        int[] result = solve(A);
        for(int x: result) System.out.print(x+"  ");
    }

    public static int[] solve(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A < 3) return new int[]{-1};
        while(A > 0){
            int log = (int)Math.pow(3,(int)(Math.log(A)/Math.log(3)));
            A -= log;
            System.out.println(A+" "+log);
            res.add(log);
//            if(A==1){
//                res.add(1);
//                A --;
//                break;
//            }
        }
        System.out.println("***");
//        if(A%3 != 0)return new int[]{-1};

        Collections.sort(res);
        int[] result = new int[res.size()];
        for(int i=0; i< result.length; i++){
            result[i]= res.get(i);
        }
        return result;
    }
}
