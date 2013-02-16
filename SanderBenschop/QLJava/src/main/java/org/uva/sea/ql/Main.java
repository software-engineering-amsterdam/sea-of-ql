package org.uva.sea.ql;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

import java.io.FileInputStream;
import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] arguments) {
        QLCommandLineParameters commandLineParameters = new QLCommandLineParameters();
        JCommander jCommander = new JCommander(commandLineParameters);
        try {
//            jCommander.parse(arguments);
            startJettyServer(8080);
        } catch(ParameterException exception) {
            LOGGER.severe("Cannot parse these arguments, use this interpreter with the following command line options:");
            jCommander.usage();
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startJettyServer(int port) throws Exception {
        Server server = new Server(port);
        XmlConfiguration configuration = new XmlConfiguration(new FileInputStream("src/main/resources/jetty.xml"));
        configuration.configure(server);
        server.start();
    }
}
