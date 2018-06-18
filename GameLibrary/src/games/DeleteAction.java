package games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GameDAO;
import tools.Action;

public class DeleteAction extends Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		int id = Integer.parseInt(req.getParameter("id"));
		GameDAO gameDAO = new GameDAO();
		/*boolean isSuccess =*/
		gameDAO.delete(id);
		return "Index.action";
	}

}
