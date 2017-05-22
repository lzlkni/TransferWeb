package App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryHiveUtils {
	private static Connection conn=JDBCToHiveUtils.getConnection();
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public static void getAll(String tablename) {
		String sql="select * from " + tablename + " limit 5";
		
		try {
			ps=JDBCToHiveUtils.prepare(conn, sql);
			rs=ps.executeQuery();
			int columns=rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				for(int i=1;i<columns;i++){
					System.out.print(rs.getString(i));
					System.out.print("\t\t");
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				
	}
}
