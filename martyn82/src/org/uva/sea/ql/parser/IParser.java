package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.statement.Statement;

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
	Statement parse( String src ) throws ParseError;
}
