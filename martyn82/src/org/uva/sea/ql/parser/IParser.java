package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.statement.Statements;

/**
 * Parser interface.
 */
public interface IParser {
	/**
	 * Parses the given source string into an abstract syntax tree.
	 *
	 * @param src A string program.
	 *
	 * @return The root of the AST.
	 *
	 * @throws ParseError
	 */
	Statements parse( String src ) throws ParseError;
}
