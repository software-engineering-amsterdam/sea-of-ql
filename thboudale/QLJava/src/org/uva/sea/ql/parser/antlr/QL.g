grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binaryExpr.*;
import org.uva.sea.ql.ast.expressions.unaryExpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}
/*
form
	: 'form' IDENT
	  '{' (question | computedQuestion | ifStatement)* '}'
	;

ifStatement
	: 'if' '(' orExpr ')'
	 '{' (question | computedQuestion)* '}'
	 ('else'  '{' (question | computedQuestion)* '}')?
	; */

computedQuestion returns [ComputedQuestion result]
	: IDENT ':' STRING_LITERAL type '(' x=orExpr ')'
	{ $result = new ComputedQuestion(new Ident($IDENT.text), new StringLiteral($STRING_LITERAL.text),  $type.result, $x.result); }
	;


question returns [Question result]
    : IDENT ':' STRING_LITERAL type
    { $result = new Question(new Ident($IDENT.text), new StringLiteral($STRING_LITERAL.text), $type.result); }
    ;

type returns [Type result]
    : 'int' { $result = new IntType("int"); }
    | 'boolean' { $result = new IntType("boolean"); }
    | 'string' { $result = new IntType("string"); }
    ;

primary returns [Expr result]
    : INT   { $result = new Int(Integer.parseInt($INT.text)); }
  	| IDENT { $result = new Ident($IDENT.text); }
  	| BOOLEAN { $result = new Bool(Boolean.parseBoolean($BOOLEAN.text)); }
  	| '(' x=orExpr ')'{ $result = $x.result; }
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
      if ($op.text.equals("<=")) {
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
       
// Tokens

WS
    : (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;
	
COMMENT
	  : '/*' .* '*/' {$channel=HIDDEN;}
	  | '//' .* ('\n'|'\r') {$channel = HIDDEN;}
    ;
    
INT
	  : ('0'..'9')+
	  ;

BOOLEAN
	  : ('true' | 'false')
	  ;

IDENT
	  : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	  ;
	 
STRING_LITERAL
    : '"' .* '"'
    ;