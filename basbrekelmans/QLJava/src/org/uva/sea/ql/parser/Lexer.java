package org.uva.sea.ql.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.CodeLocationInformationImpl;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.types.QLType;
import org.uva.sea.ql.ast.types.TypeDeclaration;

public class Lexer implements Tokens {
	private static final Map<String, Integer> KEYWORDS;

	//define keywords
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("if", IF);
		KEYWORDS.put("else", ELSE);
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("true", BOOLEANLITERAL);
		KEYWORDS.put("false", BOOLEANLITERAL);
		KEYWORDS.put("bool", TYPE);
		KEYWORDS.put("int", TYPE);
		KEYWORDS.put("money", TYPE);
		KEYWORDS.put("string", TYPE);
	}

	private int token;
	private int c = ' ';
	private int line = 1;
	private int column = 1;
	private String fileName;
	private Node yylval;
	private final Reader input;

	public Lexer(Reader input, String fileName) {
		this.input = input;
		this.fileName = fileName;
	}

	public ICodeLocationInformation location()
	{
		return new CodeLocationInformationImpl(line, column, fileName);
	}
	
	private void error(String msg)
	{
		throw new ParseError(line, column, fileName, msg);
	}
	
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

			while (Character.isWhitespace(c)) {
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
			case '"': {
				return tokenizeString();
			}
			case ')':
				nextChar();
				return token = ')';
			case '(':
				nextChar();
				return token = '(';
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
					return token = EQ;
				}
				error("Unexpected character: " + (char) c);
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
					StringBuilder builder = new StringBuilder();
					double numberLiteral;
					do {
						builder.append(c);
						nextChar();
					} while (Character.isDigit(c) || c == '.' || c == 'E' || c == 'e' || c == '-' || c == '+');
					numberLiteral = Double.parseDouble(builder.toString());
					if (numberLiteral % 1 != 0 || numberLiteral > Long.MAX_VALUE) {
						// number is real (money)
						yylval = new MoneyLiteral(location(), numberLiteral);

					} else {
						// number is integer
						yylval = new IntegerLiteral(location(), (long) numberLiteral);
					}
					return token = NUMBERLITERAL;

				}
				if (Character.isLetter(c)) {
					StringBuilder sb = new StringBuilder();
					do {
						sb.append((char) c);
						nextChar();
					} while (Character.isLetterOrDigit(c));
					String name = sb.toString();
					if (KEYWORDS.containsKey(name)) {
						int token = KEYWORDS.get(name);
						if (token == BOOLEANLITERAL)
						{
							this.yylval = new BooleanLiteral(location(), Boolean.parseBoolean(name));
						}
						if (token == TYPE)
						{
							this.yylval = new TypeDeclaration(location(), QLType.parse(name));
						}
						return token = KEYWORDS.get(name);
					}
					yylval = new Identifier(location(), name);
					return token = IDENTIFIER;
				}
				error("Unexpected character: " + (char) c);
			}
			}
		}
	}

	private int tokenizeString() {
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
				builder.append(c);
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
