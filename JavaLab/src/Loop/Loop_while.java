package Loop;

public class Loop_while {

	public static void main(String[] args) {
		// while : 한번만 수행할 내용 -> while(조건) -> {} 내에서 반복수행할 내용
		int i = 0;
		while (i < 3) {
			System.out.println("Hello java");
			i = i + 1;
		}
		System.out.println();

		// do~while : 한번만 수행할 내용 -> do{반복 수행할 내용} -> while(조건);
		i = 0;
		do {
			System.out.println("hello java World");
			i = i + 1;
		} while (i < 3);
	}
}
