package I_Sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] ar = { 20, 30, 40, 50, 10, 32 };
		// 선택 정렬은 첫번째부터 마지막 바로 앞 데이터까지
		// 자신의 뒤에 있는 모든 위치의 데이터와 비교해서 정렬
		// 오름차순이면 뒤의 데이터가 작을때 swap
		// 내림차순이면 뒤의 데이터가 클 때 swap

		int len = ar.length;

		// 첫번째 부터 마지막 바로 앞 자리까지
		for (int i = 0; i < len - 1; i = i + 1) {
			// 기준의 뒤에 있는 모든 데이터
			for (int j = i + 1; j < len; j = j + 1) {
				if (ar[i] > ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		for (int temp : ar) {
			System.out.println(temp);
		}
	}

}
