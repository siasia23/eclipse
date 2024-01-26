package service;

import java.io.IOException;
import java.sql.SQLException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			// 1. 파라미터 num , pageNum, writer, email, subject, passwd, content 얻어오기
			String pageNum = request.getParameter("pageNum");		
			System.out.println("pageNum : " + pageNum);		
			
			int num = Integer.parseInt(request.getParameter("num"));
			System.out.println("num : " + num);		// 이걸 못가져오는중 ㅡㅡ @@@@@@@@@@@@@@@@@@
			String writer = request.getParameter("writer");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			
			int ref = Integer.parseInt(request.getParameter("ref"));
			System.out.println("ref : " + ref);
			int re_step = Integer.parseInt(request.getParameter("re_step"));
			System.out.println("re_step : " + re_step);
			int re_level = Integer.parseInt(request.getParameter("re_level"));
			System.out.println("re_level : " + re_level);
			String ip = request.getRemoteAddr();
			
			// 2. Board board 생성하고 DTO Value Setting
			Board board = new Board();
			
			board.setNum(num);
			board.setWriter(writer);
			board.setEmail(email);
			board.setSubject(subject);
			board.setPasswd(passwd);
			board.setContent(content);
			board.setRef(ref);
			board.setRe_step(re_step);
			board.setRe_level(re_level);
			board.setIp(ip);
			
			// 3. BoardDao bd Instance
			BoardDao bd = BoardDao.getInstance();
			
			int result = bd.insert(board);
			
			// 4. request 객체에 result, num , pageNum 	  
			request.setAttribute("result", result);
			request.setAttribute("num", board.getNum());
			request.setAttribute("pageNum", pageNum);
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

		return "writePro.jsp";
		
	}

}
