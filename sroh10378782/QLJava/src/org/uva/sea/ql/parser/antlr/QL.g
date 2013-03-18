grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.nodes.expressions.*;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.parser.antlr.error.ANTLRError;
import org.uva.sea.ql.parser.antlr.error.ParseError;
import org.uva.sea.ql.parser.antlr.error.LexerError;
}

@parser::members {
  private List<ANTLRError> errors = new ArrayList<ANTLRError>();
  public List<ANTLRError> getErrors(){
  	return this.errors;
  }
  
  @Override
  public void reportError(RecognitionException e) {
    this.errors.add(new ParseError(getErrorHeader(e)));
  }
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr; 
import org.uva.sea.ql.parser.antlr.error.ANTLRError;
import org.uva.sea.ql.parser.antlr.error.ParseError;
import org.uva.sea.ql.parser.antlr.error.LexerError;
}

@lexer::members {
  private List<ANTLRError> errors = new ArrayList<ANTLRError>();
  public List<ANTLRError> getErrors(){
  	return this.errors;
  }
  
  @Override
  public void reportError(RecognitionException e) {
    this.errors.add(new LexerError(getErrorHeader(e)));
  }
}

// PARSE RULES
start	returns [Statement result]
	: fD=formDeclaration { $result = $fD.result; }
	;

formDeclaration returns [Statement result]
	: FORM i=FORMIDENT b=block { $result = new Form(new Ident($i.text), $b.result);}
	// for test cases
	| x=block { $result = $x.result; }
	| x=statement { $result = $x.result; }
	| x=ifStatement { $result = $x.result; }
	| x=ifElseStatement { $result = $x.result; }
	;
	
blockContent returns [ArrayList<Statement> result]
	@init
	{
	    	$result = new ArrayList<Statement>();
	}
    	: (v=statement { $result.add($v.result); } )*
	;
	
block returns [Statement result]
	: LCB b=blockContent RCB { $result = new Block($b.result); }
	;

ifStatement returns [Statement result]
	: ic=ifCondition ib=block { $result = new IfThen($ic.result, $ib.result);}
	;
ifElseStatement returns [Statement result]
	: ic=ifCondition ib=block ELSE eb=block  { $result = new IfThenElse($ic.result, $ib.result, $eb.result);}
	;
	
statement returns [Statement result]
	: cqd=compQuestionDeclaration { $result = $cqd.result; }
	| qd=questionDeclaration { $result = $qd.result; }
	| ie=ifElseStatement { $result = $ie.result; }
	| is=ifStatement { $result = $is.result; }
	;
	
ifCondition returns [Expr result]
	: IF LB x=IDENT RB { $result = new Ident($x.text); }
	| IF LB e=orExpr RB { $result = $e.result; }
	;
// Simple Types
typeMoney returns [Expr result]
	: m=MONEY {$result = new Money($m.text);}
	;
	
typeBoolean returns [Expr result]
	: b=BOOLEAN {$result = new Bool($b.text);}
	;
	
typeInteger returns [Expr result]
	: i=INT {$result = new Int($i.text);}
	;
// Computated types [Bool,Int,Money]
compTypeMoney returns [Expr result]
	: MONEY LB ( x=addExpr | x=mulExpr ) RB { $result = new CompMoney($x.result); }
	;

compTypeBoolean returns [Expr result]
	: BOOLEAN LB bx=boolExpr RB { $result = new CompBool($bx.result); }
	;

compTypeInteger returns [Expr result]
	: INT LB ( x=addExpr | x=mulExpr ) RB { $result = new CompInt($x.result); }
	;
// Computated  Question variant	
compQuestionDeclaration returns [Statement result]
	: i=IDENT CL s=STRING cb=compTypeBoolean { $result = new ComputedQuestion( new Ident($i.text), new Str($s.text), $cb.result ); }
	| i=IDENT CL s=STRING cm=compTypeMoney { $result = new ComputedQuestion( new Ident($i.text),  new Str($s.text), $cm.result ); }
	| i=IDENT CL s=STRING ci=compTypeInteger { $result = new ComputedQuestion( new Ident($i.text),  new Str($s.text), $ci.result ); }
	;	
// Simple Question variant
questionDeclaration returns [Statement result]
	: i=IDENT CL s=STRING tb=typeBoolean { $result = new Question( new Ident($i.text), new Str($s.text), $tb.result ); }
	| i=IDENT CL s=STRING tm=typeMoney { $result = new Question( new Ident($i.text),  new Str($s.text), $tm.result ); }
	| i=IDENT CL s=STRING ti=typeInteger { $result = new Question( new Ident($i.text),  new Str($s.text), $ti.result ); }
	;
	
boolExpr returns [Expr result]
	: rx=relExpr { $result = $rx.result; }
	| ax=andExpr { $result = $ax.result; }
	| ox=orExpr  { $result = $ox.result; };	
	
// Skeleton Rules
primary returns [Expr result]
  : i=INT   { $result = new Int($i.text); }
  | s=STRING   { $result = new Str($s.text); }
  | m=MONEY { $result = new Money($m.text); }
  | b=BOOLEAN  { $result = new Bool($b.text); }
  | LB x=orExpr RB { $result = $x.result; }
  | i=IDENT { $result = new Ident($i.text); }
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
IF		: KEYWORD_IF;
FORMIDENT 	: ( UPPERCASE_LETTER )( LOWERCASE_LETTER | UPPERCASE_LETTER | INT_DIGIT )* 	
		;

ELSE 		: KEYWORD_ELSE;	
// QL Type Tokens
BOOLEAN		
	: ( KEYWORD_BOOLEAN | KEYWORD_TRUE | KEYWORD_FALSE ) 
	;
MONEY		
	: ( KEYWORD_MONEY | (INT_DIGIT)+(MONEY_COMMA)(INT_DIGIT)+ )
	;
IDENT	
	: ( LOWERCASE_LETTER ) (LOWERCASE_LETTER | UPPERCASE_LETTER | INT_DIGIT | UNDERSCORE )* 
	;
STRING	
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
	: 'If' | 'if'
	;
fragment
KEYWORD_ELSE
	: 'else' | 'Else'
	;