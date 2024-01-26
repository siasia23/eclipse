package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommandProcess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// property key = String, value = Object
	private Map<String, Object> commandMap = new HashMap<String, Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // 톰캣 서버가 시작될 때 처음 딱 한 번 실행되는 init Method
	public void init(ServletConfig config) throws ServletException {

		// getInitParameter() : web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("config");
		System.out.println("1. init String props : " + props);
		
		// Properties = key + value
		Properties pr = new Properties();
		
		FileInputStream f =null;
		
		try {
			
			// getRealPath() : 파라미터로 받은 파일의 metadata 가져옴
				// 배포한 서버의 경로를 여기서 한 번에 읽어들이기 위해
				// 배포할때마다 경로가 달라져서
			String configFilePath = config.getServletContext().getRealPath(props);
			System.out.println("2. init String configFilePath : " + configFilePath);
			
			// 가져온 경로와 metadata로 file 생성
			f = new FileInputStream(configFilePath);
			
			// Memory Up : 메모리에 올라가야 CPU를 받아서 처리 가능해짐
				// key = /list.do
				// value = service.ListAction
			pr.load(f);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (f != null)
				try {
					
					f.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		// pr.keySet() : 프로퍼티의 키들만 모아서
		// 이 프로젝트에서 keyIter에 들어가는 값들 : /list.do /content.do /updateForm.do
		Iterator keyIter = pr.keySet().iterator();
		
		while (keyIter.hasNext()) {
			
			String command = (String) keyIter.next();			// 프로퍼티 key
			String className = pr.getProperty(command);		// 프로퍼티 value		getProperty() : value 가져옴
			System.out.println("3. init command : " + command);
			System.out.println("4. init className : " + className);
			
			try {
				
				/*	좀 더 단순한 또다른 방식
				 * 
				//  ListAction la = new ListAction();
		        // 소멸 Class
			//	Class  commandClass    = Class.forName(className);
			//	Object commandInstance = commandClass.newInstance();
				// new Class   --> 제네릭의 요점은 클래스 유형을 모른다
				 * 
				 */
				
			//  ListAction la = new ListAction(); 를 아래 두 줄의 코드(라인 113, 119)로 표현해보자
				
				// 해당 문자열을 클래스로 만드는 명령어
				Class<?> commandClass = Class.forName(className);	
				
				// 서비스를 인스턴스로 만든다.
					// 여기서 의도한 것은 ListAction la = new ListAction();
					// 하지만 실제 서비스는 여러 개일테니까 코드를 줄이기 위해 이 방식으로!
				// .getDeclaredConstructor().newInstance() : 객체 만드는 메소드. jdbc 버전 올라가면서 메소드 바뀜 (api 참조)
				CommandProcess commandInstance = 
						(CommandProcess) commandClass.getDeclaredConstructor().newInstance();
				
				// 여기서 command, commandInstance에 들어가는 값들 : 
				//          list.do    	service.ListAction
				//         content.do  service.ContentAction
				commandMap.put(command, commandInstance);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
		}
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}
	
	// doGet(), doPost()에서 호출할 하나의 method
	protected void requestServletPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		
		// 표준화를 위해 내가 만든 Interface
		CommandProcess com = null;
		
		// service를 command라고 부르기도 함
		String command = request.getRequestURI();
		System.out.println("1. requestServletPro command : " + command);
		
		// 가져온 URI에서 필요 없는건 버리자
		// substring() : 불필요한 문자열 자르기. 파라미터로 받는 것만큼만 남기고 나머지는 버림.
		command = command.substring(request.getContextPath().length());
		System.out.println("2. requestServletPro command substring : " + command);
		
		try {
			
			// service.ListAction Instance
				// 인스턴스니까 hashcode 가짐
			com = (CommandProcess) commandMap.get(command);
			System.out.println("3. requestServletPro command : " + command);
			System.out.println("4. requestServletPro com : " + com);
			
			// View Page 얻기
			view = com.requestPro(request, response);
			System.out.println("5. requestServletPro view : " + view);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// Controller가 Service에서 View를 받아서 페이지 이동시켜줌
		// view단으로 이동!
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
				
	}

}
