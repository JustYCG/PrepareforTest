package www.csdn.net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.csdn.net.domain.User;
import www.csdn.net.service.UserService;
import www.csdn.net.service.UserServiceImpl;

public class DeleteUserServlet extends HttpServlet {
private UserService userService = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取提交的数据
		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		//创建一个实体对象
		User entity = new User(userName,userPass, null);
		boolean flag = userService.delete(entity);
		if(flag){
			 request.setAttribute("flag", true);
			 request.getRequestDispatcher("./delete.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
