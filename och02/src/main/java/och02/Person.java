package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Person
 */
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 파라미터 받기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] notice = request.getParameterValues("notice");		// getParameterValues : checkbox 선택 값 배열로 받음
		String job = request.getParameter("job");
		
		// 웹으로 내보내기 (response)
		PrintWriter out = response.getWriter();
		
		out.println("<h1>개인정보</h1>");
		out.println("이름 : " + name + "<p>아이디 : " + id + "<p>");
		out.println("암호 : " + password + "<p>성별 : " + gender + "<p>");
		out.println("수신메일 : ");
		
		if ( notice != null ) {
			for (int i=0; i < notice.length; i++) {
				out.println(notice[i] + ",");
			}
		} else out.println("없음");
		
		out.println("<p>직업 : " + job);
		
		// 닫기
		out.close();
		
	}

}
