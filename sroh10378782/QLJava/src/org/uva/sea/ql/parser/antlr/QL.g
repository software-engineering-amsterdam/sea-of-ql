grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
import java.util.HashSet;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr; 
}

// PARSE RULES

start	returns [Expr result]
	: fD=formDeclaration { $result = $fD.result; }
	;

formDeclaration returns [Expr result]
	: FORM i=FORMIDENT x=block { $result = new Form(new Ident($i.text), $x.result);}
	| x=orExpr { $result = $x.result; }
	;
	
blockContent returns [HashSet<Expr> result]
	@init
	{
	    	$result = new HashSet<Expr>();
	}
    	: (v=statement { $result.add($v.result); } )*
	;
	
block returns [Expr result]
	: LCB b=blockContent RCB { $result = new Block($b.result); }
	;

conditionalStatement returns [Expr result]
	: c=condition b=block { $result = new ConditionalStatement($c.result, $b.result);}
	;
	
statement returns [Expr result]
	: a=assDeclStatement { $result = $a.result; }
	| c=conditionalStatement { $result = $c.result; }
	;
	
condition returns [Expr result]
	: IF LB x=orExpr RB { $result = new Condition($x.result); }
	;

tMoney	returns [Expr result]
	: m=MONEY {$result = new Money($m.text);}
	| MONEY LB x=addExpr RB { $result = new Money($x.result); }
	;
	
tBoolean returns [Expr result]
	: b=BOOLEAN {$result = new Bool($b.text);}
	;

assDeclStatement returns [Expr result]
	: i=IDENT CL s=STRING b=tBoolean { $result = new Question( new Ident($i.text), new Str($s.text), $b.result ); }
	| i=IDENT CL s=STRING x=tMoney { $result = new Question( new Ident($i.text), new Str($s.text), $x.result ); }
	;
	

// Skeleton Rules
primary returns [Expr result]
  : i=INT   { $result = new Int(Integer.parseInt($i.text)); }
  | s=STRING   { $result = new Str($s.text); }
  | m=MONEY { $result = new Money($m.text); }
  | b=BOOLEAN  { $result = new Bool($b.text); }
  | i=IDENT { $result = new Ident($i.text); }
  | LB x=orExpr RB { $result = $x.result; } 
  ;
    
unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("/")) {
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, rhs);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result] 
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;


// LEXER RULES
// Channel HIDDEN Tokens  
WS  		: (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; } 
    		;
COMMENT 	: '/*' .* '*/' {$channel=HIDDEN;}
    		;
LINE_COMMENT	: '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    		;

// QL Tokens

FORM		: KEYWORD_FORM;
FORMIDENT 	: ( UPPERCASE_LETTER )( LOWERCASE_LETTER | UPPERCASE_LETTER | INT_DIGIT )* 	
		;
IF		: KEYWORD_IF;
// QL Type Tokens
BOOLEAN		
	: ( KEYWORD_BOOLEAN | KEYWORD_TRUE | KEYWORD_FALSE ) 
	;
MONEY		
	: ( KEYWORD_MONEY )
	;
IDENT	
	: ( LOWERCASE_LETTER ) (LOWERCASE_LETTER | UPPERCASE_LETTER | INT_DIGIT | UNDERSCORE )* 
	;
STRING	//REM: DQ could be also removed
	: (DQ) ( LOWERCASE_LETTER | UPPERCASE_LETTER | INT_DIGIT | UNDERSCORE | QUESTION_MARK | COLON | SINGLE_SPACE | BACKSLASH )* (DQ)
	;
INT	
	: (INT_DIGIT)+ 
	;

// QL Helper Tokens
MONEY_COMMA
	: ( POINT | COMMA )
	;
LB 	: LEFT_BRACKED;	
RB 	: RIGHT_BRACKED;
LCB	: LEFT_CURLY_BRACKED;
RCB	: RIGHT_CURLY_BRACKED;
CL	: COLON;
DQ	: DOUBLE_QUOTES;


// QL Tokens fragments
fragment
INT_DIGIT	
	: '0'..'9'
	;
fragment
UNDERSCORE	
	: ('_')
	;
fragment
UPPERCASE_LETTER
	: 'A'..'Z'
	;
fragment
LOWERCASE_LETTER
	: 'a'..'z'
	;
fragment
DOUBLE_QUOTES
	: '"'
	;
fragment
SINGLE_SPACE
	: ' '
	;
fragment
QUESTION_MARK
	: '?'
	;
fragment
COLON
	: ':'
	;
fragment
BACKSLASH
	: '/'
	;
CURRENCY_EURO
	: '€'
	;
CURRENCY_DOLLAR
	: '$'
	;
fragment
LEFT_CURLY_BRACKED 	
	: '{'
	; 
fragment
RIGHT_CURLY_BRACKED 	
	: '}'
	; 
fragment
LEFT_BRACKED		
	: '('
	; 
fragment
RIGHT_BRACKED		
	: ')'
	;
fragment
POINT	
	: '.'
	;
fragment
COMMA	
	: ','
	;
fragment
KEYWORD_TRUE
	: 'true' | 'True'
	;
fragment
KEYWORD_FALSE
	: 'false' | 'False'
	;
fragment
KEYWORD_BOOLEAN
	: 'boolean' | 'Boolean'	
	;
fragment
KEYWORD_MONEY
	: 'money' | 'Money'
	;
fragment
KEYWORD_FORM
	: 'form' | 'Form'
	;
fragment
KEYWORD_IF
	: 'if' | 'If'
	;