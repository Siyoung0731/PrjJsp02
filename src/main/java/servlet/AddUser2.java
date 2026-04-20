package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser2")
public class AddUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Constructor
	//1. 생성자 : 보통 생략
    public AddUser2() { 
    	System.out.println("생성자");
    }

    //init
    //2. init - 초기화 : 보통 생략
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	//destroy 
	//6. destroy 클래스의 인스턴스 소멸될 때 : 보통 생략
	public void destroy() {
		System.out.println("destroy() 실행");
	}

	//service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
	}

	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("doGet() 실행");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 실행");
		doGet(request, response);
	}

}
