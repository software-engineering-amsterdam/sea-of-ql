grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Bool
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

form returns [Form result]
	: 'form' Ident b=block {$result = new Form(new Ident($Ident.text), b);};

block returns [Block result]
	@init
	{
		List<Statement> statements = new ArrayList<Statement>();
	}
	:	'{' (s=statement {statements.add(s);})* '}' {$result = new Block(statements);};

statement returns [Statement result]
  	: i=ifStatement {$result = i;}
  	| b=block {$result = b;}
  	| q=question {$result = q;}
  	;

question returns [Question result]
:	(c=computedQuestion {$result=c;} | n=normalQuestion {$result=n;});

normalQuestion returns [Question result]
	:	Ident ':' String t=type { $result = new Question(new Ident($Ident.text), new StringLiteral($String.text), t); };
	
computedQuestion returns [ComputedQuestion result]
	:	Ident ':' String t=type '(' exp=orExpr ')' { $result = new ComputedQuestion(new Ident($Ident.text), new StringLiteral($String.text), t, exp);};
	
type returns [Type result]
	: IntType {$result = new IntType();} 
	| BoolType {$result = new BoolType();} 
	| StringType {$result = new StringType();};

ifStatement returns [IfThenElse result]
	:	If '(' cond=orExpr ')' body=block (Else elseBody=block)?		
		{ $result = new IfThenElse(cond, body, elseBody); };
    
// Tokens
WS  :	(' ' | '\t' | NEWLINE) { $channel=HIDDEN; };
    

COMMENT 
     : ('/*' .* '*/' | '//' ~(NEWLINE)*) {$channel=HIDDEN;};

fragment NEWLINE 
	: 	('\n' | '\r');

BoolType:	'bool';

IntType	:	'int';

StringType 
	:	'string';
	
If	:	'if';

Else	:	'else';
	
String	:	('"' .* '"');

Bool	:	('true' | 'false');

Ident	:	 ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int	:	 ('0'..'9')+;