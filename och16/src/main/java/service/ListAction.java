package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ListAction Service start!");
		
		BoardDao bd = BoardDao.getInstance();
		
		try {
			
			// Board row 개수 count
			int totCnt = bd.getTotalCnt();		// 38
			
			// 난잡한 Paging 작업을 해보자....
			String PageNum = request.getParameter("pageNum");				// 1
			
			if (PageNum == null || PageNum.equals("")) PageNum = "1";	// 1
			
			int currentPage = Integer.parseInt(PageNum);			// 1
			int pageSize = 10, blockSize = 10;							// pageSize : 한 화면에 보여줄 row(게시판) 개수 = 10
			int startRow = (currentPage - 1) * pageSize + 1;		// 1
			int endRow = startRow + pageSize - 1;					// 10
			int startNum = totCnt - startRow + 1;					// startNum : 첫번째 row(게시판)의 숫자 : 38
			
			// Board 조회
			List<Board> list = bd.boardList(startRow, endRow);							// (1, 10)
			
			// Math.ceil() : 올림
			int pageCnt = (int) Math.ceil((double) totCnt / pageSize);					// 4
			
			int startPage = (int) (currentPage - 1) / blockSize * blockSize + 1;			// 1
			int endPage = startPage + blockSize - 1;											// 10
			
			// 공갈 page 방지
			if (endPage > pageCnt) endPage = pageCnt;										// if (10 > 4) 
			
			request.setAttribute("list", list);	// ***중요!!
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("PageNum", PageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// MVC 중 View page 명칭
		// 서비스에서 뷰단 던져주기
		return "listForm.jsp";
	}

}
