/*
=========================================================================================================================
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function.
Note that, if no pair exists, return empty list.
If multiple solutions exist, output the one where index2 is minimum.
If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
Input: [1, 3, 5, 7], target=12
Output: [3,4]
=========================================================================================================================
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {
    private static ArrayList<Integer> Sum(ArrayList<Integer> arr, int targetValue){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int inputSize = arr.size();
        for(int i=0; i< inputSize; i++){
            int num2 = arr.get(i);
            int num1 = targetValue - num2;
            if(hm.containsKey(num1)){
                res.add(hm.get(num1)); //index of num1
                res.add(i+1); //index of num2
                break;
            }
            //insert in hm
            if(!hm.containsKey(num2))
                hm.put(num2,i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> a = new ArrayList<Integer>(n);
        for(int i =0; i< n; i++){
            a.add(i*2+1);
        }
        System.out.println(a.toString());
        System.out.println(Sum(a,12).toString());
    }
}
