package com.cards.shuffler.main.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class ApplicationServer 
{
	public static void main( String[] args ) throws Exception
    {
    	Server server = new Server(7070);
    	        
    	        ResourceConfig config = new ResourceConfig();
    	        config.packages("com.sample.shuffler");
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
