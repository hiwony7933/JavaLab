package Data_Structure_Stack_Queue;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		// LIFO (Lst In First Out), - 마지막에 삽입된 데이터가 가장 먼저 출력되는 자료구조 클래스 
		// 데이터를 삽입하는 동작을 push라고 하고 마지막 데이터를 꺼내는 동작을 pop 이라고 합니다. 
		// 실제 사용된 곳은 메소드를 호출할 때 메소드가 저장하는 자신의 데이터 영역을 Stack으로 만들고 스마트폰 등에서 화면 저장도 Stack을 사용합니다. 
		// 삽입은 E push(E e), 삭제는 E Pop(), 삭제하지 않고 마지막 데이터를 가져오는 E peek() 
		// 제너릭이 적용되어 있어서 인스턴스를 만들 때 저장할 요소의 자료형을 설정

		// Stack의 size를 설정한 경우에 Stack에 이미 데이터가 전부 저장된 상태에서 데이터를 push하는 경우를 Stack Overflow 라고 합니다. 
		// Stack에서 데이터가 없는 상태에서 pop을 하는 경우를 Stack Underflow 라고 합니다. 

		// 문자열 저장하는 스택 생성
		Stack<String> stack = new Stack<>();
		// 데이터 저장은 push
		stack.push("해단이");
		stack.push("세희");
		stack.push("기팡이");
		stack.push("성지니");

		String human = stack.pop();	// 마지막 데이터 제거하면서 가져오기
		System.out.println(human);
		System.out.println();

		// 마지막 데이터 제거하지 않고 가져오기
		human = stack.peek();
		System.out.println(human);

		human = stack.peek();
		System.out.println(human);

		// 전체 출력
		System.out.println();
		for (String temp : stack) {
			System.out.println(temp);
		}
	}

}
