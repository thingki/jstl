package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

public class Exam {
	
	public void init() {
		InputStream in = this.getClass().getResourceAsStream("/conf/dbconf.properties");
		Properties prop = new Properties();
		
		try {
			prop.load(in);
			Iterator<Object> it = prop.keySet().iterator();
			Class.forName(prop.getProperty("driver"));
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			
			while(it.hasNext()) {
				String key = (String)it.next();
				System.out.println(key+"="+prop.getProperty(key));
			}

			Connection con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("연결성공");
			String sql ="select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("customerName"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("난 메인");
		Exam e = new Exam();
		e.init();
	}
}
