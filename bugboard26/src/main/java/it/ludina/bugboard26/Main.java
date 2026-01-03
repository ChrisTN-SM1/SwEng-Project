package it.ludina.bugboard26;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8080/";

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     * 
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in it.ludina package
        final ResourceConfig rc = new ResourceConfig().packages("it.ludina.bugboard26");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        LOGGER.info("Jersey app started with endpoints available at " + BASE_URI + "\nHit Ctrl-C to stop it...");
        System.in.read();
        server.shutdownNow();
    }
}
