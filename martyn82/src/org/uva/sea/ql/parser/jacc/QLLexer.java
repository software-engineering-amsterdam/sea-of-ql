package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.IdentifierExpression;

class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;

	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put( "true", TRUE );
		KEYWORDS.put( "false", FALSE );
		KEYWORDS.put( "if", IF );
		KEYWORDS.put( "else", ELSE );
		KEYWORDS.put( "boolean", BOOLEAN  );
		KEYWORDS.put( "integer", INTEGER );
		KEYWORDS.put( "string", STRING );
		KEYWORDS.put( "money", MONEY );
		KEYWORDS.put( "form", FORM );
	}

	private int token;
	private int c = ' ';
	private int column;
	private int line;
	private Node yylval;
	private final Reader input;
	private final Pattern decimal = Pattern.compile( "[0-9]*\\.[0-9]+([E|e][\\+|\\-]?[0-9]+)?" );
	private final Pattern integer = Pattern.compile( "[0-9]+" );

	public QLLexer( Reader input ) {
		this.input = input;
		this.column = 0;
		this.line = 1;
	}

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

		yylval = new org.uva.sea.ql.ast.expression.literal.StringLiteral( sb.toString() );
		token = STR;

		return true;
	}

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

	private boolean matchInteger() {
		if ( !Character.isDigit( c ) ) {
			return false;
		}

		StringBuilder sb = new StringBuilder();

		do {
			sb.append( (char) c  );
			nextChar();
		}
		while ( Character.isDigit( (char) c ) );

		String value = sb.toString();

		if ( integer.matcher( value ).matches() ) {
			yylval = new org.uva.sea.ql.ast.expression.literal.IntegerLiteral( Integer.parseInt( value ) );
			token = INT;
			return true;
		}

		return false;
	}

	private boolean matchNumber() {
		if ( !Character.isDigit( c ) && c != '.' ) {
			return matchInteger();
		}

		StringBuilder sb = new StringBuilder();

		boolean separator = false;
		boolean exponent = false;
		boolean sign = false;
		boolean isDecimal = false;

		do {
			if ( c == '.' && !separator ) {
				isDecimal = true;
				separator = true;
			}
			else if ( c == '.' && separator ) {
				break;
			}

			if ( ( c == 'e' || c == 'E' ) && !exponent ) {
				exponent = true;
			}
			else if ( ( c == 'e' || c == 'E' ) && exponent ) {
				break;
			}

			if ( ( c == '+' || c == '-' ) && exponent && !sign ) {
				sign = true;
			}
			else if ( ( c == '+' || c == '-' ) && ( sign || !exponent ) ) {
				break;
			}

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

		if ( isDecimal && decimal.matcher( value ).matches() ) {
			yylval = new org.uva.sea.ql.ast.expression.literal.MoneyLiteral( Double.parseDouble( value ) );
			token = MON;
			return true;
		}

		if ( integer.matcher( value ).matches() ) {
			yylval = new org.uva.sea.ql.ast.expression.literal.IntegerLiteral( Integer.parseInt( value ) );
			token = INT;
			return true;
		}

		return false;
	}

	private boolean matchWord() {
		if ( !Character.isLetter( c ) && c != '_' ) {
			return false;
		}

		StringBuilder sb = new StringBuilder();

		do {
			sb.append( (char) c );
			nextChar();
		}
		while ( Character.isLetterOrDigit( c ) || c == '_' );

		String name = sb.toString();

		if ( KEYWORDS.containsKey( name ) ) {
			token = KEYWORDS.get( name );
			return true;
		}

		yylval = new IdentifierExpression( name );
		token = IDENT;

		return true;
	}

	public int getToken() {
		return token;
	}

	public Node getSemantic() {
		return yylval;
	}

	public int getColumn() {
		return column;
	}

	public int getLineNumber() {
		return line;
	}
}
