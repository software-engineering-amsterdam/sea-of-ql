package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.uva.sea.ql.ast.INode;
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
		KEYWORDS.put( "else", ELSE );
		KEYWORDS.put( "boolean", BOOLEAN  );
		KEYWORDS.put( "integer", INTEGER );
		KEYWORDS.put( "string", STRING );
		KEYWORDS.put( "money", MONEY );
		KEYWORDS.put( "form", FORM );
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
	 * Holds current column number.
	 */
	private int column;

	/**
	 * Holds current line number.
	 */
	private int line;

	/**
	 * Holds the current AST node.
	 */
	private INode yylval;

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
	 * Constructs a new lexer instance.
	 *
	 * @param input The input reader.
	 */
	public QLLexer( Reader input ) {
		this.input = input;
		this.column = 0;
		this.line = 1;
	}

	/**
	 * Reads the next character into field c.
	 * On end of input or failure, c will be -1.
	 */
	private void nextChar() {
		if ( c >= 0 ) {
			try {
				c = input.read();

				if ( c == '\n' ) {
					line++;
					column = 0;
				}
				else if ( c > 0 ) {
					column++;
				}
			}
			catch ( IOException e ) {
				c = -1;
			}
		}
	}

	/**
	 * Retrieves the next token based on previously read character.
	 *
	 * @return The token.
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
				case '(':
				case '{':
				case '}':
				case ':':
				case ';':
				case '+':
				case '-':
				case '^':
					token = c;
					nextChar();
					return token;

				case '*': {
					nextChar();

					if ( inComment && c == '/' ) {
						inComment = false;
						nextChar();
						continue;
					}

					return token = '*';
				}

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
					else {
						nextChar();
						return token = '=';
					}
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
						return token;
					}
				}

				default: {
					if ( this.matchNumber() ) {
						return token;
					}

					if ( this.matchWord() ) {
						return token;
					}

					throw new RuntimeException( "Unexpected character: " + (char) c );
				}
			}
		}
	}

	/**
	 * Matches a string literal and updates the token field.
	 *
	 * @return True if string, false otherwise.
	 */
	private boolean matchString() {
		StringBuilder sb = new StringBuilder();
		boolean inString = true;

		nextChar(); // go around the string boundaries (")

		while ( inString ) {
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

			nextChar();
		}

		yylval = new org.uva.sea.ql.ast.expression.value.Str( sb.toString() );
		token = STR;

		return true;
	}

	/**
	 * Retrieves an escaped character within a string literal.
	 *
	 * @param input The escaped character.
	 *
	 * @return The un-escaped character.
	 *
	 * @throws RuntimeException if escaped character is invalid.
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

			// others
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
	 * Matches a number literal and updates the token field.
	 * This matches any number of Integer or Money types.
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
	 * Matches a keyword or identifier token and updates the token field accordingly on success.
	 *
	 * @return True if successful, false otherwise.
	 */
	private boolean matchWord() {
		if ( !Character.isLetter( c ) ) {
			return false;
		}

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
	 * Returns the most recent identified token.
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
	public INode getSemantic() {
		return yylval;
	}

	/**
	 * Retrieves the current column number on the current line.
	 *
	 * @return Column number.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Retrieves the current line number.
	 *
	 * @return Line number.
	 */
	public int getLineNumber() {
		return line;
	}
}
