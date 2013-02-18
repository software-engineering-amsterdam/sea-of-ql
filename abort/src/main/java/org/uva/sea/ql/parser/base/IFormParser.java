package org.uva.sea.ql.parser.base;

import java.io.*;

import org.uva.sea.ql.ast.form.Form;

/**
 * Interface for a parser for Forms.
 * 
 * @author J. Dijkstra
 */
public interface IFormParser {
	/**
	 * Retrieve a parsed from by its input file.
	 * 
	 * @param inputFile file to parse
	 * @return parsed form
	 * @throws ParsingException
	 */
	Form parseForm(File inputFile) throws ParsingException;
	
	/**
	 * Retrieve whether there are parsing errors or not.
	 * @return whether there are parsing errors or not
	 */
	boolean hasParsingErrors();
	
	/**
	 * Write error log to a stream.
	 * @param stream stream to write to
	 */
	void writeErrorLog(PrintStream stream); 
}
