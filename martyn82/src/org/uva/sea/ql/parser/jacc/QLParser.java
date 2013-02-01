package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

/**
 * JACC parser.
 */
public class QLParser implements IParser {

	@Override
	public Statement parse( String src ) throws ParseError {
		QLLexer lexer = new QLLexer( new StringReader( src ) );
		JACCParser parser = new JACCParser( lexer );

		try {
			lexer.nextToken();

			if ( !parser.parse() ) {
				this.onSyntaxError(
					"",
					lexer.getToken(),
					lexer.getLineNumber(),
					lexer.getColumn()
				);
			}
		}
		catch ( RuntimeException e ) {
			this.onSyntaxError(
				e.getMessage(),
				lexer.getToken(),
				lexer.getLineNumber(),
				lexer.getColumn()
			);
		}

		return parser.getResult();
	}

	/**
	 * Converts syntax error to parse error.
	 *
	 * @param message
	 * @param token
	 * @param lineNumber
	 * @param columnNumber
	 *
	 * @throws ParseError
	 */
	private void onSyntaxError( String message, int token, int lineNumber, int columnNumber ) throws ParseError {
		throw new ParseError(
			String.format(
				"Syntax error: \"%s\" near '%s' on line %d col %d",
				message,
				(char) token,
				lineNumber,
				columnNumber
			)
		);
	}
}
