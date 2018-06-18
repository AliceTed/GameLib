package games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Game;
import dao.GameDAO;
import tools.Action;

public class EditAction extends Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		GameDAO gameDAO = new GameDAO();
		int id = Integer.parseInt(req.getParameter("id"));

		Game game = gameDAO.read(id);
		if (game == null)
		{
			game = new Game();
		}
		req.setAttribute("game", game);
		return "edit.jsp";
	}

}
