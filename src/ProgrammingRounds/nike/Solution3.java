package ProgrammingRounds.nike;

import java.util.ArrayList;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(shuffle());
        System.out.println(shuffle());
        System.out.println(shuffle());
        System.out.println(shuffle());
        System.out.println(shuffle());
        System.out.println(shuffle());
    }

    private static ArrayList<Integer> shuffle() {
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i=0; i < 52; i++){
            positions.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int min = 1;
        int count = 0;

        while(!positions.isEmpty()){
            double remainingLength = positions.size()-1;
            int placementPosition =  (int)(Math.random() * remainingLength) ;
            count++;
//            System.out.println(placementPosition+"   "+count);
            if(positions.isEmpty()) break;
            int placeChosen = positions.remove(placementPosition);
            result.add(placeChosen);
        }
        return result;
    }
}
