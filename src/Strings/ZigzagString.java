/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P.......A........H.......N
        ..A..P....L....S....I...I....G
        ....Y.........I........R
        And then read line by line: PAHNAPLSIIGYIR
        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string text, int nRows);
        convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
        **Example 2 : **
        ABCD, 2 can be written as

        A....C
        ...B....D
        and hence the answer would be ACBD.
 */

package Strings;

public class ZigzagString {
    public static void main(String[] args) {
        String str = "UJJWALPAND";
        int N = 3;
        System.out.println(convert(str,N));
    }
    public static String convert(String A, int B) {
        A = A.trim();
        if(A.contains(" ") || A.length() < 2) return A.split(" ")[0];
        if(B==1) return A;
        String[][] temp = new String[B][2*A.length()];
        int i=0;
        boolean ascendingFlag = true;
        int column =0, row =-1;
        while(i < A.length()){
            if(row == B-1){
                ascendingFlag = false;
                column++;
            }else if(row <= 0){
                ascendingFlag = true;
                column++;
            }
            if(ascendingFlag){
                row++;
            }else{
                row--;
            }
            System.out.println("Row = "+row);
            temp[row][column] = (String.valueOf(A.charAt(i)));
            i++;
        }
        StringBuilder res = new StringBuilder();

        for (String[] strings : temp) {
            for (int k = 0; k < temp[0].length; k++) {
                String s = strings[k];
                if (s != null) {
                    System.out.print(s+" ");
                    res.append(s);
                }
            }
            System.out.println();
        }

        return res.toString();
    }
}
