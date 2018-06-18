package games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Game;
import dao.GameDAO;
import tools.Action;

public class UpdateAction extends Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String company = req.getParameter("company");
		String date = req.getParameter("release");
		String genre = req.getParameter("genre");
		Game game = new Game(id, title, company, date, genre);
		GameDAO gameDAO = new GameDAO();
		gameDAO.update(game);
		return "Index.action";
	}

}
