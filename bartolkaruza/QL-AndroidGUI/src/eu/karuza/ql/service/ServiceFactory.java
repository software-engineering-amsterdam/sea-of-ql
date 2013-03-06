package eu.karuza.ql.service;

import eu.karuza.ql.service.impl.ConnectionService;
import eu.karuza.ql.service.impl.ParserService;

public class ServiceFactory {
	
	public static IParserService getParserService() {
		return new ParserService();
	}
	
	public static IConnectionService getConnectionService() {
		return new ConnectionService();
	}
}