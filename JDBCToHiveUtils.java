package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCToHiveUtils{
	private static String driverName="org.apache.hive.jdbc.HiveDriver";
	private static String Url="jdbc:hive2://ishadoop.picp.net:10000/default";
	private static Connection conn;
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(Url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;	
	}
		
	public static PreparedStatement	prepare(Connection conn,String sql) {
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return ps;
	}
}
