grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.bool.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.math.*;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.elements.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

parse returns [Expr result]
:	 formDefinition EOF {$result = $formDefinition.result;};

formDefinition returns [Expr result]
	:	 Form formDeclaration {$result = $formDeclaration.result;};
	
formDeclaration returns [Expr result]
: 	FormIdent LEFTCBR blockContent RIGHTCBR {$result = new Form($FormIdent.text, $blockContent.result);};

blockContent returns [Block result]
@init 
{
	List l = new ArrayList();
	result = new Block(l);	
}
: (blockLine {if($blockLine.result != null) {$result.addLine($blockLine.result);}} )* 
;
	
blockLine returns [Expr result]
:  question {$result = $question.result;}
| ifStatement {$result = $ifStatement.result;}
;

question returns [Expr result]
: Ident Assign String type {$result = new Question(new Ident($Ident.text), new StringLiteral($String.text), $type.result);}
;

ifStatement returns [Expr result]
: 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR {$result = new IfStatement($orExpr.result, $blockContent.result);}
;

type returns [Type result]
	:  boolType { $result = new BooleanType();}
	|  money   { $result = $money.result;} 
	|  intType { $result = new IntType();}
	|  strType { $result = new StrType();}	
;



money	returns [Money result]
	: 	'money' { $result = new Money(); }
	|	 moneyCalc { $result = $moneyCalc.result; }
;

moneyCalc returns [Money result]
:	 'money' LEFTBR addExpr RIGHTBR {$result = new Money( $addExpr.result);}
;

	

primary returns [Expr result]
  : Int   { $result = new IntLiteral(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | String { $result = new StringLiteral($String.text); }
  | type {$result = $type.result; }
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
    
boolType:	'boolean';
strType :	'string';
intType :	'integer';
    
// Tokens

COMMENT 
     : 		'/*' .* '*/' {$channel=HIDDEN;}
     | 		'//' ( ~'\n' )* {$channel=HIDDEN;}
    ;
    
WS  :		(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; } ;

Form 	:	'form';
FormIdent:	'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')*;
Ident	:   	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
String	:	'"' .* '"';

Int 	: 	('0'..'9')+;
Assign 	:	':';

LEFTCBR	:	'{';
RIGHTCBR:	'}';
LEFTBR 	:	'(';
RIGHTBR	:	')';
