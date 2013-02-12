package org.uva.sea.ql.service;

public class ServiceFactory {
	
	public static ParserService getParserService() {
		return new ParserServiceImpl();
	}

}
