package games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Game;
import dao.GameDAO;
import tools.Action;

public class CreateAction extends Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		String title = req.getParameter("title");
		String company = req.getParameter("company");
		String date = req.getParameter("release");
		String genre = req.getParameter("genre");
		Game game = new Game(-1, title, company, date, genre);
		GameDAO gameDAO = new GameDAO();

		boolean isSuccess = gameDAO.create(game);
		if (isSuccess)
		{
			return "Index.action";
		}
		return "new.jsp";
	}

}
