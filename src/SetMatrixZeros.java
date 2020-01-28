import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.HashSet;

public class SetMatrixZeros {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>() {
            {
                add(1);
                add(0);
                add(1);
            }
        };
        ArrayList<Integer> b = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
                add(1);
            }
        };
        ArrayList<Integer> c = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
                add(1);
            }
        };
        //{{ 1, 2, 3 },{4, 5, 6 },{ 7, 8, 9 }};
        A.add(a);
        A.add(b);
        A.add(c);
        printMatrix(A);
        ArrayList<ArrayList<Integer>> res = setZeroes(A);
        System.out.println("\n");
        printMatrix(res);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        for(int i=0; i<m; i++){
            for (int j=0; j< n; j++){
                System.out.print(a.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        HashSet<Integer> verticalZeroes = new HashSet<>();
        HashSet<Integer> horizontalZeroes = new HashSet<Integer>();
        for(int i=0; i<m; i++){
            for (int j=0; j< n; j++){
                if(a.get(i).get(j)==0){
                    horizontalZeroes.add(i);
                    verticalZeroes.add(j);
                }
            }
        }
//        System.out.println("Vertical Zero set: "+verticalZeroes.toString());
//        System.out.println("Horizontal Zero set: "+horizontalZeroes.toString());

        ArrayList<ArrayList<Integer>> opMatrix = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<m; i++){
            if(horizontalZeroes.contains(i)){
                ArrayList<Integer> fillHorizontalZeroes = new ArrayList<Integer>();
                for (int j=0; j< n; j++){
                    fillHorizontalZeroes.add(0);
                }
                opMatrix.add(i,fillHorizontalZeroes);
            }else{
                ArrayList<Integer> fillVerticalZeroes = new ArrayList<Integer>();
                for (int j=0; j< n; j++){
                    if(verticalZeroes.contains(j)){
                        fillVerticalZeroes.add(j,0);
                    }else {
                        fillVerticalZeroes.add(j,1);
                    }
                }
                opMatrix.add(i,fillVerticalZeroes);
            }
        }
//        for(int i=0; i<m; i++){
//                a.set(i,opMatrix.get(i));
//        }

        return opMatrix;
    }
}
