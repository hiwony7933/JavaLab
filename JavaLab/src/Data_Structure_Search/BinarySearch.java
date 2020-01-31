package Data_Structure_Search;

import java.util.Arrays;

public class BinarySearch { // 이분검색

	public static void main(String[] args) {
		int[] ar = { 100, 300, 200, 500, 400 };

		// 이분검색은 정렬이 된 상태에서 수행해야 정확한 결과가 나옴니다.
		System.out.println(Arrays.binarySearch(ar, 300)); // 이분검색 fail
		System.out.println();
		
		Arrays.sort(ar);	// 배열 정열 
		for (int temp : ar) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n");
		System.out.println(Arrays.binarySearch(ar, 300));
	}
}
