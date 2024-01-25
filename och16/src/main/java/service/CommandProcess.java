package service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 인터페이스의 목적 : 표준화
public interface CommandProcess {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
																	throws ServletException, IOException;

}
