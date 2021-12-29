package Gugudan;

import java.util.Scanner; // Scanner는 java.util이라는 패키지에 있는 클래스로써 키보드로부터 값을 입력받는다던지 할 때 사용할 수 있는 클래스

public class Gugudan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 키보드로부터 값을 입력받는 클래스 Scanner 객체 생성

        while(true) {
            System.out.println("구구단 중에 출력할 단은? : ");
            int num = sc.nextInt(); // Scanner 클래스를 이용하여 키보드로부터 숫자값을 입력받는다.
            if(num < 2 || num > 9) {
                System.out.println("2 이상, 9 이하의 값만 입력할 수 있습니다.");
                continue;
            }
            for(int i = 1; i <= 9; i++) {
                System.out.println(num + " X " + i + " = " + num*i);
            }
            break;
        }
    }
}
