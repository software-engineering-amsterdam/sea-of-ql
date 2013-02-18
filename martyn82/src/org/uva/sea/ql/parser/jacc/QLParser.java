package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.ParseError;

public class QLParser implements Parser {
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
