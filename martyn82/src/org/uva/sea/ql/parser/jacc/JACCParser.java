package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

/**
 * JACC parser.
 */
public class JACCParser implements IParser {

	@Override
	public Node parse( String src ) throws ParseError {
		QLLexer lexer = new QLLexer( new StringReader( src ) );
		QLParser parser = new QLParser( lexer );
		
		try {
			lexer.nextToken();
			
			if ( !parser.parse() ) {
				this.onSyntaxError(
					lexer.getToken(),
					lexer.getLineNumber(),
					lexer.getColumn()
				);
			}
		}
		catch ( RuntimeException e ) {
			this.onSyntaxError(
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
	 * @param token
	 * @param lineNumber
	 * @param columnNumber
	 * 
	 * @throws ParseError
	 */
	private void onSyntaxError( int token, int lineNumber, int columnNumber ) throws ParseError {
		throw new ParseError(
			String.format(
				"Syntax error near '%s' on line %d col %d",
				(char) token,
				lineNumber,
				columnNumber
			)
		);
	}
}
