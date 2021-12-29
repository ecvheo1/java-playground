package Gugudan;

public class Gugudan {
    public static int[] calculate(int num) {
        int[] a = new int[9];

        for(int i = 1; i <= 9; i++) {
            a[i-1] = num * i;
        }

        return a;
    }
}



