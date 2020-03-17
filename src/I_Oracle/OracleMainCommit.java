package I_Oracle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.mindrot.jbcrypt.BCrypt;

public class OracleMainCommit {
	public static void main(String[] args) {
		// 접속 정보를 저장할 텍스트 파일을 생성
		// 프로젝트 안에 db.txt 파일을 생성하고 작성

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("./src/I_Oracle/db.txt")))) {
			String driverClass = br.readLine();
			// System.out.println(driverClass); // 1.처음에 잘 읽고 있는지 확인 (예외안뜨면됨)

			String url = br.readLine();
			String id = br.readLine();
			String pw = br.readLine();

			Class.forName(driverClass); // 2.드라이버 클래스 로드
			Connection con = DriverManager.getConnection(url, id, pw); // 3.데이터베이스 연결 객체 생성
			// System.out.println(con); // 4.con 생성 잘되었나 확인 (예외안뜨면됨)

			// commit()을 만나거나 DDL, DCL을 성공할 때까지 데이터베이스에 반영이 안된다. 
			
			con.setAutoCommit(false); // 9. 복사본에 아래 구문들 실행해놓고 저장을 안시켜버림

			PreparedStatement pstmt = con.prepareStatement("insert into transactions(num, itemcode) " + "values(?,?)");
			pstmt.setInt(1, 7);
			pstmt.setString(2, "태권브이");

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("삽입 성공"); // 삽입은 0보다 크면 성공
			}
			pstmt.close();

			pstmt = con.prepareStatement("insert into transactions(num, itemcode) " + "values(?,?)");
			pstmt.setInt(1, 7);
			pstmt.setString(2, "태권브이");

			int result1 = pstmt.executeUpdate();
			if (result1 > 0) {
				System.out.println("삽입 성공"); // 삽입은 0보다 크면 성공
			}
			pstmt.close();

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println("데이터베이스 예외" + e.getMessage());
			e.printStackTrace();
		}
	}
}
