package com.etena.cloud.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 祁乃臣
 * @date 2024/5/31 15:51
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String emsg = null;
		try {
			subject.login(token);
		}catch (UnknownAccountException e) {
			emsg = "用户名出错";
		}catch (IncorrectCredentialsException e) {
			emsg = "密码出错";
		}catch (AuthenticationException e) {
			emsg = "其他问题: " + e.getMessage();
		}
		if((emsg != null) ) {
			request.setAttribute("emsg", emsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
