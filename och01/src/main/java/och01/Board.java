package och01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class Board
 */
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// request 파라미터 받아오기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 현재 시간 받아오기 (java.util.Date)
		Date date = new Date();
		
		// response 받아서 출력
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>"); 	// html 태그 열기 (크롬에서는 생략 가능)
		
		out.println("<h1>게시판</h1>");
		out.printf("제목 : %s<p>", title);
		out.printf("작성자 : %s<p>", writer);
		out.printf("작성일 : %s<p>", date);
		out.printf("내용<p><pre>%s</pre>", content);	// <pre></pre> 엔터 키 동작하게 하는 태그
		
		out.println("</body></html>");	// html 태그 닫기 (크롬에서는 생략 가능)
		
		// 닫아주기
		out.close();
	
	}

}
