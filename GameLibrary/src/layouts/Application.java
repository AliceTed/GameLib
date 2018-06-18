package layouts;

import java.io.PrintWriter;

public class Application
{
	public static void header(PrintWriter out)
	{
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Document</title>");
		out.println("</head>");
		out.println("<body>");

	}

	public static void footer(PrintWriter out)
	{

		out.println("</body>");
		out.println("</html>");
	}

}
