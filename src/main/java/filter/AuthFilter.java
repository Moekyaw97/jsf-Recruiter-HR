package filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import bean.RecruiterBean;


@WebFilter({ "/views/*", "/template/*" })
public class AuthFilter implements Filter {
	
	@Inject
	private RecruiterBean recrubean;
    public AuthFilter() {
    
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		if(recrubean.getRecruiter().getId()==0) {
			HttpServletRequest req=(HttpServletRequest) request;
			req.setAttribute("errormessage", "Please Log in !");
			req.getServletContext().getRequestDispatcher("/index.xhtml").forward(req, response);
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
