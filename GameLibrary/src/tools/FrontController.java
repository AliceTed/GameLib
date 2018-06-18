package tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "*.action" })
public class FrontController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		try
		{
			//=> /lesson01/new.action
			//一文字目の[/]を削除
			String path = req.getServletPath().substring(1);
			//=> lesson01/new.action
			String name = path.replace(".a", "A").replace("/", ".");
			//=> lesson01.newAction
			Action action = (Action) Class.forName(name).newInstance();
			String url = action.execute(req, resp);
			req.getRequestDispatcher(url).forward(req, resp);
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace(out);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}

}
