package krew.server;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * Created by Kush on 3-4-2017.
 */
public class Server {
    private static Logger logger = LoggerFactory.getLogger(Databaseimpl.class);
    private static Database DB_iNSTANCE;
    private int port = 8080;

    public Server() throws Exception {
        HttpServer server = initWebserver();
        server.start();
        logger.info("Server is gestart op port" + port);

        while (true) {
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws Exception {
        DB_iNSTANCE = (args.length == 1 && args[0].equals("--mock-db"))
                ? new MockDatabase()
                : new Databaseimpl();

        logger.info("Database instantie is " + DB_iNSTANCE.getClass().toString());
        new Server();
    }

    private HttpServer initWebserver() {
        ResourceConfig config = new ResourceConfig();
        config.register(JacksonJaxbJsonProvider.class);
        URI uri = URI.create("http://0.0.0.0:" + port);
        return GrizzlyHttpServerFactory.createHttpServer(uri, config, true);

    }

    public static Database getDatabase() {
        return DB_iNSTANCE;
    }
}
