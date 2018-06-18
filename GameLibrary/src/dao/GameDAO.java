package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.Game;
import bean.GameList;

public class GameDAO extends DAO
{
	/**
	 * データベースからすべての本の情報を取得
	 * @return　BookList
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 */
	public GameList index() throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select *from games");
		ResultSet resultSet = statement.executeQuery();
		GameList list = new GameList();

		while (resultSet.next())
		{
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String company = resultSet.getString("company");
			Date date = resultSet.getDate("date");
			String genre = resultSet.getString("genru");
			list.add(new Game(id, title, company, date, genre));
		}
		statement.close();
		connection.close();
		return list;
	}

	/**
	 * 指定の本の情報をデータベースに登録
	 * @param book
	 * @return falseならエラー(登録失敗)
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 */
	public boolean create(Game game) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "insert into games (title,company,date,genru) values(?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(excute);
		statement.setString(1, game.getTitle());
		statement.setString(2, game.getCompany());
		statement.setDate(3, game.getDate());
		statement.setString(4, game.getGenre());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connection.close();
		return result;
	}

	public boolean update(Game game) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "update games set title=?,company=?,date=?,genru=? where id = ?";
		PreparedStatement statement = connection.prepareStatement(excute);
		statement.setString(1, game.getTitle());
		statement.setString(2, game.getCompany());
		statement.setDate(3, game.getDate());
		statement.setString(4, game.getGenre());
		statement.setInt(5, game.getId());

		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connection.close();
		return result;
	}

	public boolean delete(int id) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		String excute = "delete from games where id=?";
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
	public Game read(int id) throws SQLException, NamingException, URISyntaxException
	{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select *from games where id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		Game book = null;

		if (resultSet.next())
		{
			String title = resultSet.getString("title");
			String company = resultSet.getString("company");
			Date date = resultSet.getDate("date");
			String genre = resultSet.getString("genru");
			book = new Game(id, title, company, date, genre);
		}
		statement.close();
		connection.close();
		return book;
	}
}
