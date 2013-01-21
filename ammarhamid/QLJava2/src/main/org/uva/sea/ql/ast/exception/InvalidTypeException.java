package org.uva.sea.ql.ast.exception;

/**
 * Invalid type exception used for semantic analysis.
 * <p/>
 * Author: ammar.hamid
 * Date: 1/20/13 11:54 AM
 */
public class InvalidTypeException extends RuntimeException
{
    public InvalidTypeException()
    {
    }

    public InvalidTypeException(String message)
    {
        super(message);
    }

    public InvalidTypeException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
