package och17;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// filter 세팅하는 방법 1 : anotation (@)	(더 많이 씀!! 스프링에서도 중요!!!)
// filter 세팅하는 방법 2 : xml

///sub1/* : sub1 폴더 밑의 모든 것에 대해 이 필터를 설정한다
// @WebFilter("/sub1/*")		
public class SimpleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Filter 시작!");
		
		// 또다른 filter 수행하려면 chain으로 연결시켜줌
		chain.doFilter(request, response);
		
		System.out.println("Filter 끝!");
		
	}

}
