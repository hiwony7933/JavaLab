package Design_CompositePattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Directory implements Entry {
	private String name;
	// File 이나 Directory를 소유할 수 있기 때문에 Entry를 여러 개 저장 할 수 있는 자료구조를 소유
	List<Entry> list;

	public Directory(String name) {
		this.name = name;
		list = new ArrayList<Entry>();
	}

	@Override
	public void add(Entry entry) {
		list.add(entry);
	}

	@Override
	public void remove() {
		Iterator<Entry> iter = list.iterator();	//Iterator를 이용해서 데이터 접근
		while(iter.hasNext()) {
			Entry entry = iter.next();
			if(entry.getClass().getName().equals("composite.Directory")) {
				System.out.println("하위 디렉토리 내용도 삭제하시겠습니까? (삭제는 Y) :");
				Scanner sc = new Scanner(System.in);
				String reply = sc.nextLine();
				sc.close();
				if(reply.equals("Y") || reply.equals("y")) {
					System.out.println("삭제 진행");
				}else {
					System.out.println("삭제 중단");
					return; // 파일만 지우고 싶으면 리턴하지 말고  
				}
			}
			// 디렉토리인지 확인해서 작업을 수행을 하지 않을 수도 있습니다. 
			// File이 있으면 File의 remove를 호출하고 Directory이면 Directory의 remove를 호출 - 다형성(Polymorphism)
			entry.remove();
		}
		System.out.println("내부 데이터는 전부 삭제되었습니다");
	}

	@Override
	public void rename(String name) {
		this.name = name;
	}

}
