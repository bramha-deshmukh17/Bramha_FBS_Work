package Assignment_3;

public class question_5 {
    /*
     * Q5 Check the given number is Armstrong number or not..
     * Input: n = 153
     * Output: Armstrong
     */
    public static void main(String args[]) {

        int n = 153, r, sum = 0, copy, power = 0, res = 1;


        copy = n;

        int dummy = n;
        while (dummy != 0) {
            dummy /= 10;
            ++power;
        }
        while (n > 0) {
            r = n % 10;
            res = 1;

            for (int i = 1; i <= power; i++)
                res *= r;

            sum += (res);

            n /= 10;
        }

        System.out.println(copy == sum ? "Armstrong" : "Not Armstrong");

    }
}
