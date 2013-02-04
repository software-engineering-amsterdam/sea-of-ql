package org.uva.sea.ql.service;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	private static final ParserService parserService = new ParserServiceImpl();
	
	public static ServiceFactory defaultFactory() {
		return instance;
	}
	
	public ParserService getParserService() {
		return parserService;
	}

}
