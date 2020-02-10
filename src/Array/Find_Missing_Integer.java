/** Given an unsorted integer array, find the first missing integer.

 Example:

 Given [1,2,0] return 3,

 [3,4,-1,1] return 2,

 [-8, -7, -6] returns 1

 Your algorithm should run in O(n) time and use constant space.
 *
 */
package Array;

public class Find_Missing_Integer {
    public static void main(String[] args) {
//        int[] A = {3,4,-1,1};
//        int[] A = {3,4,-1,1};
        int[] A = {3,4,2,-1,1};
//        int[] A = {-8, -7, -6};
        System.out.println(missingInt(A));
    }

    private static int missingInt(int[] a) {
        int len = a.length;
        int result, negSum = 0, posSum = 0, posCount = 0, negCount= 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            if(a[i] < 0){
                negCount++;
                negSum+=a[i];
            }else{
                posCount++;
                posSum+=a[i];
            }
            max = (max > a[i])?max:a[i];
            min = (min < a[i])?min:a[i];
        }
        result = max+1;
        if(max*min >= 0){
            if(max > 0 || min > 0){
                return posSumFunction(posCount, posSum, max);
            }else if(max < 0 || min < 0){
                return 1;
            }
        }else{
            int posVal = posSumFunction(posCount, posSum, max);
            int negVal = negSumFunction(negCount, negSum, min);
            if(max+1 == posVal && (min -1 == negVal)){
                return max+1;
            }else if(min -1 == negVal){
                return (max*(max+1)/2) - posSum;
            }else{
                return  (min*(min-1)/2) - negSum;
            }
        }
        return result;
    }

    static int negSumFunction(int negCount, int negSum, int min){
        int negCountSum = negCount*(negCount+1)/2;
        if(negCountSum== negSum){
//            System.out.println("negSumFunction 1= "+(min-1));
            return min -1;
        }else{
//            System.out.println("negSumFunction 2 = "+((min*(min-1)/2) - negSum)*(-1));
            return  ((min*(min-1)/2) - negSum)*(-1);
        }
    }
    static int posSumFunction(int posCount, int posSum, int max){
        int posCountSum = posCount*(posCount+1)/2;
        if(posCountSum== posSum){
//            System.out.println("posSumFunction 1 = "+(max+1));
            return max+1;
        }else{
//            System.out.println("posSumFunction 1 = "+((max*(max+1)/2) - posSum));
            return  (max*(max+1)/2) - posSum;
        }
    }


}
