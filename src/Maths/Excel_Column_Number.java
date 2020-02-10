/** Given a column title as appears in an Excel sheet, return its corresponding column number.


 Problem Constraints
 1 <= length of the column title <= 1000


 Input Format
 Input a string which represents the column title in excel sheet.


 Output Format
 Return a single integer which represents the corresponding column number.


 Example Input
 Input 1: AB Input 2:
 ABCD



 Example Output
 Output 1:
 28
 Output 2:
 18289
 *
 */
package Maths;

public class Excel_Column_Number {
    public static void main(String[] args) {
        String str1 = "A";
        String str2 = "Z";
        String str3 = "AA";
        String str4 = "AZ";
        String str5 = "AAA";
        String str6 = "ABCD";
        String str7 = "ZZZZ";
        System.out.println(titleToNumber(str1));
        System.out.println(titleToNumber(str2));
        System.out.println(titleToNumber(str3));
        System.out.println(titleToNumber(str4));
        System.out.println(titleToNumber(str5));
        System.out.println(titleToNumber(str6));
        System.out.println(titleToNumber(str7));
    }
    public static int titleToNumber(String str) {
        String[] strSplit = str.trim().split("");
        int[] intVal = new int[strSplit.length];
        for(int i=0; i<strSplit.length; i++){
            intVal[i] = strSplit[i].charAt(0) - 'A'+1;
//            System.out.print(strSplit[i]+" ");
//            System.out.print(intVal[i]+" ");
        }
//        System.out.println();
//        System.out.println();

        int sum = 0;
        for(int i =0; i< intVal.length;i++){
            sum += Math.pow(26,intVal.length-1-i)*intVal[i];
        }
        return sum;
    }
}
