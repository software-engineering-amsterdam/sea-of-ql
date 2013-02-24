package eu.karuza.ql.error;

public class ParseError extends Exception {
	private static final long serialVersionUID = 1L;

	public ParseError(String msg) {
		super(msg);
	}
	
	public ParseError(Throwable thr) {
		super(thr);
	}
}
