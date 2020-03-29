package Maths;

import java.util.ArrayList;

public class ScalerMarch_1 {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(1);
        ip.add(2);
        ip.add(3);
//        ip.add(4);
        int B = 2;
        System.out.print(permuteDistance(ip, B));
    }

    private static int permuteDistance(ArrayList<Integer> N, int B) {
        int result =0;
        ArrayList<ArrayList<Integer>> res = permute(N);
        for(int i=0; i < res.size(); i++){
            int counter = 0;
            for(int j=0; j < res.get(0).size(); j++){
                if(!res.get(i).get(j).equals(N.get(j))) counter++;
            }
            if(counter <= B){
                result++;
//                System.out.println(res.get(i) +"  "+counter);
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size() == 1){
            res.add(A);
            return res;
        }

        for(int i=0; i< A.size(); i++){
            int num = A.get(i);
            ArrayList<Integer> remaining = new ArrayList<>();
            if(i == 0){
                remaining.addAll(A.subList(i+1,A.size()));
            }else if(i== A.size()-1){
                remaining.addAll(A.subList(0,i));
            }else{
                remaining.addAll(A.subList(0,i));
                remaining.addAll(A.subList(i+1, A.size()));
            }
            ArrayList<ArrayList<Integer>> perm = permute(remaining);
            for (ArrayList<Integer> integers : perm) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(num);
                temp.addAll(integers);
                res.add(temp);
            }
        }
        return res;
    }

}
