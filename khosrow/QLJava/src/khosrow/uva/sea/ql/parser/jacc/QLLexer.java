package khosrow.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.BoolLiteral;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.expr.IntLiteral;
import khosrow.uva.sea.ql.ast.expr.MoneyLiteral;
import khosrow.uva.sea.ql.ast.expr.StringLiteral;

public class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();		
		KEYWORDS.put("if", IF);
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("integer", INTEGER);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("string", STRING);
		KEYWORDS.put("form", FORM);
	}
	
	
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
				System.out.println("WS");
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
			    case '{': nextChar(); return token = '{';
			    case '}': nextChar(); return token = '}';
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
			    case '%': nextChar(); return token = '%';
			    case '+': nextChar(); return token = '+';
			    case '-': nextChar(); return token = '-';			    
			    case ';': nextChar(); return token = ';';
			    case ':': nextChar(); return token = ':';			    
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
			    case '"': {
			    	StringBuilder sb = new StringBuilder();
			    	while(true){
			    		nextChar();
			    		if(c == -1)
			    			throw new RuntimeException("Syntax error in string literal");
			    		if( c== '"')
			    			break;
			    		sb.append((char)c);			    		
			    	}
			    	nextChar();
			    	yylval = new StringLiteral(sb.toString());
		    		return token = STRING_LITERAL;
			    }
			    	
			    default: {
			    	if (Character.isDigit(c)) {
			    		int n = 0; 
			    		do {
			    			n = 10 * n + Character.digit(c, 10);
			    			nextChar(); 
			    		} while (Character.isDigit(c));
			    		if(c != '.') {
			    			yylval = new IntLiteral(n);
			    			return token = INT_LITERAL;
			    			}
			    		double v = n, d = 10; 
			    		for(;;) {
			    			nextChar();
			    			if(!Character.isDigit(c))
			    				break;
			    			v = v + Character.digit(c, 10) / d;
			    			d *= 10;
			    		}
			    		yylval = new MoneyLiteral(v);
		    			return token = MONEY_LITERAL; 
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
			    		if(name.equals("true") || name.equals("false"))
			    		{
			    			yylval = new BoolLiteral(Boolean.getBoolean(name));
			    			return token = BOOL_LITERAL;
			    		}
						yylval = new Ident(name);
			    		return token = IDENT;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
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
