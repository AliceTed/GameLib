package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.User;
import bean.UserList;

public class UserDAO extends DAO
{
	/**
	 * データベースからすべてのUserの情報を取得
	 * @return　UserList
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 */
	public UserList index() throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select *from users");
		ResultSet resultSet = statement.executeQuery();
		UserList list = new UserList();

		while (resultSet.next())
		{
			int id = resultSet.getInt("id");
			String email = resultSet.getString("email");
			String name = resultSet.getString("name");
			String passward = resultSet.getString("passward");
			list.add(new User(id, email, name, passward));
		}
		statement.close();
		connection.close();
		return list;
	}

	/**
	 * 指定のuserの情報をデータベースに登録
	 * @param user
	 * @return falseならエラー(登録失敗)
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 */
	public boolean create(User user) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "insert into users (email,name,passward) values(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(excute);
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getName());
		statement.setString(3, user.getPassward());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connection.close();
		return result;
	}

	public boolean update(User user) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "update users set email=?,name=?,passward=? where id = ?";
		PreparedStatement statement = connection.prepareStatement(excute);
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getName());
		statement.setString(3, user.getPassward());
		statement.setInt(4, user.getId());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connection.close();
		return result;
	}

	public boolean delete(int id) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "delete from users where id=?";
		PreparedStatement statement = connection.prepareStatement(excute);
		statement.setInt(1, id);

		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connection.close();
		return result;
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 */
	public User read(int id) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select *from users where id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		User user = null;

		if (resultSet.next())
		{
			String email = resultSet.getString("email");
			String name = resultSet.getString("name");
			String passward = resultSet.getString("passward");
			user = new User(id, email, name, passward);
		}
		statement.close();
		connection.close();
		return user;
	}

	public User read(String email, String passward) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select *from users where email=? and passward=?");
		statement.setString(1, email);
		statement.setString(2, passward);
		ResultSet resultSet = statement.executeQuery();
		User user = null;

		if (resultSet.next())
		{
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			user = new User(id, email, name, passward);
		}
		statement.close();
		connection.close();
		return user;
	}
}
