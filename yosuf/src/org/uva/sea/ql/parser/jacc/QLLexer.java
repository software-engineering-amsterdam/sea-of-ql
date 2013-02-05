package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public class QLLexer implements QLTokens {

	private static final int ERROR_CHAR = -1;
	private static final Map<String, Integer> KEYWORDS;

	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("if", IF);
		KEYWORDS.put("Boolean", BOOL);
		KEYWORDS.put("String", STR);
		KEYWORDS.put("Integer", INT);
		KEYWORDS.put("Money", MON);
		KEYWORDS.put("BooleanValue", BOOL_VAL);
		KEYWORDS.put("MoneyValue", MON_VAL);
	}

	private int token;
	private int c = ' ';

	private ASTNode yylval;
	private final Reader input;

	public QLLexer(final Reader input) {
		this.input = input;
		nextChar();
	}

	private void nextChar() {
		if (c >= 0) {
			try {
				c = input.read();
			} catch (IOException e) {
				c = ERROR_CHAR;
			}
		}

	}

	public int nextToken() {
		boolean inComment = false;
		for (;;) {
			if (inComment) {
				while (c != '*' && c != ERROR_CHAR) {
					nextChar();
				}
				if (c == '*') {
					nextChar();
					if (c == '/') {
						nextChar();
						inComment = false;
					}
					continue;
				}
			}

			while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
				nextChar();
			}

			if (c < 0) {
				return token = ENDINPUT;
			}

			switch (c) {
			case '/': {
				nextChar();
				if (c == '*') {
					inComment = true;
					nextChar();
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
			case '{':
				nextChar();
				return token = '{';
			case '}':
				nextChar();
				return token = '}';
			case ';':
				nextChar();
				return token = ';';

			case '*': {
				nextChar();
				if (inComment && c == '/') {
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
				if (c == '&') {
					nextChar();
					return token = AND;
				}
				throw new RuntimeException("Unexpected character: " + (char) c);
			}
			case '|': {
				nextChar();
				if (c == '|') {
					nextChar();
					return token = OR;
				}
				throw new RuntimeException("Unexpected character: " + (char) c);
			}
			case '!':
				nextChar();
				return token = '!';
			case '<': {
				nextChar();
				if (c == '=') {
					nextChar();
					return token = LEQ;
				}
				return '<';
			}
			case '=': {
				nextChar();
				if (c == '=') {
					nextChar();
					return token = EQ;
				}
				return token = '=';
			}
			case '>': {
				nextChar();
				if (c == '=') {
					nextChar();
					return token = GEQ;
				}
				return token = '>';
			}
			/*
			 * String literal
			 */
			case '\"': {
				nextChar();
				StringBuilder sb = new StringBuilder();
				do {
					sb.append((char) c);
					nextChar();

					if (c == ERROR_CHAR) {
						throw new RuntimeException(
								"String literal ended unexpectedly: "
										+ (char) c);
					}

				} while (c != '\"' && c != ERROR_CHAR);

				nextChar();

				yylval = new StringValue(sb.toString());
				return token = STRING_VAL;
			}

			default: {

				if (Character.isDigit(c)) {
					int n = 0;
					do {
						n = 10 * n + (c - '0');
						nextChar();
					} while (Character.isDigit(c));
					yylval = new IntegerValue(n);
					return token = INT_VAL;
				}

				if (Character.isLetter(c)) {
					StringBuilder sb = new StringBuilder();
					do {
						sb.append((char) c);
						nextChar();
					} while (Character.isLetterOrDigit(c));
					String name = sb.toString();
					if (KEYWORDS.containsKey(name)) {
						return token = KEYWORDS.get(name);
					}
					yylval = new Identifier(name);
					return token = IDENT;
				}
				throw new RuntimeException("Unexpected character: " + (char) c);
			}
			}
		}
	}

	public int getToken() {
		return token;
	}

	public ASTNode getSemantic() {
		return yylval;
	}

}
