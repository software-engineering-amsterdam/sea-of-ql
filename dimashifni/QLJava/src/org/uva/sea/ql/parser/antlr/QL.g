grammar QL;
options 
{
backtrack=true; 
memoize=true;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form
: 'form' Ident '{'  
  (assignment | statement)*  
  '}'
;

variable
: Ident 
;

type
: 'Integer'
| 'Boolean'
| 'StringLiteral'
;

term
: Ident
| Int
| StringLiteral
| Bool
;

assignment
: variable ':' StringLiteral type
;

statement
: ifStatement
;

ifStatement
: 'if' '(' primary ')'
  '{'
    assignment+
  '}'
;

primary returns [Expr result]
: Int   { $result = new Int(Integer.parseInt($Int.text)); } 
| Ident { $result = new Ident($Ident.text); } 
| '(' x=orExpression ')' { $result = $x.result; }
;
    
unaryExpression returns [Expr result]
: '+' x=unaryExpression { $result = new Pos($x.result); }
| '-' x=unaryExpression { $result = new Neg($x.result); }
| '!' x=unaryExpression { $result = new Not($x.result); }
| x=primary    { $result = $x.result; }
;    
   
multiplyExpression returns [Expr result]
: lhs=unaryExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unaryExpression 
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
    
  
addExpression returns [Expr result]
: lhs=multiplyExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=multiplyExpression
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
  
relExpression returns [Expr result]
: lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
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
    
andExpression returns [Expr result]
: lhs=relExpression { $result=$lhs.result; } ( '&&' rhs=relExpression { $result = new And($result, rhs); } )*
;

orExpression returns [Expr result]
: lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*
;
    
// Tokens
WS  
: (' ' | '\t' | '\n' | '\r' | '\f')+ { $channel=HIDDEN; }
;

Comment 
: '/*' .* '*/' {$channel=HIDDEN;}
;
    
StringLiteral: '"' 
			{ StringBuilder stringBuilder = new StringBuilder(); } 
			(
				'"' '"'  {stringBuilder.appendCodePoint('"');} 
				|
				c=~('"'| '\r' | '\n')  {stringBuilder.appendCodePoint(c);}
			)* 
			'"'
			{setText(stringBuilder.toString());} 
			;

Bool
: 'true'
| 'false'
;
			    
Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;