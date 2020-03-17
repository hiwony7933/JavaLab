package Loop;

public class Loop_for {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i = i + 1) {
			if (i % 4 == 0) { // 4의 배수가 되면 반복문 중단 1, 2, 3 출력하고 중단됨
				break;
			}
			System.out.println("i:" + i);
		}

		System.out.println();

		for (int i = 1; i <= 10; i = i + 1) {
			if (i % 4 == 0) { // 4의 배수가 되면 다음 반복으로 이동 ( "~ 할때는 빼고 하자" 의 뜻 )
				continue;
			}
			System.out.println("i:" + i);
		}
	}
}
