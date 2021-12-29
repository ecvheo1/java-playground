package Gugudan;

import java.util.Arrays;

public class Gugudan3 {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                arr[j-1] = i*j;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
