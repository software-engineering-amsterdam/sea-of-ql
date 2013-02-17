package org.uva.sea.ql;

import com.beust.jcommander.JCommander;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.error.reporting.SimpleSyntacticErrorReporter;
import org.uva.sea.ql.visitor.codegeneration.CodeGenerator;
import org.uva.sea.ql.visitor.codegeneration.WebAppCodeGeneratingVisitor;
import org.uva.sea.ql.visitor.semanticanalysis.SemanticAnalysisVisitor;
import org.uva.sea.ql.visitor.semanticanalysis.SemanticalAnalyser;

import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] arguments) {
        QLCommandLineParameters commandLineParameters = new QLCommandLineParameters();
        JCommander jCommander = new JCommander(commandLineParameters);
        QLBootstrapper bootstrapper = createQLBootStrapper();
        try {
            jCommander.parse(arguments);
            if (bootstrapper.checkAndBuildQLFile(commandLineParameters.getInputFile())) {
                startJettyServer(commandLineParameters.getHostPort());
            }
        } catch(Exception exception) {
            LOGGER.severe("Error starting up QL, use this interpreter with the following command line options and make sure the file is present:");
            jCommander.usage();
        }
    }

    private static QLBootstrapper createQLBootStrapper() {
        Parser parser = new ANTLRParser(new SimpleSyntacticErrorReporter());
        SemanticalAnalyser semanticalAnalyser = new SemanticAnalysisVisitor();
        CodeGenerator codeGenerator = new WebAppCodeGeneratingVisitor();
        return new QLBootstrapper(parser, semanticalAnalyser, codeGenerator);
    }

    private static void startJettyServer(int port) {
        try {
            Server server = new Server(port);
            ServletContextHandler servletsHandler = new ServletContextHandler();
            servletsHandler.setContextPath("/ql");
            servletsHandler.addServlet(new ServletHolder(new ServletContainer(new PackagesResourceConfig("org.uva.sea.ql.web"))), "/");

            WebAppContext staticResourcesHandler = new WebAppContext();
            staticResourcesHandler.setContextPath("/ql/scripts");
            ResourceCollection resources = new ResourceCollection(new String[] {
                "src/main/webapp/WEB-INF/scripts"
            });
            staticResourcesHandler.setBaseResource(resources);

            HandlerList handlers = new HandlerList();
            handlers.addHandler(staticResourcesHandler);
            handlers.addHandler(servletsHandler);
            server.setHandler(handlers);

            server.start();
            server.join();
        } catch (Exception ex) {
            LOGGER.severe("Jetty server startup failed!");
            throw new RuntimeException(ex);
        }
    }
}
