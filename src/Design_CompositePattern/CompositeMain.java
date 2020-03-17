package Design_CompositePattern;

public class CompositeMain {

	public static void main(String[] args) {

		File f1 = new File("파일1");
		File f2 = new File("파일2");
		File f3 = new File("파일3");
		
		Directory subDirectory = new Directory("하위 디렉토리");
		subDirectory.add(f1);
		subDirectory.add(f2);
		
		Directory superDirectory = new Directory("상위 디렉토리");
		superDirectory.add(subDirectory); 
		superDirectory.add(f3);;
		
		superDirectory.remove();   // 다지워짐 
		
		//자료형 이름 출력
		System.out.println(superDirectory.getClass().getName());
		Entry entry = new Directory("디렉토리");
		System.out.println(entry.getClass().getName());
		
	}

}
