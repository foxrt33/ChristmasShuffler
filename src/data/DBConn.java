package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.Server;

public class DBConn {
	
	public Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:h2:~/test");
		return DriverManager.getConnection("jdbc:h2:9123/test");
	}
	
	public Server getServerInfo() throws SQLException {
		return Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers").start();		
	}
	
	public static void main(String[] args) {
		
		try {
			
			DBConn db = new DBConn();
			Server s = db.getServerInfo();
			Connection c = db.getConnection();
			
			System.out.println(c.getSchema());
			s.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
