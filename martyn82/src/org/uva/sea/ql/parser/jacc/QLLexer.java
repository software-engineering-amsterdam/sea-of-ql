package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Ident;

/**
 * Lexer class.
 */
public class QLLexer implements QLTokens {
	/**
	 * Keyword map.
	 */
	private static final Map<String, Integer> KEYWORDS;

	/**
	 * Initializes the keyword mapping.
	 */
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put( "true", BOOL );
		KEYWORDS.put( "false", BOOL );
		KEYWORDS.put( "if", IF );
	}

	/**
	 * Holds the current token.
	 */
	private int token;
	
	/**
	 * Holds the current character code.
	 */
	private int c = ' ';

	/**
	 * Holds the current AST node.
	 */
	private ASTNode yylval;
	
	/**
	 * Holds the input reader.
	 */
	private final Reader input;
	
	/**
	 * Holds the regular expression pattern for decimals.
	 */
	private Pattern decimal;
	
	/**
	 * Holds the regular expression pattern for integers.
	 */
	private Pattern integer;

	/**
	 * Constructs a new QLLexer instance.
	 * 
	 * @param input The input reader.
	 */
	public QLLexer( Reader input ) {
		this.input = input;
	}

	/**
	 * Reads the next character.
	 */
	private void nextChar() {
		if ( c >= 0 ) {
			try {
				c = input.read();
			}
			catch ( IOException e ) {
				c = -1;
			}
		}
	}

	/**
	 * Computes and retrieves the next token.
	 * 
	 * @return The computed token.
	 */
	public int nextToken() {
		boolean inComment = false;
		
		for ( ;; ) {
			if ( inComment ) {
				while ( c != '*' && c != -1 ) {
					nextChar();
				}
				
				if ( c == '*' ) {
					nextChar();
					
					if ( c == '/' ) {
						nextChar();
						inComment = false;
					}
					continue;
				}
			}

			while ( c == ' ' || c == '\t' || c == '\n' || c == '\r' ) {
				nextChar();
			}

			if ( c < 0 ) {
				return token = ENDINPUT;
			}

			switch ( c ) {
				case '/': {
					nextChar();
					
					if ( c == '*' ) {
						inComment = true;
						nextChar();
						continue;
					}
					else if ( c == '/' ) {
						// single line comments
						nextChar();

						while ( c >= ENDINPUT && c != '\r' && c != '\n' ) {
							nextChar();
						}
						
						continue;
					}
					
					return token = '/';
				}
				
				case ')':
					nextChar();
					return token = ')';
				
				case '(':
					nextChar();
					return token = '(';
				
				case '*': {
					nextChar();
					
					if ( inComment && c == '/' ) {
						inComment = false;
						nextChar();
						continue;
					}
					
					return token = '*';
				}
				
				case '+':
					nextChar();
					return token = '+';
				
				case '-':
					nextChar();
					return token = '-';
				
				case '&': {
					nextChar();
					
					if ( c == '&' ) {
						nextChar();
						return token = AND;
					}
					
					throw new RuntimeException( "Unexpected character: " + (char) c );
				}
				
				case '|': {
					nextChar();
				
					if ( c == '|' ) {
						nextChar();
						return token = OR;
					}
				
					throw new RuntimeException( "Unexpected character: " + (char) c );
				}
				
				case '!':
					nextChar();
				
					if ( c == '=' ) {
						nextChar();
						return token = NEQ;
					}
				
					return token = '!';
				
				case '<': {
					nextChar();
				
					if ( c == '=' ) {
						nextChar();
						return token = LEQ;
					}
				
					return '<';
				}
				
				case '=': {
					nextChar();
				
					if ( c == '=' ) {
						nextChar();
						return token = EQ;
					}
				
					throw new RuntimeException( "Unexpected character: " + (char) c );
				}
				
				case '>': {
					nextChar();
				
					if ( c == '=' ) {
						nextChar();
						return token = GEQ;
					}
				
					return token = '>';
				}
				
				case '"': {
					if ( this.matchString() ) {
						return token = STR;
					}
				}
				
				default: {
					if ( this.matchNumber() ) {
						return token;
					}
					
					if ( this.matchToken() ) {
						return token;
					}
				
					throw new RuntimeException( "Unexpected character: " + (char) c );
				}
			}
		}
	}
	
	/**
	 * Matches a string literal.
	 * 
	 * @return True if string, false otherwise.
	 */
	private boolean matchString() {
		StringBuilder sb = new StringBuilder();
		boolean inString = true;
		
		while ( inString ) {
			nextChar();
			
			if ( c < ENDINPUT ) {
				throw new RuntimeException( "Unterminated string literal" );
			}
			else if ( c == '"' ) {
				inString = false;
			}
			else if ( c == '\\' ) {
				nextChar();
				sb.append( this.getEscapedChar( (char) c ) );
			}
			else {
				sb.append( (char) c );
			}
		}

		nextChar();

		yylval = new org.uva.sea.ql.ast.expression.value.Str( sb.toString() );
		return true;
	}
	
	/**
	 * Unescapes an escaped character within a string literal.
	 * 
	 * @param input Character to unescape.
	 * 
	 * @return The unescaped character.
	 */
	private char getEscapedChar( char input ) {
		switch ( input ) {
			// whitespace
			case 'n':
				return '\n';
				
			case 'r':
				return '\r';
				
			case 't':
				return '\t';
				
			case 'b':
				return '\b';
				
			case 'f':
				return '\f';
				
			case '\'':
				return '\'';
				
			case '"':
				return '"';
				
			case '\\':
				return '\\';
		}
		
		throw new RuntimeException( "Unrecognized escape sequence" );
	}
		
	/**
	 * Matches a number literal.
	 * 
	 * @return True if integer, false otherwise.
	 */
	private boolean matchNumber() {
		if ( !Character.isDigit( c ) && c != '.' ) {
			return false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		do {
			sb.append( (char) c );
			nextChar();
		}
		while (
			Character.isDigit( c )
			|| c == 'e'
			|| c == 'E'
			|| c == '.'
			|| c == '-'
			|| c == '+'
		);
		
		String value = sb.toString();
		
		if ( this.decimal == null ) {
			this.decimal = Pattern.compile( "[0-9]*\\.[0-9]+([E|e][\\+|\\-]?[0-9]+)?" );
		}
		
		if ( decimal.matcher( value ).matches() ) {
			yylval = new org.uva.sea.ql.ast.expression.value.Money( Double.parseDouble( value ) );
			token = MON;
			return true;
		}
		
		if ( this.integer == null ) {
			this.integer = Pattern.compile( "[0-9]+" );
		}
		
		if ( integer.matcher( value ).matches() ) {
			yylval = new org.uva.sea.ql.ast.expression.value.Int( Integer.parseInt( value ) );
			token = INT;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Matches arbitrary token.
	 * 
	 * @return True if successful, false otherwise.
	 */
	private boolean matchToken() {
		StringBuilder sb = new StringBuilder();
		
		do {
			sb.append( (char) c );
			nextChar();
		}
		while ( Character.isLetterOrDigit( c ) );

		String name = sb.toString();

		if ( KEYWORDS.containsKey( name ) ) {
			token = KEYWORDS.get( name );
			
			switch ( token ) {
				case BOOL: 
					yylval = new org.uva.sea.ql.ast.expression.value.Bool(
						Boolean.parseBoolean( name )
					);
					break;
				
			}

			return true;
		}

		yylval = new Ident( name );
		token = IDENT;
		
		return true;
	}

	/**
	 * Returns the current token.
	 * 
	 * @return The current token.
	 */
	public int getToken() {
		return token;
	}

	/**
	 * Returns the current AST.
	 * 
	 * @return The AST.
	 */
	public ASTNode getSemantic() {
		return yylval;
	}
}
