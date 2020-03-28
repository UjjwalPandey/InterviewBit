package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdobeCodeDiva1 {
    public static void main(String[] args) throws IOException {
//        int[][] ip1 = {
//                {1,0,1,1,1,1,0},
//                {0,1,1,0,1,0,1},
//                {1,0,0,0,0,0,1}};
//        System.out.println(getConnections(ip1));
//        int[][] ip2 = {
//                {0,0,0},
//                {0,0,0},
//                {1,1,1},
//                {0,0,0},
//                {0,0,0}};
//        System.out.println(getConnections(ip2));
//        int[][] ip3 = {
//                {1,1,0,1},
//                {0,1,1,0},
//                {0,0,0,0},
//                {0,1,0,0}};
        String line;
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        line = inp.readLine();
        int n  = Integer.parseInt(line.trim().split("\\s+")[0]);
        line = inp.readLine();
        int m  = Integer.parseInt(line.trim().split("\\s+")[0]);
        int[][] ip = new int[n][m];
        for(int i=0; i< n; i++){
            line = inp.readLine();
            String[] strs = line.trim().split("\\s+");
            for(int j =0; j< m; j++){
                ip[i][j] = Integer.parseInt(strs[j]);
            }
        }
        System.out.println(getConnections(ip));
    }

    private static int getConnections(int[][] ip) {
        int res = 0;
        int M = ip.length;
        if(M < 2) return 0;
        int N = ip[0].length;
        int[] nCount = new int[M];
        for(int i=0; i< M; i++){
            int counter = 0;
            for(int j =0; j < N; j++){
                if(ip[i][j] == 1) counter++;
            }
            nCount[i] = counter;
        }

        for(int x: nCount){
            System.out.print(x+" ");
        }
        System.out.println();

        int first = 0, next = 1;
        while(next < M){
            System.out.println(first+"  "+next+"  "+res);
            if(nCount[next] != 0){
                res += nCount[first]*nCount[next];
                first++;
            }
            next++;
        }
        return res;
    }
}
