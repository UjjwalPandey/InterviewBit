/*  Given an array of real numbers greater than zero in form of strings.
    Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or 0 for false.

    Example: Given [0.6, 0.7, 0.8, 1.2, 0.4] , You should return 1 as 0.6+0.7+0.4=1.7 1<1.7<2
    Hence, the output is 1.
    O(n) solution is expected.

    Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed

    https://stackoverflow.com/questions/19557505/triplet-whose-sum-in-range-1-2
 */

package Sorting;

public class TripletsWithSumBetweenGivenRange {
    public static void main(String[] args) {
        String[] str = {"0.6", "0.7", "0.8", "1.2", "0.4"};
        System.out.println(inRangeTriplet(str));
    }

    public static int inRangeTriplet(String[] A) {
        // X = (0,2/3), Y = [2/3,1], Z = (1,2)
        /*
            |X| >= 3 and Xmax(1) + Xmax(2) + Xmax(3) >= 1
            |X| >= 2, |Z| >= 1, and Xmin(1)+Xmin(2)+Zmin(1) <= 2
            |X| >= 1, |Y| >= 2, and Xmin(1)+Ymin(1)+Ymin(2) <= 2
            |X| >= 1, |Y| >= 1, |Z| >= 1, and Xmin(1)+Ymin(1)+Zmin(1) <= 2
            |X| >= 2, |Y| >= 1, and Xmax(1) + Xmax(2) + Ymin(1) < 2
            |X| >= 2, |Y| >= 1, and Xmin(1) + Xmin(2) + Ymax(1) > 1)
        */
        double Xmax1 = 0.0;
        double Xmax2 = 0.0;
        double Xmax3 = 0.0;
        double Xmin1 = 1.0;
        double Xmin2 = 1.0;
        double Ymin1 = 2.0;
        double Ymin2 = 2.0;
        double Ymax1 = 0.0;
        double Zmin1 = 2.0;
        int X = 0, Y = 0, Z = 0;
        for (String s : A) {
            double n = Double.parseDouble(s);
            if (n < (2.0 / 3.0)) {
                X++;
                if (n > Xmax3 && n < Xmax2 && n < Xmax1) {
                    Xmax3 = n;
                } else if (n > Xmax2 && n < Xmax1) {
                    Xmax3 = Xmax2;
                    Xmax2 = n;
                } else if (n > Xmax1) {
                    Xmax3 = Xmax2;
                    Xmax2 = Xmax1;
                    Xmax1 = n;
                }
                if (n < Xmin2 && n > Xmin1) {
                    Xmin2 = n;
                } else if (n < Xmin1) {
                    Xmin2 = Xmin1;
                    Xmin1 = n;
                }
            } else if (n <= 1) {
                Y++;
                if (n > Ymax1) {
                    Ymax1 = n;
                }
                if (n < Ymin2 && n > Ymin1) {
                    Ymin2 = n;
                } else if (n < Ymin1) {
                    Ymin2 = Ymin1;
                    Ymin1 = n;
                }
            } else if (n < 2) {
                Z++;
                if (n < Zmin1) {
                    Zmin1 = n;
                }
            }
        }
        if (X >= 3) {
            if (Xmax1 + Xmax2 + Xmax3 > 1) {
                return 1;
            }
        }
        if (X >= 2 && Z >= 1) {
            if (Xmin1 + Xmin2 + Zmin1 < 2) {
                return 1;
            }
        }
        if (X >=1 && Y >= 2) {
            if (Xmin1 + Ymin1 + Ymin2 < 2) {
                return 1;
            }
        }
        if (X >= 1 && Y >= 1 && Z >= 1) {
            if (Xmin1 + Ymin1 + Zmin1 < 2) {
                return 1;
            }
        }
        if (X >=2 && Y >= 1) {
            if (Xmax1 >= 0.5 && Xmax1 + Xmax2 + Ymin1 < 2) {
                return 1;
            }
            if (Xmin2 < 0.5 && Xmin1 + Xmin2 + Ymax1 > 1) {
                return 1;
            }
        }
        return 0;
    }
}