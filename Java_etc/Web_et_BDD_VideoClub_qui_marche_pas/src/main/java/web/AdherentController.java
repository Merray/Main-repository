package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import repositories.AdherentRepository;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/pageAdherent")
public class AdherentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdherentController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdherentRepository adherentRepository=null;
		RequestDispatcher rd =null;
		ApplicationContext ctx= (ApplicationContext) this.getServletContext().getAttribute("ctxSpring");
		
		adherentRepository = ctx.getBean(AdherentRepository.class);
		
		request.setAttribute("adherents", adherentRepository.findAll());
		
		rd=request.getRequestDispatcher("/WEB-INF/index.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
