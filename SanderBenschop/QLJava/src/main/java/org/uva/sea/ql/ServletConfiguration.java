package org.uva.sea.ql;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;
import org.uva.sea.ql.web.FormPersistenceController;
import org.uva.sea.ql.web.GeneratedCodeController;
import org.uva.sea.ql.web.ValidationController;

public class ServletConfiguration extends GuiceServletContextListener {

    private SymbolTable symbolTable;
    private ObjectMapper objectMapper;

    public ServletConfiguration(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.objectMapper = createObjectMapper();
    }

    @Override
    protected Injector getInjector() {
        ServletModule qlServletModule = new QLServletModule();
        return Guice.createInjector(qlServletModule);
    }

    private ObjectMapper createObjectMapper() {
        SimpleModule module = new SimpleModule("QLModule", new Version(1, 0, 0, ""));
        return new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY).withModule(module);
    }

    private class QLServletModule extends ServletModule {

        @Override
        protected void configureServlets() {
            bind(GeneratedCodeController.class);
            bind(ValidationController.class);
            bind(FormPersistenceController.class);
            bind(SymbolTable.class).toInstance(symbolTable);
            bind(ObjectMapper.class).toInstance(objectMapper);
            serve("*").with(GuiceContainer.class);
        }
    }
}
