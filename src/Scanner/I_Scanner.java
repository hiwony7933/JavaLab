package Scanner;

import java.util.Scanner;

public class I_Scanner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	 
		
		System.out.print("이름입력 :"); 	
		String name = sc.nextLine();
		
		System.out.print("나이입력:");		
		int age = sc.nextInt();
		
		System.out.println("이름은" + name + "나이는 " + age); 
		sc.close();

	}

}
