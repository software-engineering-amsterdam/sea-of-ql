package org.uva.sea.ql.parser.test;

import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
/**
 * Class: ParseError
 * @author Danny
 *
 */
public class ParseError extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	private List<RecognitionException> errors = new LinkedList<RecognitionException>();
	
	/**
	 * Constructor
	 * @param msg errormessage
	 */
	public ParseError(String msg) {
		super(msg);
	}
	/**
	 * Constructor
	 * @param exceptions - list with exceptions
	 */
	public ParseError(List<RecognitionException> exceptions){
		this.errors = exceptions;
	}
	
	/**
	 * getExceptions
	 * @return errors
	 */
	public List<RecognitionException> getExceptions(){
		return this.errors;
	}
	
}
