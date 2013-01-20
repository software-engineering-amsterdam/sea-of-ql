package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.literals.Int;
import org.uva.sea.ql.ast.literals.Text;

public class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		
		// Structural keywords
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("if", IF);
		
		// DataType keywords
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("int", INTEGER);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("text", TEXT);
	}
	
	
	private int token;
	private int c = ' ';
	
	private ASTNode yylval;
	private final Reader input;
	
	private long lineNum = 1;
	private int colNum = 0;

	public QLLexer(Reader input) {
		this.input = input;
	}
	
	
	private void nextChar() {
		if (c >= 0) {
			try {
				c = input.read();
			}
			catch (IOException e) {
				c = -1;
			}
			if(c == '\n'){
				lineNum++;
				colNum = 0;
			}else{
				colNum++;
			}
		}
		
	}
	
	public int nextToken() {
		int n = this._nextToken();
		//System.out.println(n);
		return n;
	}
	
	private int _nextToken() {
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
			    	return token = '/'; 
			    }
			    case ':': nextChar(); return token = ':';
			    case '}': nextChar(); return token = '}';
			    case '{': nextChar(); return token = '{';
			    case ')': nextChar(); return token = ')';
			    case '(': nextChar(); return token = '(';
			    case '*': {
			    	nextChar();
			    	if (inComment && c == '/') {
			    		inComment = false;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '*';
			    }
			    case '+': nextChar(); return token = '+';
			    case '-': nextChar(); return token = '-';
			    case '&': {
			    	nextChar(); 
			    	if  (c == '&') {
			    		return token = AND;
			    	}
			    	this.throwLexicalException("Unexpected character: " + (char)c);
			    }
			    case '|': {
			    	nextChar(); 
			    	if  (c == '|') {
			    		return token = OR;
			    	}
			    	this.throwLexicalException("Unexpected character: " + (char)c);
			    }
			    case '!': nextChar(); return token = '!';
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
			    		return token = EQ;
			    	}
			    	this.throwLexicalException("Unexpected character: " + (char)c);
			    }
			    case '>': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = GEQ;
			    	}
			    	return token = '>';
			    } 
			    case '"': {
			    	StringBuilder sb = new StringBuilder();
			    	do {
			    		nextChar();
			    		if(c == -1){
			    			this.throwLexicalException("Unexpected end while expecting Text closure literal");
			    		}
			    		if(c != '"'){
			    			sb.append((char)c);
			    		}
			    	}while( c != '"');
			    	nextChar();
			    	yylval = new Text(sb.toString());
			    	return token = TEXT;
			    }
			    default: {
			    	if (Character.isDigit(c)) {
			    		int n = 0; 
			    		do {
			    			n = 10 * n + (c - '0');
			    			nextChar(); 
			    		} while (Character.isDigit(c)); 
			    		yylval = new Int(n);
			    		return token = INT;
			    	}
			    	if (Character.isLetter((char)c)) {
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
						yylval = new Ident(name);
			    		return token = IDENT;
			    	}
			    	this.throwLexicalException("Unexpected character: " + (char)c);
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

	protected void throwLexicalException(final String errorMessage){
		throw new RuntimeException(errorMessage + " at line " + lineNum + ", column " + colNum + ".");
	}

}
