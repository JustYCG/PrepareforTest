package www.csdn.net.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.csdn.net.domain.User;
import www.csdn.net.service.UserService;
import www.csdn.net.service.UserServiceImpl;

public class FindUserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡ�ύ������
		String userName = request.getParameter("username");
		response.setContentType("text/html;charset=UTF-8");
		User user=userService.findByName(userName);
		int id=user.getId();
		String name=user.getName();
		String pass=user.getPass();
		Date logintime=user.getLoginTime();
		PrintWriter out= response.getWriter();
		out.write("ID:"+id+"<br/>�û�����"+name+"<br/>���룺"+pass+"<br/>����¼ʱ�䣺"+logintime);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
