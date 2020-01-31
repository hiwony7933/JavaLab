package Data_Type;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("소수 판별할 정수 입력:");
		int su = sc.nextInt();

		boolean flag = false;
		for (int i = 2; i <= su / 2; i = i + 1) {
			if (su % i == 0) {	// 조건을 만족한 경우 플래그 변수의 값을 변경
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(su + "는 소수 ");
		} else {
			System.out.println(su + "는 소수가 아님");
		}
		sc.close();
	}
}
