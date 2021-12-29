package Gugudan;

import java.util.Scanner;

public class GugudanFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        String[] inputValue = value.split(",");
        int first = Integer.parseInt(inputValue[0]); // Integer 클래스의 parseInt 함수는 String타입의 숫자를 int타입으로 변환해줌
        int second = Integer.parseInt(inputValue[1]);

        for(int i = 2; i <= first; i++) {
            for(int j = 1; j <= second; j++) {
                System.out.println(i + " X " + j + " = " + i*j);
            }
        }
    }
}
