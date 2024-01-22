package och01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GuGu
 */
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		response.setContentType("text/html;charset=utf-8");
		
/*	
		String sum=null;

		for (int i=1; i<=9; i++) {
			for (int j=1; j<=i; j++) {
//				System.out.println( i +"*" + j + "=" + i*j );
				sum =  i +"*" + j + "=" + i*j  ;
			}
		}
*/

		PrintWriter out = response.getWriter();
		out.println("<html><body>"); 
		out.printf("<h1>%d단</h1>", num); 
		
		for (int i=1; i<=9; i++) {
			out.printf("%d * %d = %d<br>", num, i, (num*i));
		}
		
//		out.println(sum);
		out.println("</body></html>");
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
