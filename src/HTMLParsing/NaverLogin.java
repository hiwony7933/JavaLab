package HTMLParsing;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverLogin {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com"); // 네이버 로그인 주소

		// 아이디비밀번호 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요");
		String pw = sc.nextLine();

		driver.findElement(By.id("id")).sendKeys(id); // id가 있으면 xpath 쓸필요 없다.
		driver.findElement(By.id("pw")).sendKeys(pw); // xpath는 id가 없을 때
		driver.findElement(By.id("log.login")).click(); // 로그인 버튼 찾기

		String html = driver.getPageSource();
		Document document = Jsoup.parse(html);

		sc.close();

	}

}
