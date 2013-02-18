package org.uva.sea.ql;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;
import org.uva.sea.ql.web.GeneratedCodeController;
import org.uva.sea.ql.web.ValidationController;

public class ServletConfiguration extends GuiceServletContextListener {

    private SymbolTable symbolTable;

    public ServletConfiguration(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    protected Injector getInjector() {
        ServletModule qlServletModule = new QLServletModule();
        return Guice.createInjector(qlServletModule);
    }

    private class QLServletModule extends ServletModule {

        @Override
        protected void configureServlets() {
            bind(GeneratedCodeController.class);
            bind(ValidationController.class);
            bind(SymbolTable.class).toInstance(symbolTable);
            serve("*").with(GuiceContainer.class);
        }
    }
}
