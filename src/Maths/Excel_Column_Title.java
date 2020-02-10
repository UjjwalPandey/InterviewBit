package Maths;

public class Excel_Column_Title {
    public static void main(String[] args) {
        int N = 653454;
        System.out.println(convertToTitle(N));
    }
    public static String convertToTitle(int A) {
        if(A < 1) return "";
        String str = "";
        while(A/26 != 0){
            int x = (int)A%26+64;
            A = A/26;
            if(x==64){
                x = 64+26;
                A--;
            }
            str += Character.toString((char)x);
            // System.out.println("Inner A: "+A+" Val x= "+x);
        }
        if(A !=0){
            int x = (int)A%26+64;
            // if(x==64){
            //         x = 64+26;
            //         A--;
            //     }
            // System.out.println("Outer A: "+(A%26)+"  Val x = "+x);
            str += Character.toString((char)x);
        }
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--){
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }
}
