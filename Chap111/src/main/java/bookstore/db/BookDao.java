package bookstore.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDao {
	protected Connection connection = null;
	public Connection getConnection() throws Exception{
		try{
			if(connection == null || connection.isClosed()){
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");
				connection = ds.getConnection();
				//connection.close();
				connection.setAutoCommit(false);
				}
		}catch(Exception e) {
			e.printStackTrace();
			connection = null;
			throw e;
		}
		return connection;
	}
	
	public void closeConnection(){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection = null;
		}
	}
}