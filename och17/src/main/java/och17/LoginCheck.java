package och17;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// sub2 폴더 밑의 모든 것에 대해 이 필터를 설정한다
@WebFilter("/sub2/*")
public class LoginCheck extends HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// type 변환
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		HttpSession session = httpServletRequest.getSession();
		System.out.println("LoginCheck doFilter!");
		
		// session이 없다면, ../login.jsp로 가라
		if (session == null || session.equals("")) {
			
			httpServletResponse.sendRedirect("../login.jsp");
			
		}
		
		String id = (String) session.getAttribute("id");
		
		// session은 있는데 id가 없다면, 똑같이 ../login.jsp로 가라
		if (id == null || id.equals("")) {
			
			httpServletResponse.sendRedirect("../login.jsp");
			
		}
		
		// session도 있고, id도 있다면, 정상적으로 chain으로 가라
		super.doFilter(request, response, chain);
		
	}
	
}
