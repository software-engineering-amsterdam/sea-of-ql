package org.uva.sea.ql.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.CodeLocationInformationImpl;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.StringLiteral;

/**
 * @author Bastiaan.Brekelmans
 *
 */
public class Lexer implements Tokens {
	private static final Map<String, Integer> KEYWORDS;

	//define keywords
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

	//last token
	private int token;
	//current character
	private int c = ' ';
	//current line number
	private int line = 1;
	//current position in line
	private int column = 1;
	//current file name
	private String fileName;
	//latest token recovered
	private Node yylval;
	private final Reader input;

	public Lexer(Reader input, String fileName) {
		this.input = input;
		this.fileName = fileName;
	}

	/**
	 * @return An immutable object containing line number, column and file name information.
	 */
	public ICodeLocationInformation location()
	{
		return new CodeLocationInformationImpl(line, column, fileName);
	}
	
	private void error(String msg)
	{
		throw new ParseError(line, column, fileName, msg);
	}
	
	
	/**
	 * Move to next character position. Alters the field 'c'
	 * and updates line/column numbers if required.
	 * c becomes -1 if the end of input is reached.
	 */
	private void nextChar() {
		if (c >= 0) {
			try {
				if (c == '\n')
				{
					line++;
					column = 0;
				}
				c = input.read();
				column++;
			} catch (IOException e) {
				c = -1;
			}
		}
	}

	public int nextToken() {
		boolean inComment = false;
		while (true) {
			//skip through to end of comment if we are in a comment.
			if (inComment) {
				while (c != '*' && c != -1) {
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

			//skip whitespace
			while (Character.isWhitespace(c)) {
				nextChar();
			}
			
			//check for end of input
			if (c < 0) {
				return token = ENDINPUT;
			}

			switch (c) {
			case '/': {
				//division or start of comment.
				nextChar();
				if (c == '*') {
					inComment = true;
					nextChar();
					continue;
				}
				return token = '/';
			}
			case '"': {
				return getStringLiteral();
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
			case '*': {
				nextChar();
				if (inComment && c == '/') {
					inComment = false;
					nextChar();
					continue;
				}
				return token = '*';
			}
			case ':':
				nextChar();
				return token = ':';
			case '+':
				nextChar();
				return token = '+';
			case '-':
				nextChar();
				return token = '-';
			case '&': {
				nextChar();
				if (c == '&') {
					return token = AND;
				}
				error("Unexpected character: " + (char)c);
			}
			case '|': {
				nextChar();
				if (c == '|') {
					return token = OR;
				}
				error("Unexpected character: " + (char) c);
			}
			case '^':
				nextChar();
				return token = '^';
			case '!':
				nextChar();
				if (c == '=') {
					nextChar();
					return token = NEQ;
				}
				return token = '!';
			case '<': {
				nextChar();
				if (c == '=') {
					nextChar();
					return token = LEQ;
				}
				return token = '<';
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
			default: {
				if (Character.isDigit(c) || c == '.') {
					return getNumber();
				}
				if (Character.isLetter(c) || c == '_') {
					return getIdentifierOrKeyword();
				}
				error("Unexpected character: " + (char) c);
			}
			}
		}
	}

	private int getIdentifierOrKeyword() {
		StringBuilder sb = new StringBuilder();
		do {
			sb.append((char) c);
			nextChar();
		} while (Character.isLetterOrDigit(c) || c == '_');
		String name = sb.toString();
		if (KEYWORDS.containsKey(name)) {
			return token = KEYWORDS.get(name);
		}
		yylval = new Identifier(location(), name);
		return token = IDENTIFIER;
	}

	private int getNumber() {
		StringBuilder builder = new StringBuilder();
		double numberLiteral;
		boolean isFloat = false;
		do {
			isFloat |= c == '.' || c == 'e' || c == 'E';
			builder.append((char)c);
			//if E then we can have a - or + as next char
			if (c == 'E' || c == 'e') {
				nextChar();
				if (c == '-' || c == '+' || Character.isDigit(c)) {
					builder.append((char)c);
					nextChar();
					continue;
				} else {
					break;
				}
			} else {
				nextChar();	
			}			
		} while (Character.isDigit(c) || c == '.' || c == 'E' || c == 'e');
		numberLiteral = Double.parseDouble(builder.toString());
		if (isFloat || numberLiteral > Long.MAX_VALUE) {
			// number is real (money)
			yylval = new MoneyLiteral(location(), numberLiteral);

		} else {
			// number is integer
			yylval = new IntegerLiteral(location(), (long) numberLiteral);
		}
		return token = NUMBERLITERAL;
	}

	private int getStringLiteral() {
		nextChar();
		StringBuilder builder = new StringBuilder();
		boolean inString = true;
		while (inString)
		{
			if (c == '"')
			{
				inString = false;
			}
			else if (c == '\\')
			{
				nextChar();
				builder.append(getEscapedChar(c));
			}
			else 
			{
				builder.append((char)c);
			}
			nextChar();
		}
		this.yylval = new StringLiteral(location(), builder.toString());
		return token = STRINGLITERAL;
	}

	private char getEscapedChar(int c) {
		switch(c)
		{
			case 't': return '\t';
			case 'n': return '\n';
			case 'r': return '\r';
			case 'b': return '\b';
			case 'f': return '\f';
			
			case '\'':
			case '"':
			case '\\':
				return (char)c;
				
			default:
				//unrecognized escape sequence
				//show the character itself.
				return (char)c;
		}
	}

	public int getToken() {
		return token;
	}

	public Node getSemantic() {
		return yylval;
	}

}
