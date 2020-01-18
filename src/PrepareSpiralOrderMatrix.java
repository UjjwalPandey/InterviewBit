import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrepareSpiralOrderMatrix {
        public static void main(String[] args) {
            int A = 5;
//            ArrayList<ArrayList<Integer>> res = generateMatrix(A);
//            int[][] res = generateMatrix(A);
            System.out.println(generateMatrix(A));
        }

        public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
            if(A <= 0) return null;
            int m = A;
            int n = A;
            int T =0, B= m-1, L=0, R=n-1, dir=0, counter=1;
            int[][] res = new int[A][A];
//            System.out.println(res);


            while (T <= B && L <= R){
                if(dir==0){
                    for(int i=L; i<=R; i++){
//                        val.set(i,counter++);
                        res[T][i] = counter++;
                    }
                    T++; dir =1;
                }else if(dir==1){
                    for(int i=T; i<=B; i++){
//                        res.get(i).set(R,counter++);
                        res[i][R] = counter++;
                    }
//                    System.out.println(res);
                    R--; dir =2;
                }else if(dir==2){
//                    val = res.get(B);
                    for(int i=R; i>=L; i--){
//                        val.set(i,counter++);
                        res[B][i] = counter++;
                    }
//                    System.out.println(res);
//                    res.set(B,val);

                    B--; dir =3;
                }else if(dir==3){
                    for(int i=B; i>=T; i--){
//                        res.get(i).set(L,counter++);
                        res[i][L] = counter++;
                    }
//                    System.out.println(res);
                    L++; dir =0;
                }
            }
            ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<A; i++){
                ArrayList<Integer> zeroList = new ArrayList<>();
                for(int l=0; l<A; l++){
//                    System.out.print(res[i][l]+",");
                    zeroList.add(res[i][l]);
                }
//                System.out.println();
                al.add(zeroList);
            }

            return al;
//            return null;
        }

}

//            if(A <= 0) return null;
//            int m = A;
//            int n = A;
//            int T =0, B= m-1, L=0, R=n-1, dir=0, counter=1;
//            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//            ArrayList<Integer> zeroList = new ArrayList<>();
//            for(int k=0; k<A; k++){
//                zeroList.add(0);
//            }
//            ArrayList<Integer> zeroArrayList= new ArrayList<Integer>();
//            for(int k=0; k<A; k++){
//                res.add(zeroList);
//            }
//            System.out.println(res);
//
//            ArrayList<Integer> val = new ArrayList<Integer>();
//
//            while (T <= B && L <= R){
//                if(dir==0){
//                    val = res.get(T);
//                    System.out.println(val);
//                    for(int i=L; i<=R; i++){
//                        val.set(i,counter++);
////                        res.set(a.get(T).get(i));
//                    }
//                    System.out.println(val+"\n"+res);
//                    res.set(T,val);
//                    System.out.println(res);
//                    T++; dir =1;
//                }else if(dir==1){
//                    for(int i=T; i<=B; i++){
//
//                        res.get(i).set(R,counter++);
////                        res.add(a.get(i).get(R));
//                    }
//                    System.out.println(res);
//                    R--; dir =2;
//                }else if(dir==2){
//                    val = res.get(B);
//                    for(int i=R; i>=L; i--){
//                        val.set(i,counter++);
////                        res.add(a.get(B).get(i));
//                    }
//                    System.out.println(res);
//                    res.set(B,val);
//
//                    B--; dir =3;
//                }else if(dir==3){
//                    for(int i=B; i>=T; i--){
//                        res.get(i).set(L,counter++);
////                        res.add(a.get(i).get(L));
//                    }
//                    System.out.println(res);
//                    L++; dir =0;
//                }
//            }
//
//            return res;
//        }
//    }

