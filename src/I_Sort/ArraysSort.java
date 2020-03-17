package I_Sort;

import java.util.Arrays;

public class ArraysSort {

	public static void main(String[] args) {
		// int -> Integer 와 String은 크기 비교가 가능해서 바로 정렬 가능
		// Comparable 인터페이스가 구현되어 있는지 확인
		
		int[] ar = { 2, 4, 5, 6, 7, 8, 3, 1 };	// 정수 배열
		String[] br = { "L", "T", "E", "S", "K", "R", "H", "D" };	// 문자열 배열
		
		Arrays.sort(ar); 	// 배열 정렬
		for (int temp : ar) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n");

		Arrays.sort(br);	// 배열 정렬
		for (String temp : br) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n");

	}

}
