package DTO_Student;

public class StudentMain {

	public static void main(String[] args) {
		// student Class의 instance 생성
		StudentClass student = new StudentClass();
		// instance 변수에 값을 설정
		student.setNum(1);
		student.setName("park");
		student.setMajor("cs");

		// instance 변수의 값 가져오기
		System.out.println("번호:" + student.getNum());
		System.out.println("이름:" + student.getName());
		System.out.println("전공:" + student.getMajor());

	}

}
