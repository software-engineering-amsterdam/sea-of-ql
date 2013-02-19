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
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.web.PersistenceController;
import org.uva.sea.ql.web.IndexController;
import org.uva.sea.ql.web.ValidationController;

import java.io.IOException;

public class ServletConfiguration extends GuiceServletContextListener {

    private final QLProgram qlProgram;
    private final ObjectMapper objectMapper;

    public ServletConfiguration(QLProgram qlProgram) throws IOException {
        this.qlProgram = qlProgram;
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
            bind(IndexController.class);
            bind(ValidationController.class);
            bind(PersistenceController.class);
            bind(QLProgram.class).toInstance(qlProgram);
            bind(SymbolTable.class).toInstance(qlProgram.getSymbolTable());
            bind(ObjectMapper.class).toInstance(objectMapper);
            serve("*").with(GuiceContainer.class);
        }
    }
}
