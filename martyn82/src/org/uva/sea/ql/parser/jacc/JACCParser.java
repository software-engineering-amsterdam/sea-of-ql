package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.parser.test.IParser;
import org.uva.sea.ql.parser.test.ParseError;

/**
 * JACC parser.
 */
public class JACCParser implements IParser {
	/**
	 * Parses given string.
	 * 
	 * @throws ParseError
	 */
	@Override
	public Expression parse( String src ) throws ParseError {
		QLLexer lexer = new QLLexer( new StringReader( src ) );
		lexer.nextToken();
		QLParser parser = new QLParser( lexer );
		
		if ( !parser.parse() ) {
			throw new ParseError( "error at: " + lexer.getToken() );
		}
		
		return parser.getResult();
	}
}
