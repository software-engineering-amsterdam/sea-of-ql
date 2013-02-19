package eu.karuza.ql.loader;

import eu.karuza.ql.QLFrontEndException;

public abstract class LoaderResult {
	
	private QLFrontEndException exception;
	
	public QLFrontEndException getException() {
		return exception;
	}
	public void setException(QLFrontEndException exception) {
		this.exception = exception;
	}

}
