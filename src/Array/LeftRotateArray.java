package Array;

import java.util.ArrayList;

public class LeftRotateArray {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(19);
        ip.add(4);
        ip.add(4);
        System.out.print(solve(ip));
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(A);
        for(int i =0; i< A.size(); i++){
            result.add(getPower(temp));
//            System.out.println(temp);
            int first = temp.get(0);
            temp.remove(0);
            temp.add(first);
        }

        return result;
    }

    private static int getPower(ArrayList<Integer> arr) {
        int res =0;
        int first =0, last = 1;
        while (last < arr.size()){
            if(arr.get(first) >= arr.get(last)) res++;
            first++;
            last++;
        }
        return res;
    }
}
