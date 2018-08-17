package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class StartingListener
 *
 */
@WebListener
public class StartingListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public StartingListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		((ClassPathXmlApplicationContext) sce.getServletContext().getAttribute("ctx")).close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("ctx", new ClassPathXmlApplicationContext("applicationContext.xml"));
	}

}
