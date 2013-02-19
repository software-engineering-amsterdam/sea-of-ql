package org.uva.sea.ql;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.uva.sea.ql.bootstrapping.QLBootstrapper;
import org.uva.sea.ql.bootstrapping.QLBootstrapperImpl;
import org.uva.sea.ql.bootstrapping.QLProgram;
import org.uva.sea.ql.parsing.ANTLRParser;
import org.uva.sea.ql.parsing.Parser;
import org.uva.sea.ql.parsing.error.reporting.SyntacticErrorReporterImpl;
import org.uva.sea.ql.codegeneration.CodeGenerator;
import org.uva.sea.ql.codegeneration.WebAppCodeGeneratingVisitor;
import org.uva.sea.ql.semanticanalysis.SemanticAnalysisVisitor;
import org.uva.sea.ql.semanticanalysis.SemanticalAnalyser;
import org.uva.sea.ql.semanticanalysis.SymbolTable;
import org.uva.sea.ql.semanticanalysis.SymbolTableImpl;
import org.uva.sea.ql.web.configuration.ServletConfiguration;

import javax.servlet.DispatcherType;
import java.io.IOException;
import java.util.EnumSet;
import java.util.logging.Logger;

public class Main {

    private static final String WEBAPP_BASE_PATH = "/ql";
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] arguments) {
        QLCommandLineParameters commandLineParameters = new QLCommandLineParameters();
        JCommander jCommander = new JCommander(commandLineParameters);
        SymbolTable symbolTable = new SymbolTableImpl();
        QLBootstrapper bootstrapper = createQLBootStrapper(symbolTable);
        try {
            jCommander.parse(arguments);
            QLProgram qlProgram = bootstrapper.bootstrapQLProgram(commandLineParameters.getInputFile());
            if (qlProgram.isCorrect()) {
                startJettyServer(qlProgram, commandLineParameters.getHostPort(), symbolTable);
            }
        } catch (ParameterException exception) {
            LOGGER.severe("Error starting up QL, use this interpreter with the following command line options and make sure the file is present:");
            jCommander.usage();
        } catch (IOException e) {
            LOGGER.severe("Exception occured during the startup of the code: ");
            throw new RuntimeException(e);
        }
    }

    private static QLBootstrapper createQLBootStrapper(SymbolTable symbolTable) {
        Parser parser = new ANTLRParser(new SyntacticErrorReporterImpl());
        SemanticalAnalyser semanticalAnalyser = new SemanticAnalysisVisitor(symbolTable);
        CodeGenerator codeGenerator = new WebAppCodeGeneratingVisitor();
        return new QLBootstrapperImpl(parser, semanticalAnalyser, codeGenerator);
    }

    private static void startJettyServer(QLProgram qlProgram, int port, SymbolTable symbolTable) {
        try {
            Server server = new Server(port);

            WebAppContext staticResourcesHandler = new WebAppContext();
            staticResourcesHandler.setContextPath(WEBAPP_BASE_PATH + "/scripts");
            staticResourcesHandler.setBaseResource(Resource.newResource("src/main/webapp/WEB-INF/scripts"));

            ServletContextHandler servletsHandler = new ServletContextHandler();
            servletsHandler.setContextPath(WEBAPP_BASE_PATH);
            servletsHandler.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
            servletsHandler.addEventListener(new ServletConfiguration(qlProgram, symbolTable));
            servletsHandler.addServlet(new ServletHolder(new ServletContainer(new PackagesResourceConfig("org.uva.sea.ql.web"))), "/");

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
