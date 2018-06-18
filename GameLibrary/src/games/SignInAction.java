package games;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import tools.Action;
import utils.Hashing;

public class SignInAction extends Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		String email = req.getParameter("email");
		String passward = req.getParameter("passward");
		Hashing hashing = null;
		try
		{
			hashing = new Hashing("SHA");
		} catch (NoSuchAlgorithmException e1)
		{
			return "signin.jsp";
		}
		passward = hashing.toHash(passward);
		UserDAO userDAO = new UserDAO();
		User user = userDAO.read(email, passward);
		boolean isSuccess = user != null;

		if (!isSuccess)
		{
			return "signin.jsp";
		}
		req.getSession().setAttribute("user", user);
		return "Index.action";
	}

}
