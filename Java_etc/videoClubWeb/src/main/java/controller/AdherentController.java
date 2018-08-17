package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import model.Adherent;
import repositories.AdherentRepository;

/**
 * Servlet implementation class AdherentController
 */
@WebServlet("/adherent")
public class AdherentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdherentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdherentRepository adherentRepository = null;
		RequestDispatcher rd = null;
		Integer id = null;
		ApplicationContext ctx = (ApplicationContext) this.getServletContext().getAttribute("ctx");
		adherentRepository = ctx.getBean(AdherentRepository.class);
		String query = request.getParameter("q");
		if (query == null) {
			rd = list(adherentRepository, request);
		} else if (query.equals("delete")) {
			id = Integer.parseInt(request.getParameter("id"));
			delete(adherentRepository, id);
			rd = list(adherentRepository, request);
		} else if (query.equals("edit")) {
			if (request.getParameter("id") != null) {
				id = Integer.parseInt(request.getParameter("id"));
				Optional<Adherent> opt = adherentRepository.findById(id);
				if (opt.isPresent()) {
					request.setAttribute("adherent", opt.get());
				} else {
					request.setAttribute("adherent", new Adherent());
				}
			} else {
				request.setAttribute("adherent", new Adherent());
			}
			rd = request.getRequestDispatcher("WEB-INF/editAdherent.jsp");
		}
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void delete(AdherentRepository repo, int id) {
		repo.deleteById(id);
	}

	private RequestDispatcher list(AdherentRepository repo, HttpServletRequest request) {
		request.setAttribute("adherents", repo.findAll());
		return request.getRequestDispatcher("WEB-INF/adherents.jsp");
	}

}
