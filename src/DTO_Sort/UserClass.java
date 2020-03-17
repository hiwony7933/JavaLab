package DTO_Sort;

public class UserClass implements Comparable<UserClass>{

	private int num;
	private String name;
	private int score;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(UserClass o) {
		return this.name.compareTo(o.name) * -1; //내림차순 뒤에 * -1 이거 빼면 오름차순

	}
	
}

