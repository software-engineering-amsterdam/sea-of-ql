package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;

public class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("true", TRUE);
		KEYWORDS.put("false", FALSE);
		KEYWORDS.put("integer", INTEGER_TYPE);
		KEYWORDS.put("string", STRING_TYPE);
		KEYWORDS.put("boolean", BOOLEAN_TYPE);
		KEYWORDS.put("if", IF);
	}
	
	private boolean tokenRead = false;
	private int token;
	private int c = ' ';
	
	private ASTNode yylval;
	private final Reader input;

	public QLLexer(Reader input) {
		this.input = input;
		nextChar();
	}
	
	private void nextChar() {
		if (c >= 0) {
			try {
				c = input.read();
			}
			catch (IOException e) {
				c = -1;
			}
		}
	}
	
	public int nextToken() {
		tokenRead = true;
		boolean inComment = false;
		for (;;) {
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
			    	if (c == '/') {
			    		do {
			    			nextChar();
			    		} while(c != '\n' && c != '\r' && c != -1);
				    	nextChar();
			    		continue;
			    	}
			    	return token = '/'; 
			    }
			    case '*': {
			    	nextChar();
			    	if (inComment && c == '/') {
			    		inComment = false;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '*';
			    }
			    case '(': nextChar(); return token = '(';
			    case ')': nextChar(); return token = ')';
			    case '{': nextChar(); return token = '{';
			    case '}': nextChar(); return token = '}';
			    case ':': nextChar(); return token = ':';
			    case ';': nextChar(); return token = ';';
			    case '"': {
			    	nextChar();
					StringBuilder sb = new StringBuilder();
					while (c != '"' && c != -1) {
						sb.append((char)c);
						nextChar();
					}
					if (c == '"') {
			    		nextChar();
						String s = sb.toString();
			    		yylval = new StringLiteral(s);
			    		return token = STRING;
					} else {
						throw new RuntimeException("Unterminated string");
					}
			    }
			    case '+': nextChar(); return token = '+';
			    case '-': nextChar(); return token = '-';
			    case '&': {
			    	nextChar(); 
			    	if  (c == '&') {
			    		nextChar();
			    		return token = AND;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '|': {
			    	nextChar(); 
			    	if  (c == '|') {
			    		nextChar();
			    		return token = OR;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '!': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = NEQ;
			    	}
			    	return token = '!';
			    }
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
			    	if  (c == '=') {
			    		nextChar();
			    		return token = EQ;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
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
			    	if (Character.isDigit(c)) {
			    		int n = 0; 
			    		do {
			    			n = 10 * n + (c - '0');
			    			nextChar(); 
			    		} while (Character.isDigit(c)); 
			    		yylval = new IntegerLiteral(n);
			    		return token = INTEGER;
			    	}
			    	if (Character.isLetter(c)) {
			    		StringBuilder sb = new StringBuilder();
			    		do {
			    			sb.append((char)c);
			    			nextChar();
			    		}
			    		while (Character.isLetterOrDigit(c));
			    		String name = sb.toString();
			    		if (KEYWORDS.containsKey(name)) {
			    			return token = KEYWORDS.get(name);
			    		}
						yylval = new Identifier(name);
			    		return token = IDENTIFIER;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			}
		}
	}
	
	public int getToken() {
		if (!tokenRead)
			nextToken();
		return token;
	}

	public ASTNode getSemantic() {
		return yylval;
	}
}
