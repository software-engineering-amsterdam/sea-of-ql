package org.uva.sea.ql.web.configuration;

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
import org.uva.sea.ql.booting.QLProgram;
import org.uva.sea.ql.general.SymbolTableImpl;
import org.uva.sea.ql.web.FormPersistenceController;
import org.uva.sea.ql.web.ValidationController;
import org.uva.sea.ql.web.WebappIndexController;
import org.uva.sea.ql.web.inputvalidation.QLInputValidator;
import org.uva.sea.ql.web.inputvalidation.QuestionValidator;

import java.io.IOException;

public class ServletConfiguration extends GuiceServletContextListener {

    private final QLProgram qlProgram;
    private final SymbolTableImpl symbolTable;
    private final ObjectMapper objectMapper;

    public ServletConfiguration(QLProgram qlProgram, SymbolTableImpl symbolTable) throws IOException {
        this.qlProgram = qlProgram;
        this.symbolTable = symbolTable;
        this.objectMapper = createObjectMapper();
    }

    @Override
    protected Injector getInjector() {
        ServletModule qlServletModule = new QLServletModule();
        return Guice.createInjector(qlServletModule);
    }

    private ObjectMapper createObjectMapper() {
        SimpleModule module = new SimpleModule("QLModule", Version.unknownVersion());
        return new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY).withModule(module);
    }

    private class QLServletModule extends ServletModule {

        @Override
        protected void configureServlets() {
            bind(WebappIndexController.class);
            bind(ValidationController.class);
            bind(FormPersistenceController.class);
            bind(QLProgram.class).toInstance(qlProgram);
            bind(SymbolTableImpl.class).toInstance(symbolTable);
            bind(ObjectMapper.class).toInstance(objectMapper);
            bind(QLInputValidator.class).to(QuestionValidator.class);
            serve("*").with(GuiceContainer.class);
        }
    }
}
