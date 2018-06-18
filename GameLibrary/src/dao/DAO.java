package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO
{
	private static DataSource dataSource;

	public Connection getConnection() throws SQLException, NamingException, URISyntaxException
	{
		/*URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		
		return DriverManager.getConnection(dbUrl, username, password);*/
		if (dataSource == null)
		{
			InitialContext initialContext = new InitialContext();
			dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/games");
		}
		return dataSource.getConnection();
	}
}
