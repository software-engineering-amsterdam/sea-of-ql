grammar QL;

options
{
	language = Java;
	backtrack=true;  
	memoize=true;
}
  
@lexer::header
{
	package org.uva.sea.ql.parser;
}  
   
@parser::header
{
	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.ast.Add;
	import org.uva.sea.ql.ast.And;
	import org.uva.sea.ql.ast.Div;
	import org.uva.sea.ql.ast.Eq;
	import org.uva.sea.ql.ast.Expr;
	import org.uva.sea.ql.ast.GEq;
	import org.uva.sea.ql.ast.GT;
	import org.uva.sea.ql.ast.Ident;
	import org.uva.sea.ql.ast.Int;
	import org.uva.sea.ql.ast.LEq;
	import org.uva.sea.ql.ast.LT;
	import org.uva.sea.ql.ast.Mul;
	import org.uva.sea.ql.ast.Neg;
	import org.uva.sea.ql.ast.NEq;
	import org.uva.sea.ql.ast.Not;
	import org.uva.sea.ql.ast.Or;
	import org.uva.sea.ql.ast.Pos;
	import org.uva.sea.ql.ast.Sub;
	import org.uva.sea.ql.parser.exception.ParserException;
}
	
@parser::members 
{
	@Override
	public void reportError(RecognitionException e) {
		super.reportError(e);
		throw new ParserException(e.getMessage()); 
	}
}
 
form
	:	'form' IDENTIFIER 
		'{'
			statement* 
		'}'  
	;

statement
	:	assignmentStatement
		| ifStatement
	;	

assignmentStatement
	:	IDENTIFIER ':' STRING_LITERAL type
	;
	
type
	:	'boolean'
		| 'integer'
	;

ifStatement
	:	'if' orExpr '{' statement+ '}'
		('else' 'if' orExpr '{' statement+ '}')*
		('else' '{' statement+ '}')?
	;

primary returns [Expr result]
	:	INTEGER { $result = new Int(Integer.parseInt($INTEGER.text)); }
	|	IDENTIFIER { $result = new Ident($IDENTIFIER.text); }
	|	'(' x=orExpr ')' { $result = $x.result; }
	;
    
unExpr returns [Expr result]
	:	'+' x=unExpr { $result = new Pos($x.result); }
	|	'-' x=unExpr { $result = new Neg($x.result); }
	|	'!' x=unExpr { $result = new Not($x.result); }
	|	x=primary    { $result = $x.result; }
	;   
	
mulExpr returns [Expr result]
	:	lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    	{ 
      		if ($op.text.equals("*")) 
      		{
        		$result = new Mul($result, rhs);
      		}
      		if ($op.text.equals("/")) 
      		{
        		$result = new Div($result, rhs);      
      		}
    	})*
    ;    
   
addExpr returns [Expr result]
	:	lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
		{ 
			if ($op.text.equals("+")) 
			{
				$result = new Add($result, rhs);
			}
			if ($op.text.equals("-")) 
			{
				$result = new Sub($result, rhs);      
			}
		})*
    ;
  
relExpr returns [Expr result]
	:	lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
		{ 
			if ($op.text.equals("<")) 
			{
				$result = new LT($result, rhs);
			}
			if ($op.text.equals("<=")) 
			{
        		$result = new LEq($result, rhs);      
      		}
      		if ($op.text.equals(">")) 
      		{
        		$result = new GT($result, rhs);
      		}
      		if ($op.text.equals(">=")) 
      		{
        		$result = new GEq($result, rhs);      
      		}
      		if ($op.text.equals("==")) 
      		{
       			$result = new Eq($result, rhs);
      		}
      		if ($op.text.equals("!=")) 
      		{
        		$result = new NEq($result, rhs);
      		}
    	})*
    ;
    
andExpr returns [Expr result]
	:	lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
	;
    

orExpr returns [Expr result]
	:	lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

STRING_LITERAL
	:	'"'
		{ StringBuilder b = new StringBuilder(); }
		(	'\\' '"'					{ b.appendCodePoint('"');}
		|	c = ~('"'|'\r'|'\n')	{ b.appendCodePoint(c);}
		)*
		'"'
		{ setText(b.toString()); }
	;
	
// Tokens
fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;
IDENTIFIER : LETTER (LETTER | DIGIT | '_')*;
WHITESPACE : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '//' .* ('\n'|'\r') {$channel = HIDDEN;};
MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;
