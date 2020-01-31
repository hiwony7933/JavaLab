package Practice;

public class Fibo {

	public static void main(String[] args) {
		int n = 32;
		int[] fibo = new int[33];

		int result = -1;
		int f1 = 1;
		int f2 = 1;
		for (int i = 2; i <= n; i = i + 1) {
			result = f1 + f2;
			f2 = f1;
			f1 = result;
			if (result % 2 == 0) {
				fibo[i] = result;
				System.out.println(fibo[i]);
			} else {
				fibo[i] = 0;
			}
		}
		System.out.println("--------------");
		
		int sum = 0;
		for (int temp : fibo) {		// fibo 에 있는 배열의 합을 구함.
			sum = sum + temp;
		}
		System.out.println(sum);
	}
}
