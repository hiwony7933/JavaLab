package Data_Structure_Array;

import java.util.Scanner;

public class Array_sum {

	public static void main(String[] args) {
		int[] ar = { 40, 37, 51, 65, 29 };

		// 합계를 구할 때 합을 저장할 변수를 규칙이 성립되기 저 또는 합을 구하기 전까지의 값으로 초기화
		int sum = 0;
		for (int data : ar) {
			sum = sum + data;
		}
		System.out.print("합계:" + sum + "\n");
		System.out.println();
		
		// 조건에 맞는 데이터 개수
		int cnt = 0;
		for (int data : ar) {
			if (data > 50) {
				cnt = cnt + 1;
			}
		}
		System.out.print("50이 넘는 데이터 개수 :" + cnt + "\n");
		System.out.println();
		
		
		int cnt1 = 0;
		int sum1 = 0;
		for (int data : ar) {
			if (data > 30) {
				cnt1 = cnt1 + 1;
				sum1 = sum1 + data;
			}
		}
		if (cnt1 == 0) {
			System.out.print("조건을 만족하는 데이터없음");

		} else {
			double avg = (double) sum1 / cnt1; // 평균
			System.out.print("avg :" + avg + "\n");
			int result = (int) (avg + 0.5); // 반올림
			System.out.print("평균 :" + result + "\n");
		}
		System.out.println();

		
		// 최대값, 최소값
		int max = ar[0];
		for (int data : ar) {
			if (max > data) {	// 가운데 부호만 바꿔주면 됨 "<,>"
				max = data;
			}
		}
		System.out.print("최소값:" + max);
	}

}
