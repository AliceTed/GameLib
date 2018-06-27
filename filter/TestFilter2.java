package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//.jspへ遷移するときにフラグをfalseにする
//フラグがtrueの時は弾く
/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter(urlPatterns = { "*.jsp" })
public class TestFilter2 implements Filter {

	final String NAME="isAccess";
	private ServletContext context=null;
	  public void init(FilterConfig config) throws ServletException{
	    context=config.getServletContext();

	    if(context.getAttribute(NAME)==null)
		  {
	    	context.setAttribute(NAME, new Boolean(false));
		  }
	  }

	  public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
	    throws ServletException,IOException{

	    context.setAttribute(NAME,new Boolean(false));
	    chain.doFilter(request,response);
	  }

	  public void destroy(){
		  if(context.getAttribute(NAME)!=null)
		  {
			  context.removeAttribute(NAME);
		  }
		context=null;
	  }

}
