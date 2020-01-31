package I_String;

public class StringTest {

	public static void main(String[] args) {
		String str = "Hello";
		// String은 자신의 데이터를 수정할 수 없기 때무네 메소드를 호출하거나 + 연산을 하면 결과를 리턴합니다.
		// 원본에는 변화가 생기지 않습니다.
		String result = str + "java";
		str.toUpperCase();
		System.out.println(result);
	}

}
