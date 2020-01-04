package edu.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.service.EmpService;
import edu.bit.service.EmpServiceImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
        actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("doPost");
	       actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("actionDo");
        
        String uri = request.getRequestURI();
        System.out.println("uri : " + uri);
        String conPath = request.getContextPath();
        System.out.println("conPath : " + conPath);
        String command = uri.substring(conPath.length());
        System.out.println("command : " + command);
 
        String page ="index.html";
        if(command.equals("/insert.do")){
            System.out.println("insert");
            System.out.println("----------------");
        }else if(command.equals("/update.do")){
            System.out.println("update");
            System.out.println("----------------");
        }else if(command.equals("/select.do")){
            System.out.println("select");
            System.out.println("----------------");
            EmpService empService = new EmpServiceImpl();
            empService.empServiceAll(request, response);            
            page ="emp.jsp";
        }else if(command.equals("/delete.do")){
            System.out.println("delete");
            System.out.println("----------------");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}
