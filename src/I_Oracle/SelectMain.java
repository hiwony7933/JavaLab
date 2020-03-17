package I_Oracle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectMain {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("./src/I_Oracle/db.txt")))) {
			String driverClass = br.readLine();
			String url = br.readLine();
			String id = br.readLine();
			String pw = br.readLine();
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, id, pw);

			PreparedStatement pstmt = con.prepareStatement("select * from transactions");	// transactions 테이블의 모든 데이터 가져오기
			ResultSet rs = pstmt.executeQuery();
			
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();	// 여러개의 컬럼으로 구성된 여러개의 데이터를 저장
			
			while (rs.next()) {		// 데이터 순회
				Map<String, Object> map = new HashMap<String, Object>();	// 하나의 행을 저장할 Map을 생성 

				map.put("num", rs.getInt("num"));
				map.put("itemcode", rs.getString("itemcode"));
				map.put("itemname", rs.getString(3));	// 3번째 컬럼의 값을 문자열로 가져오기
				map.put("price", rs.getInt("price"));
				map.put("cnt", rs.getInt("cnt"));
				map.put("transdate", rs.getDate("transdate"));
				map.put("userid", rs.getString("userid"));

				list.add(map);	// 하나의 행을 list에 저장
			}
			for (Map<String, Object> map : list) {		// list의 데이터 출력
				// System.out.println(map); // 전체를 가져오기
				System.out.println(map.get("num")); // num만 가져오기
			}

			con.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 예외" + e.getMessage());
			e.printStackTrace();
		}
	}

}
