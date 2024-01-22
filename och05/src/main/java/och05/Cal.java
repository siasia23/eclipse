package och05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cal
 */
public class Cal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>연산결과</h2>");
		
		try {
			
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			
			out.printf("%d + %d = %d<p>", num1, num2, (num1+num2));
			out.printf("%d - %d = %d<p>", num1, num2, (num1-num2));
			out.printf("%d * %d = %d<p>", num1, num2, (num1*num2));
			out.printf("%d / %d = %d<p>", num1, num2, (num1/num2));
			
		} catch (NumberFormatException e) {
			out.println("입력한 타입이 숫자가 아니어서 발생하는 에러");
		} catch (ArithmeticException e) {
			out.println("0으로 나눠서 발생하는 에러");
		} catch (Exception e) {
			out.println("그 외 모든 error!!!!" + e.getMessage());	// getMessage : 에러 메시지를 띄워주자
		}
		
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
