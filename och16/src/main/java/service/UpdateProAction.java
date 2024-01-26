package service;

import java.io.IOException;
import java.sql.SQLException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 1. 파라미터 num , pageNum, writer, email, subject, passwd, content 얻어오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String passwd = request.getParameter("passwd");
		String content = request.getParameter("content");
		
		try {

				// 2. Board board 생성하고 DTO Value Setting
				Board board = new Board();
				
				board.setNum(num);
				board.setWriter(writer);
				board.setEmail(email);
				board.setSubject(subject);
				board.setPasswd(passwd);
				board.setContent(content);
						
				// 3. BoardDao bd Instance
				BoardDao bd = BoardDao.getInstance();
	
				int result = bd.update(board);
				
				// 4. request 객체에 result, num , pageNum 
				request.setAttribute("result", result);
				request.setAttribute("num", board.getNum());
				request.setAttribute("pageNum", pageNum);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} 
		
		// 5.updatePro.jsp Return
		return "updatePro.jsp";
	}

}