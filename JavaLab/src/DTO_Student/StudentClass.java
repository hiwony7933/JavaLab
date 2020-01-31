package DTO_Student;

public class StudentClass {
	// instance 변수 선언
	private int num;
	private String name;
	private String major;

	// 접근자 Method
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		// this 가 붙으면 Method 내부에서는 찾지 않고
		// Method 외부에서 먼저 찾습니다.
		// this.num 은 Method 외부에 있는 instance 변수 num 이고
		// num 은 Method의 매개변수 num 이 됨
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
