package org.uva.sea.ql.ast.traversal.typechecking.base;

import java.io.PrintStream;

import org.uva.sea.ql.ast.form.Form;

/**
 * Interface for a type checker.
 * 
 * @author J. Dijkstra
 */
public interface ITypeChecker {
	/**
	 * Check whether a form contains errors or not.
	 * 
	 * @param form form to check
	 * @return whether errors are found (and stored in the instance) or not
	 */
	boolean checkFormErrors(final Form form);

	/**
	 * Retrieve amount of errors found.
	 * 
	 * @return error count
	 */
	int getErrorCount();
	
	/**
	 * Write error log to a stream.
	 * 
	 * @param stream stream to write error log to
	 */
	void writeErrorLog(final PrintStream stream);

	/**
	 * Retrieve the symbol table for input validation of generated code.
	 * 
	 * @return symbol table
	 */
	ISymbolTable getSymbolTable();
}
