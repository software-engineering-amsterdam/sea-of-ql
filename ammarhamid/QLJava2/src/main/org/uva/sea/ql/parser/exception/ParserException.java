package org.uva.sea.ql.parser.exception;

public class ParserException extends RuntimeException
{
	public ParserException()
	{
		super();
	}

	public ParserException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

	public ParserException(String message)
	{
		super(message);
	}

	public ParserException(Throwable throwable)
	{
		super(throwable);
	}
	
}
