package www.csdn.net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.csdn.net.dao.UserDao;
import www.csdn.net.dao.UserDaoImpl;
import www.csdn.net.domain.User;

public class LoginServlet extends HttpServlet {
	private UserDao userDao=new UserDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username"); 		
		String userPass = request.getParameter("userpass"); 
		User entity=userDao.login(userName, userPass);
		if(entity==null){
			response.sendRedirect("./error.jsp");
		}else{
			request.setAttribute("user", entity);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
