package bridalwear;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MysqlUtils {

	private String mysqlURL = "jdbc:mysql://localhost:3306/shoppingcart?user=root&password=tatenda"+"&useUnicode=true&characterEcoding=UTF8";

	public void insertBySql(String sql) throws SQLException{
		Connection conn = null;
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlURL);
			Statement stmt =conn.createStatement();
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=conn)
				conn.close();
			
		}
	}
		public Integer queryMaxNo() throws SQLException{
			
			Connection conn = null;
			try{
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(mysqlURL);
				Statement stmt =conn.createStatement();
				String sql="select max(no)from shoppingcart.customer";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					return rs.getInt(1);
					}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(null!=conn)
					conn.close();
			
		}
		return 0;
		
		}







}
