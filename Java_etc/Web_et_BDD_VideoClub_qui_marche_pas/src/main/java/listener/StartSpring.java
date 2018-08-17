package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class StartSpring
 *
 */
@WebListener
public class StartSpring implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public StartSpring() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		((ClassPathXmlApplicationContext) sce.getServletContext().getAttribute("ctxSpring")).close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		sce.getServletContext().setAttribute("ctxSpring", ctx);

	}

}
