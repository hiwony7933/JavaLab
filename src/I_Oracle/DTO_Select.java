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

public class DTO_Select {	// Transaction Class DTO

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("./src/I_Oracle/db.txt")))) {
			String driverClass = br.readLine();
			String url = br.readLine();
			String id = br.readLine();
			String pw = br.readLine();
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, id, pw);

			PreparedStatement pstmt = con.prepareStatement("select * from transactions");	
			ResultSet rs = pstmt.executeQuery();
			
			
			List<Transaction> list = new ArrayList<Transaction>();
			while(rs.next()) {
				Transaction transaction = new Transaction();
				
				transaction.setNum(rs.getInt("num"));
				transaction.setItemcode(rs.getString("itemcode"));
				transaction.setItemname(rs.getString("itemname"));
				transaction.setPrice(rs.getInt("price"));
				transaction.setCnt(rs.getInt("cnt"));
				transaction.setTransdate(rs.getDate("transdate"));
				transaction.setUserid(rs.getString("userid"));
			
				list.add(transaction);
			}
			for(Transaction transaction : list) {
				// System.out.println(transaction);
				System.out.println(transaction.getNum() + " : "  + transaction.getItemcode());
			}
			
			rs.close();
			con.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("데이터베이스 예외" + e.getMessage());
			e.printStackTrace();
		}
	}

}
