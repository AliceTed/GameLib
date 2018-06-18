package games;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import tools.Action;
import utils.Hashing;

public class SignUpAction extends Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String passward = req.getParameter("passward");
		Hashing hashing = null;
		try
		{
			hashing = new Hashing("SHA");

		} catch (NoSuchAlgorithmException e1)
		{
			return "signup.jsp";
		}
		User user = new User(-1, email, name, hashing.toHash(passward));
		UserDAO userDAO = new UserDAO();
		boolean isSuccess = userDAO.create(user);
		if (!isSuccess)
		{
			return "signup.jsp";
		}
		return "signin.jsp";
	}

}
