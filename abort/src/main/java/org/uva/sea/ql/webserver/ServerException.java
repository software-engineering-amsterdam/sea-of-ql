package org.uva.sea.ql.webserver;

public class ServerException extends Exception {
	public ServerException(final Throwable exception) {
		super("Server Exception", exception);
	}
}
