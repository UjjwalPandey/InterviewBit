package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowManyPalindrome {
    public static void main(String[] args) {
        String s = "bxb";
        List<Integer> lower = new ArrayList<>();
//        lower.add(1);
        lower.add(2);
        lower.add(1);
        List<Integer> upper = new ArrayList<>();
//        upper.add(1);
        upper.add(3);
        upper.add(1);
        System.out.println(howManyPalindromes(s,lower,upper));
    }

    public  static List<Long> howManyPalindromes(String s, List<Integer> lower, List<Integer> upper){
        List<Long> result = new ArrayList<>();
        List<String> palindromes = allPalindromeSubstring(s);
//        System.out.println(palindromes);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<palindromes.size(); i++){
            int size = palindromes.get(i).length();
            int count = hm.getOrDefault(size, 0);
            hm.put(size,count+1);
        }
//        System.out.println(hm);

        int range = Math.min(lower.size(), upper.size());
        for(int i=0; i< range; i++){
            long counter =0;
//            System.out.println(lower+"    "+upper);
            for(int j= lower.get(i); j <= upper.get(i); j++){
//                System.out.println(j);
                counter += hm.getOrDefault(j,0);
            }
            result.add(counter);
        }
        return result;
    }

    public static List<String> allPalindromeSubstring(String s) {
        List<String> list = new ArrayList<String>();
        for (float pivot = 0; pivot < s.length(); pivot += .5) {
            float palindromeRadius = pivot - (int)pivot;

            while ((pivot + palindromeRadius) < s.length()
                    && (pivot - palindromeRadius) >= 0
                    && s.charAt((int)(pivot - palindromeRadius))
                    == s.charAt((int)(pivot + palindromeRadius))) {

                list.add(s.substring((int)(pivot - palindromeRadius),
                        (int)(pivot + palindromeRadius + 1)));
                palindromeRadius++;
            }
        }
        return list;
    }
}
