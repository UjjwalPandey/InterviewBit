package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> b = new ArrayList<Integer>() {
            {
                add(4);
                add(5);
                add(6);
            }
        };
        ArrayList<Integer> c = new ArrayList<Integer>() {
            {
                add(7);
                add(8);
                add(9);
            }
        };
        //{{ 1, 2, 3 },{4, 5, 6 },{ 7, 8, 9 }};
        A.add(a);
        A.add(b);
        A.add(c);
        ArrayList<Integer> res = spiralMatrix(A);
        System.out.println(res);
    }

    private static ArrayList<Integer> spiralMatrix(List<ArrayList<Integer>> a) {
        if(a.isEmpty()) return  null;
        int m = a.size();
        int n = a.get(0).size();
        int T =0, B= m-1, L=0, R=n-1, dir=0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (T <= B && L <= R){
            if(dir==0){
                for(int i=L; i<=R; i++){
                    res.add(a.get(T).get(i));
                }
                T++; dir =1;
            }else if(dir==1){
                for(int i=T; i<=B; i++){
                    res.add(a.get(i).get(R));
                }
                R--; dir =2;
            }else if(dir==2){
                for(int i=R; i>=L; i--){
                    res.add(a.get(B).get(i));
                }
                B--; dir =3;
            }else if(dir==3){
                for(int i=B; i>=T; i--){
                    res.add(a.get(i).get(L));
                }
                L++; dir =0;
            }
        }

        return res;
    }
}


/** Reversing Even row
 ArrayList<Integer> x = a.get(i);
 if(i%2 != 0){
 Collections.reverse(x);  // reverse the arraylist
 }
 res.add(x);
 **/