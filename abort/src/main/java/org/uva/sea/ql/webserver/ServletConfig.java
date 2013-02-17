package org.uva.sea.ql.webserver;

import java.util.*;

import javax.ws.rs.ext.*;

import org.codehaus.jackson.jaxrs.*;
import org.uva.sea.ql.webserver.services.BootstrapService;

import com.google.inject.*;
import com.google.inject.servlet.*;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class ServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                /* bind the REST resources */
                bind(BootstrapService.class);

                /* bind jackson converters for JAXB/JSON serialization */
                bind(JacksonJaxbJsonProvider.class).in(Singleton.class);
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
                Map<String, String> initParams = new HashMap<String, String>();
                initParams.put("com.sun.jersey.config.feature.Trace", "true");
                
                serve("*").with(GuiceContainer.class, initParams);
            }
        });
	}

}