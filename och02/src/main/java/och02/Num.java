package och02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Num
 */
public class Num extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Num() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");		// 한글 깨지지 않게 출력!!! 잊지말자ㅠ
		
		int num1 = Integer.parseInt(request.getParameter("num1")) ;
		int num2 = Integer.parseInt(request.getParameter("num2")) ;
		float num3 = (float) num1/num2;
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>연산결과</h1>");
		
		out.printf("덧셈 : %d + %d = %d<br>", num1, num2, (num1+num2));
		out.printf("뺄셈 : %d - %d = %d<br>", num1, num2, (num1-num2));
		out.printf("곱셈 : %d * %d = %d<br>", num1, num2, (num1*num2));
		out.printf("나눗셈 : %d / %d = %f", num1, num2, num3);
	
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
