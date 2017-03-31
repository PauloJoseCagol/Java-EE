package javaweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.model.Cliente;
import br.com.javaweb.service.ClienteService;

@WebServlet(urlPatterns = { "/cliente", "/clienteController" })
public class ClienteServlet extends HttpServlet {

	ClienteService clienteService;

	public ClienteServlet() { // Construtor. É criando automáticamente.
		// TODO Auto-generated constructor stub
		System.out.println("Construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {// Método init. Inicializa o
												// Servlet. Criado
												// automáticamente.
		// TODO Auto-generated method stub
		System.out.println("Inicializando Servlet");
		clienteService = new ClienteService();

		super.init();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Chamou o Service...");
		// Esse método é o primeiro a receber o request e o response. Apartir
		// desse método que vai para doGet ou doPost
		//
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String i = req.getParameter("i");
		if (i != null && i != "") {
			clienteService.excluir(Integer.parseInt(i));
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); // Direcionando
																				// a
																				// tela.
		req.setAttribute("lista", clienteService.getTodosClientes());
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		// Recebendo E-mail
		String email = req.getParameter("email");// Captura por parametro.
													// cliente.html parametro
													// name="email"

		// Colocando E-mail em um objeto Cliente
		cliente.setEmail(email);

		clienteService.cadastrar(cliente);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); // Direcionando
																				// a
																				// tela.
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("lista", clienteService.getTodosClientes());
		dispatcher.forward(req, resp);

		// resp.sendRedirect("cliente"); //Redirecionando. Nesse caso para
		// /cliente dando um "refresh" na tela.

		/*
		 * resp.setCharacterEncoding("UTF-8");
		 * resp.getWriter().print("Chamou pelo método POST\n E-mail "+email);
		 */
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
		System.out.println("Servlet será destruido...");
		// Aqui pode ser feito algo antes do Servlet ser destruido.
		super.destroy();
	}

}
