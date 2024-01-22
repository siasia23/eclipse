package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Color
 */
public class Color extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Color() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String color = request.getParameter("color");	// 파라미터 받아온다
		
		PrintWriter out = response.getWriter();		// 객체 만든다
		
		out.printf("<html><body bgcolor='%s'>", color);
		out.println("</body></html>");		// html 태그는 크롬 브라우저에서는 자동입력됨.
																	// 브라우저에 따라서 자동 지원 안 할 수도 있기 때문에 서블릿에서는 웬만하면 html 태그를 같이 써줍시당
		
		out.close();		// 객체를 열었으면 닫아준다
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
