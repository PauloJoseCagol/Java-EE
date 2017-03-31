package javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/cliente","/clienteController"})
public class ClienteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Chamou pelo método GET!");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método Get!");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método POST!");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método Delete!");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método PUT!");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet terminado...");
		super.destroy();
	}
	
	
}
