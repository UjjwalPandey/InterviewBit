package Maths;

import java.util.ArrayList;

public class ScalerMarch_1 {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(1);
        ip.add(3);
        ip.add(2);
        ip.add(4);
        ip.add(5);
//        ip.add(6);
        int B = 5;
//        System.out.println(permuteDistance(ip, 6));
        System.out.println(permuteDistance(ip, 5));
        System.out.println(permuteDistance(ip, 4));
        System.out.println(permuteDistance(ip, 3));
        System.out.println(permuteDistance(ip, 2));
        System.out.println(permuteDistance(ip, 1));
    }

    // static ArrayList<ArrayList<Integer>> res;
//    static int result;
    static int n;
    static boolean[] marked;
    static ArrayList<Integer> A;

    public static int permuteDistance(ArrayList<Integer> N, int B) {
        if(B < 2) return 1;

        n = N.size();
        marked = new boolean[n];
        A = N;
        int result = 0;
        result = rec(0, new ArrayList<>(), N, B, result);
        return result;
    }

    public static int rec(int idx, ArrayList<Integer> temp, ArrayList<Integer> N, int B, int result){
        if(idx == n){
            int counter = 0;
            for(int j =0; j < temp.size(); j++){
                if(!temp.get(j).equals(N.get(j))) counter++;
            }
            if(counter <= B){
                result++;
            }
            return result;
        }

        for(int i=0; i< n; i++){
            if(!marked[i]){
                marked[i] = true;
                temp.add(A.get(i));
                result = rec(idx+1, temp, N, B, result);
                marked[i] = false;
                temp.remove(temp.size()-1);
            }
        }
        return result;
    }

}
