package och06;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Servlet implementation class Fibonazzi
 */
public class Fibonazzi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 배열 100개를 만들자
	BigInteger[] arr = new BigInteger[100];
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fibonazzi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // 수열 계산 로직
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Fibonazzi init 호출!");
		
		// 피보나치 수열 시작 값
		arr[0] = new BigInteger("1");	// index 0에 값 1을 넣음
		arr[1] = new BigInteger("1");	// index 1에도 값 1을 넣음
		
		// 피보나치 수열을 for문으로 표현
		for (int i=2; i<arr.length; i++) {
			arr[i] = arr[i-2].add(arr[i-1]);		// add : 덧셈 메소드
		}
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// 화면에 출력할 내용만
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		System.out.println("Fibonazzi doGet 호출!");
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		if (num > 100) num=100;		// 최대값을 100으로 설정
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>피보나치 수열</h2>");
		
		// 배열 값을 화면에 다 찍어냄
		for (int i=0; i < num; i++) {
			out.println(arr[i] + "<br>");
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
