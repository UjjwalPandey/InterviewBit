package Strings;

public class Length_of_Last_Word {
    public static void main(String[] args) {
        String s = "Hello World";
        String t = "Ujjwal";
        String u = "Ujjwal Pandey is Great";
        String v = "     ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord_No_Library_Function(s));
        System.out.println(lengthOfLastWord(t));
        System.out.println(lengthOfLastWord_No_Library_Function(t));
        System.out.println(lengthOfLastWord(u));
        System.out.println(lengthOfLastWord_No_Library_Function(u));
        System.out.println(lengthOfLastWord(v));
        System.out.println(lengthOfLastWord_No_Library_Function(v));
    }

    // SOLUTION 1
    public static int lengthOfLastWord(final String A) {
        if(A.isEmpty()) return 0;
        String[] s = A.split(" ");
        if(s.length == 0) return 0;
        return s[s.length-1].length();
    }

    // SOLUTION 2: Without any library function;
    public static int lengthOfLastWord_No_Library_Function(final String A) {
        if(A.isEmpty()) return 0;
        String str= A.trim();
        int lastSpace =0;
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)== ' ')
                lastSpace = i;
        }
        if(lastSpace==0) return str.length();
        return str.length()-lastSpace-1 ;
    }
}
