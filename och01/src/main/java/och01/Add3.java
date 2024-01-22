package och01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Add3
 */
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 서블릿의 버전 정보. 내부에서 관리하는거니 건들지 말기
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식은 2가지 객체 사용
			// 1. 요청 객체 : request
			// 3. 응답 객체 : response
		
		System.out.println("Add3 Get Start...");
		// get 방식 : url에서 ? 다음에 파라미터가 다 노출됨. 길이는 4k까지여서 이미지 전송은 안 됨. > 보안 취약
		
		// 목표 : 1부터 누적값 전달하기
		int num = Integer.parseInt(request.getParameter("num"))  ;		// num이라는 파라미터 받기
						// text 타입 input이니까 숫자 타입으로 변경하기 : Integer.parseInt()
		String loc = request.getParameter("loc");
		
		System.out.println("Add3 num ->" + num);
		
		int sum = 0;
		for (int i=1; i <=num; i++) {
			sum += i;
		}
		
		System.out.println("Add3 sum ->" + sum);
		
		request.setCharacterEncoding("utf-8");	// 한글 인코딩 하는 법
		response.setContentType("text/html;charset=utf-8");		// 한글 인코딩해서 화면에 보여주는 법
		
		// 공식 --> 사용자 브라우저에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); 
		out.printf("<h1>1부터 %d까지 합계 %s</h1>", num, loc); 
			// printf() : 어떤 변수의 값을 받아올지 정함
			// %d : decimal(소수)의 약자. 여기서는 num 정보 받아오기
			// %s : string. 여기서는 loc 정보 받아오기
//		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Add3 Post Start...");
		// post 방식 : url에 파라미터가 안 보임. 숨겨짐. 이미지 전송에 사용 > 보안 유리
	}

}
