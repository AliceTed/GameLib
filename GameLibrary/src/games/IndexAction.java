package games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GameList;
import dao.GameDAO;
import tools.Action;

public class IndexAction extends Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		GameDAO gameDAO = new GameDAO();
		GameList games = gameDAO.index();
		req.setAttribute("list", games);
		return "index.jsp";
	}

}
