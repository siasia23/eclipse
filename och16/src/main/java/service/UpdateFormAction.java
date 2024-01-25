package service;

import java.io.IOException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UpdateFormAction Service start!");
		
		// 1. num, pageNum 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("PageNum");
		
		try {
			
			// 2. BoardDao bd Instance
			BoardDao bd = BoardDao.getInstance();
			
			// 3. Board board = bd.select(num);
			Board board = bd.select(num);
			
			// 4. request 객체에 num, pageNum, board
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		return "updateForm.jsp";
	}

}
