package I_Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		// java.util.Date 는 년도의 1900년 이후 지나온 년도, 월은 0부터 시작, 일은 1부터 시작
		// 2020년 1월 17일을 만들고자 하는 경우
		// Date date = new Date(2020,1, 17); // 3920년 2월 17일이 됨.
		Date date = new Date(120, 0, 17);
		System.out.println(date);
		System.out.println();

		// Calendar 클래스의 인스턴스를 생성
		// Calendar 클래스는 추상 클래스 ->추상 클래스는 인스턴스를 생성할수 없다.
		// Calendar 클래스에 인스턴스를 만든게 아니고
		// Calendar 클래스를 상속받은 클래스의 Anonymous Class를 생성해서 인스턴스를 만든 후 리턴
		// 자바에서 인터페시으나 추상클래스를 리턴타입으로 하는 모든 메소드는 이 원리가 적용됨.
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);	// toString 이 너무 많은 양의 데이터를 리턴하도록 만들어져서 보기 어려움.
		System.out.println();
		System.out.println((cal.get(Calendar.MONTH) + 1) + "월"); // 월은 항상 +1붙여서 출력하자. 0부터 시작한다.
		System.out.println();

		// 프로그래밍의 편리성을 위해서 첫번째 위치에 의미없는 값을 삽입해서 인덱스와 데이터의 위치를 맞추는 경우가 있다.
		// 인덱스를 쓰기 편하게 맞춰주는게 효율성이 높을수도 있다.
		int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 0번째에 0을 삽입해서 1번째부터 1~12월 맞췄다.

		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mm:ss");	// 날짜를 문자열로 변경해주는 클래스 - 생성할 때 서식을 입력
		String msg = sdf.format(today);
		System.out.println(msg);

	}

}
