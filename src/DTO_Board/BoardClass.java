package DTO_Board;

public class BoardClass {
	// 저장할 항목을 private 변수로 생성
	// 글번호, 제목, 내용
	private int num;
	private String title;
	private String content;

	// 일련번호 생성을 위한 static 변수를 1개 생성
	private static int sequence;

	// 생성자
	public BoardClass() {
		// static 변수는 이전에 수정한 내용을 가지고 있기 때문에 1씩 증가
		sequence = sequence + 1;
		// num은 인스턴스 변수라서 생성자를 호출 할 때 마다 매번 새로 생성
		// 새로생성되는 num에 sequence의 값을 대입하면 일련번호가 됨.
		num = sequence;
	}

	// 인스턴스 변수 사용을 위한 접근자 메소드
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// 디버깅을 위한 메소드
	// 출력하는 메소드에 인스턴스를 대입했을 때 호출되는 메소드
	// 자바는 인스턴스를 출력하는 메소드에 대입하면 ToString 이라는 메소드가 호출됩니다.
	// 인스턴스 변수의 값을 전부 확인하고자 할때 일일이 get 메소드를 부르는 것은 코드의 낭비
	// 이런 경우에는 ToString()을 호출해서 한번에 확인
	@Override
	public String toString() {
		return "BoardClass [num=" + num + ", title=" + title + ", content=" + content + "]";
	}
}