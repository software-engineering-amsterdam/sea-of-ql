package org.uva.sea.ql.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.CodeLocationInformationImpl;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.StringLiteral;

/**
 * @author Bastiaan.Brekelmans
 * 
 */
class Lexer implements Tokens {
	private static final Map<String, Integer> KEYWORDS;

	// define keywords
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("if", IF);
		KEYWORDS.put("else", ELSE);
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("true", TRUE);
		KEYWORDS.put("false", FALSE);
		KEYWORDS.put("bool", BOOLEAN);
		KEYWORDS.put("int", INTEGER);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("string", STRING);
	}

	// last token
	private int token;
	// current character
	private int c = ' ';
	// current line number
	private int line = 1;
	// current position in line
	private int column = 1;
	// current file name
	private final String fileName;
	// latest token recovered
	private Node yylval;
	private final Reader input;

	public Lexer(final Reader input, final String fileName) {
		this.input = input;
		this.fileName = fileName;
	}

	private void error(final String msg) {
		throw new ParseError(this.line, this.column, this.fileName, msg);
	}

	private char getEscapedChar(final int c) {
		switch (c) {
		case 't':
			return '\t';
		case 'n':
			return '\n';
		case 'r':
			return '\r';
		case 'b':
			return '\b';
		case 'f':
			return '\f';

		case '\'':
		case '"':
		case '\\':
			return (char) c;

		default:
			// unrecognized escape sequence
			// show the character itself.
			return (char) c;
		}
	}

	private int getIdentifierOrKeyword() {
		final StringBuilder sb = new StringBuilder();
		do {
			sb.append((char) this.c);
			this.nextChar();
		} while (Character.isLetterOrDigit(this.c) || this.c == '_');
		final String name = sb.toString();
		if (KEYWORDS.containsKey(name)) {
			return this.token = KEYWORDS.get(name);
		}
		this.yylval = new Identifier(this.location(), name);
		return this.token = IDENTIFIER;
	}

	private int getNumber() {
		final StringBuilder builder = new StringBuilder();
		double numberLiteral;
		boolean isFloat = false;
		do {
			isFloat |= this.c == '.' || this.c == 'e' || this.c == 'E';
			builder.append((char) this.c);
			// if E then we can have a - or + as next char
			if (this.c == 'E' || this.c == 'e') {
				this.nextChar();
				if (this.c == '-' || this.c == '+' || Character.isDigit(this.c)) {
					builder.append((char) this.c);
					this.nextChar();
					continue;
				} else {
					break;
				}
			} else {
				this.nextChar();
			}
		} while (Character.isDigit(this.c) || this.c == '.' || this.c == 'E'
				|| this.c == 'e');
		numberLiteral = Double.parseDouble(builder.toString());
		if (isFloat || numberLiteral > Long.MAX_VALUE) {
			// number is real (money)
			this.yylval = new MoneyLiteral(this.location(), numberLiteral);

		} else {
			// number is integer
			this.yylval = new IntegerLiteral(this.location(),
					(long) numberLiteral);
		}
		return this.token = NUMBERLITERAL;
	}

	public Node getSemantic() {
		return this.yylval;
	}

	private int getStringLiteral() {
		this.nextChar();
		final StringBuilder builder = new StringBuilder();
		boolean inString = true;
		while (inString) {
			if (this.c == '"') {
				inString = false;
			} else if (this.c == '\\') {
				this.nextChar();
				builder.append(this.getEscapedChar(this.c));
			} else {
				builder.append((char) this.c);
			}
			this.nextChar();
		}
		this.yylval = new StringLiteral(this.location(), builder.toString());
		return this.token = STRINGLITERAL;
	}

	public int getToken() {
		return this.token;
	}

	/**
	 * @return An immutable object containing line number, column and file name
	 *         information.
	 */
	public ICodeLocationInformation location() {
		return new CodeLocationInformationImpl(this.line, this.column,
				this.fileName);
	}

	/**
	 * Move to next character position. Alters the field 'c' and updates
	 * line/column numbers if required. c becomes -1 if the end of input is
	 * reached.
	 */
	private void nextChar() {
		if (this.c >= 0) {
			try {
				if (this.c == '\n') {
					this.line++;
					this.column = 0;
				}
				this.c = this.input.read();
				this.column++;
			} catch (final IOException e) {
				this.c = -1;
			}
		}
	}

	public int nextToken() {
		boolean inComment = false;
		while (true) {
			// skip through to end of comment if we are in a comment.
			if (inComment) {
				while (this.c != '*' && this.c != -1) {
					this.nextChar();
				}
				if (this.c == '*') {
					this.nextChar();
					if (this.c == '/') {
						this.nextChar();
						inComment = false;
					}
					continue;
				}
			}

			// skip whitespace
			while (Character.isWhitespace(this.c)) {
				this.nextChar();
			}

			// check for end of input
			if (this.c < 0 || this.c == 65535) {
				return this.token = ENDINPUT;
			}

			switch (this.c) {
			case '/': {
				// division or start of comment.
				this.nextChar();
				if (this.c == '*') {
					inComment = true;
					this.nextChar();
					continue;
				}
				return this.token = '/';
			}
			case '"': {
				return this.getStringLiteral();
			}
			case ')':
				this.nextChar();
				return this.token = ')';
			case '(':
				this.nextChar();
				return this.token = '(';
			case '{':
				this.nextChar();
				return this.token = '{';
			case '}':
				this.nextChar();
				return this.token = '}';
			case '*': {
				this.nextChar();
				if (inComment && this.c == '/') {
					inComment = false;
					this.nextChar();
					continue;
				}
				return this.token = '*';
			}
			case ':':
				this.nextChar();
				return this.token = ':';
			case '+':
				this.nextChar();
				return this.token = '+';
			case '-':
				this.nextChar();
				return this.token = '-';
			case '&': {
				this.nextChar();
				if (this.c == '&') {
					this.nextChar();
					return this.token = AND;
				}
				this.error("Unexpected character: " + (char) this.c);
			}
			case '|': {
				this.nextChar();
				if (this.c == '|') {
					this.nextChar();
					return this.token = OR;
				}
				this.error("Unexpected character: " + (char) this.c);
			}
			case '^':
				this.nextChar();
				return this.token = '^';
			case '!':
				this.nextChar();
				if (this.c == '=') {
					this.nextChar();
					return this.token = NEQ;
				}
				return this.token = '!';
			case '<': {
				this.nextChar();
				if (this.c == '=') {
					this.nextChar();
					return this.token = LEQ;
				}
				return this.token = '<';
			}
			case '=': {
				this.nextChar();
				if (this.c == '=') {
					this.nextChar();
					return this.token = EQ;
				}
				return this.token = '=';
			}
			case '>': {
				this.nextChar();
				if (this.c == '=') {
					this.nextChar();
					return this.token = GEQ;
				}
				return this.token = '>';
			}
			default: {
				if (Character.isDigit(this.c) || this.c == '.') {
					return this.getNumber();
				}
				if (Character.isLetter(this.c) || this.c == '_') {
					return this.getIdentifierOrKeyword();
				}
				this.error("Unexpected character: " + (char) this.c);
			}
			}
		}
	}

}
