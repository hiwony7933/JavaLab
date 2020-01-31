package Design_CompositePattern;
// 파일과 디렉토리 클래스에서 공통으로 사용할 메소드를 소유한 인터페이스 
public interface Entry {
	public void add(Entry entry);
	void remove();
	void rename(String name);
}
