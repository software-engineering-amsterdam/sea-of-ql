package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expression.Expression;

/**
 * Parser interface.
 */
public interface IParser {
	/**
	 * Parses the given string.
	 * 
	 * @param src A string program.
	 * 
	 * @return The AST.
	 * 
	 * @throws ParseError
	 */
	Expression parse( String src ) throws ParseError;
}
