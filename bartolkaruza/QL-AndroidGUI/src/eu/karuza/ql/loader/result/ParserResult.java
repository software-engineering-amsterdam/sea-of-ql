package eu.karuza.ql.loader.result;

import eu.karuza.ql.parser.ParserContext;

public class ParserResult extends LoaderResult {
	
	private ParserContext context;
	
	
	public ParserContext getContext() {
		return context;
	}
	public void setContext(ParserContext context) {
		this.context = context;
	}
	
	public boolean hasErrors() {
		return context.hasErrors();
	}

}
