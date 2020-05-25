//https://www.hackerrank.com/certificates/39a1e3d6cb9d

package ProgrammingRounds.hackerrank;

import java.util.*;

public class UnexpectedDemand {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(30);
        System.out.println(filledOrders(l, 40));  // 2
    }

    public static int filledOrders(List<Integer> order, int k) {
        int max = 0;
        Set<Integer> set = new HashSet<>(order);
        Collections.sort(order);
        int counter =0;
        while (k > 0 && counter < order.size()){
            if(k < order.get(counter)){
                return max;
            }else {
                k -= order.get(counter++);
                max = Math.max(max, counter);
            }
        }
        return max;
    }
}
