package com.cards.shuffler.main.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * This is the main class that configures the jetty server and starts the
 * application and server.
 * 
 * @author Sona
 *
 */
public class ApplicationServer {
	/**
	 * Start of the flow of the application.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server(7070);

		ResourceConfig config = new ResourceConfig();
		config.packages("com.cards.shuffler");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}
}