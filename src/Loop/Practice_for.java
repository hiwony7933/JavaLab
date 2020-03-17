package Loop;

public class Practice_for {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i = i + 1) {
			for (int j = 0; j < 5; j = j + 1) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------");

		
		for (int i = 0; i < 5; i = i + 1) {
			for (int j = 0; j < i + 1; j = j + 1) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------");

		
		for (int i = 0; i < 5; i = i + 1) {
			for (int j = 0; j < 2 * i + 1; j = j + 1) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("--------------");

		
		for (int i = 0; i < 5; i = i + 1) {
			if (i < 2) {
				for (int j = 0; j < i + 1; j = j + 1) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < 5 - i; j = j + 1) {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		System.out.println("--------------");
	}
}
