package ProgrammingRounds.freelance_topt;

public class StringDivide {
    public static void main(String[] args) {
        System.out.println(solution("babaa"));  // 2
        System.out.println(solution("ababa"));  // 4
        System.out.println(solution("aba"));  // 0
        System.out.println(solution("bbbbb"));  // 6
        System.out.println(solution("bbbb"));  // 6
    }

    public static int solution(String S) {
        if(S.length() < 3) return 0;
        if((S.matches(".*[^a-b].*"))){
            return 0;
        }
        if(!S.contains("a")) return arithmeticProgression(S.length()-2);
        int res =0;
        int len = S.length();
        int[] tillOnes = new int[len];
        tillOnes[0] = (S.charAt(0) == 'a')?1:0;
        for(int i=1; i< len; i++){
            tillOnes[i] = tillOnes[i-1] + ((S.charAt(i) == 'a')?1:0);
        }
//        System.out.println(Arrays.toString(tillOnes));
        int x =0, y = 1;
        while(y < len){
            int part1 = tillOnes[x];
            int part2 = (tillOnes[y]-tillOnes[x]);
            int part3 = (tillOnes[len-1]-tillOnes[y]);
//            System.out.println(res+"   "+x+"   "+y);
            if(part1 == part2 && part2 == part3){
                res++;
//                if(x < y){
//                    x++;
//                    y = x+1;
//                }else {
//                    y++;
//                }
                if(y < len-1){
                   if(tillOnes[y] == tillOnes[y+1]){
                       y++;
                   }else{
                       x++;
                       y = x+1;
                   }
                }else{
                    x++;
                    y = x+1;
                }
            }else if(tillOnes[x] < tillOnes[y]){
                x++;
                y++;
            }else if(tillOnes[x] == tillOnes[y]){
                y++;
            }
        }
        return res;
    }

    private static int arithmeticProgression(int N) {
//        System.out.println("AP called");
        return ((N+1)*N)/2;
    }
}
