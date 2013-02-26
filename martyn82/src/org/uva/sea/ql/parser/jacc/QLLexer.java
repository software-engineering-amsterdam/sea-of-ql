package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;

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
		if ( this.c >= 0 ) {
			try {
				this.c = this.input.read();
				this.column++;

				if ( this.c == '\n' ) {
					this.line++;
					this.column = 1;
				}
			}
			catch ( IOException e ) {
				this.c = -1;
			}
		}
	}

	public int nextToken() {
		boolean inComment = false;

		while ( true ) {
			if ( inComment ) {
				while ( this.c != '*' && this.c != -1 ) {
					this.nextChar();
				}

				if ( this.c == '*' ) {
					this.nextChar();

					if ( this.c == '/' ) {
						this.nextChar();
						inComment = false;
					}
					continue;
				}
			}

			while ( this.c == ' ' || this.c == '\t' || this.c == '\n' || this.c == '\r' ) {
				this.nextChar();
			}

			if ( this.c < 0 ) {
				return this.token = ENDINPUT;
			}

			switch ( this.c ) {
				case '/': {
					this.nextChar();

					if ( this.c == '*' ) {
						inComment = true;
						this.nextChar();
						continue;
					}
					else if ( this.c == '/' ) {
						// single line comments
						this.nextChar();

						while ( this.c >= ENDINPUT && this.c != '\r' && this.c != '\n' ) {
							this.nextChar();
						}

						continue;
					}

					return this.token = '/';
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
					this.token = this.c;
					this.nextChar();
					return this.token;

				case '*': {
					this.nextChar();

					if ( inComment && this.c == '/' ) {
						inComment = false;
						this.nextChar();
						continue;
					}

					return this.token = '*';
				}

				case '&': {
					this.nextChar();

					if ( this.c == '&' ) {
						this.nextChar();
						return this.token = AND;
					}

					throw new RuntimeException( "Unexpected character: " + (char) this.c );
				}

				case '|': {
					this.nextChar();

					if ( this.c == '|' ) {
						this.nextChar();
						return this.token = OR;
					}

					throw new RuntimeException( "Unexpected character: " + (char) this.c );
				}

				case '!':
					this.nextChar();

					if ( this.c == '=' ) {
						this.nextChar();
						return this.token = NEQ;
					}

					return this.token = '!';

				case '<': {
					this.nextChar();

					if ( this.c == '=' ) {
						this.nextChar();
						return this.token = LEQ;
					}

					return '<';
				}

				case '=': {
					this.nextChar();

					if ( this.c == '=' ) {
						this.nextChar();
						return this.token = EQ;
					}
					else {
						this.nextChar();
						return this.token = '=';
					}
				}

				case '>': {
					this.nextChar();

					if ( this.c == '=' ) {
						this.nextChar();
						return this.token = GEQ;
					}

					return this.token = '>';
				}

				case '"': {
					if ( this.matchString() ) {
						return this.token;
					}
				}

				default: {
					if ( this.matchNumber() ) {
						return this.token;
					}

					if ( this.matchWord() ) {
						return this.token;
					}

					throw new RuntimeException( "Unexpected character: " + (char) this.c );
				}
			}
		}
	}

	private boolean matchString() {
		StringBuilder sb = new StringBuilder();
		boolean inString = true;

		this.nextChar(); // go around the string boundaries (")

		while ( inString ) {
			if ( this.c < ENDINPUT ) {
				throw new RuntimeException( "Unterminated string literal" );
			}
			else if ( this.c == '"' ) {
				inString = false;
			}
			else if ( this.c == '\\' ) {
				this.nextChar();
				sb.append( this.getEscapedChar( (char) this.c ) );
			}
			else {
				sb.append( (char) this.c );
			}

			this.nextChar();
		}

		this.yylval = new StringLiteral( sb.toString() );
		this.token = STR;

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
		if ( !Character.isDigit( this.c ) ) {
			return false;
		}

		StringBuilder sb = new StringBuilder();

		do {
			sb.append( (char) this.c  );
			this.nextChar();
		}
		while ( Character.isDigit( (char) this.c ) );

		String value = sb.toString();

		if ( this.integer.matcher( value ).matches() ) {
			this.yylval = new IntegerLiteral( Integer.parseInt( value ) );
			this.token = INT;
			return true;
		}

		return false;
	}

	private boolean matchNumber() {
		if ( !Character.isDigit( this.c ) && this.c != '.' ) {
			return this.matchInteger();
		}

		StringBuilder sb = new StringBuilder();

		boolean separator = false;
		boolean exponent = false;
		boolean sign = false;
		boolean isDecimal = false;

		do {
			if ( this.c == '.' && !separator ) {
				isDecimal = true;
				separator = true;
			}
			else if ( this.c == '.' && separator ) {
				break;
			}

			if ( ( this.c == 'e' || this.c == 'E' ) && !exponent ) {
				exponent = true;
			}
			else if ( ( this.c == 'e' || this.c == 'E' ) && exponent ) {
				break;
			}

			if ( ( this.c == '+' || this.c == '-' ) && exponent && !sign ) {
				sign = true;
			}
			else if ( ( this.c == '+' || this.c == '-' ) && ( sign || !exponent ) ) {
				break;
			}

			sb.append( (char) this.c );
			this.nextChar();
		}
		while (
			Character.isDigit( this.c )
			|| this.c == 'e'
			|| this.c == 'E'
			|| this.c == '.'
			|| this.c == '-'
			|| this.c == '+'
		);

		String value = sb.toString();

		if ( isDecimal && this.decimal.matcher( value ).matches() ) {
			this.yylval = new MoneyLiteral( Double.parseDouble( value ) );
			this.token = MON;
			return true;
		}

		if ( this.integer.matcher( value ).matches() ) {
			this.yylval = new IntegerLiteral( Integer.parseInt( value ) );
			this.token = INT;
			return true;
		}

		return false;
	}

	private boolean matchWord() {
		if ( !Character.isLetter( this.c ) && this.c != '_' ) {
			return false;
		}

		StringBuilder sb = new StringBuilder();

		do {
			sb.append( (char) this.c );
			this.nextChar();
		}
		while ( Character.isLetterOrDigit( this.c ) || this.c == '_' );

		String name = sb.toString();

		if ( KEYWORDS.containsKey( name ) ) {
			this.token = KEYWORDS.get( name );
			return true;
		}

		this.yylval = new IdentifierExpression( name );
		this.token = IDENT;

		return true;
	}

	public int getToken() {
		return this.token;
	}

	public Node getSemantic() {
		return this.yylval;
	}

	public int getColumn() {
		return this.column;
	}

	public int getLineNumber() {
		return this.line;
	}
}
