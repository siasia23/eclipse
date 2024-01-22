package och06;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

/**
 * Servlet implementation class Greet
 */
public class Greet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // init() : 서블릿이 탐캣 컨테이너에 올라갈 때, 단 한 번만 실행됨
	public void init(ServletConfig config) throws ServletException {

		System.out.println("init() started!");
		
		try {
			log = new PrintWriter(new FileWriter("c:/log/log.txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("윽!");
		}
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

		System.out.println("destroy() started!");
		
		log.flush();		// 누적 데이터를 한꺼번에 파일에 쓰기
		
		if (log != null) log.close();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("doGet() started!");
		
		String name = request.getParameter("name");
		
		String msg = name + "님 반가움\r\n";
		
		// 현재 시간 받아오기
		GregorianCalendar gc = new GregorianCalendar();
		String date = String.format("%TF %TT\r\n", gc, gc);		// TF(날짜), TT(시간)
		
		// 파일에 출력할 내용 (date + msg)
		log.print(date + msg);
		
		PrintWriter out = response.getWriter();
		
		// 화면에 출력할 내용 (msg)
		out.println("<h2>인사</h2>" + msg);
		
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
