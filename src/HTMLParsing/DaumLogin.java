package HTMLParsing;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaumLogin {

	public static void main(String[] args) {
		// 크롬 드라이버의 위치를 프로퍼티에 추가 // 강제 실행이 되었으면 주석처리하고 해도됨.
		// System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// 크롬 실행
		WebDriver driver = new ChromeDriver();
		// 크롬에서 다음 로그인 사이트 접속
		driver.get("https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F");

		// 아이디와 비밀번호 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요");
		String pw = sc.nextLine();

		// 아이디란과 비밀번호 입력란에 입력받은 내용을 입력하기
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(id);
		driver.findElement(By.xpath("//*[@id=\"inputPwd\"]")).sendKeys(pw);

		// 로그인 버튼 클릭
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.print("예외" + e.getMessage());
			e.printStackTrace();
		}
		// 카페에 접속
		// ggangpea1 - wnddkd1969
		driver.get("http://cafe.daum.net/samhak7/_memo");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("예외" + e.getMessage());
			e.printStackTrace();
		}
		// 프레임을 전환 : down 이라는 프레임으로 전환
		driver.switchTo().frame(driver.findElement(By.id("down")));
		System.out.print("입력할 메모:");
		String memo = sc.nextLine();
		driver.findElement(By.xpath(
				"//*[@id=\"memoForm\"]>div>table>tbody>tr:nth-child(1)>td.longtail_comment.inp>div>textarea"))
				.sendKeys(memo);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 등록버튼 클릭
		driver.findElement(By.xpath(
				"//*[@id=\"memoForm\"]>div>table>tbody>tr:nth-child(1)>td.longtail_comment.inp>div>textarea"))
				.click();

		sc.close();

	}

}
