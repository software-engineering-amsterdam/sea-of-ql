grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.bool.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.math.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.elements.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

parse returns [Form result]
:	 formDefinition EOF {$result = $formDefinition.result;};

formDefinition returns [Form result]
	:	 Form formDeclaration {$result = $formDeclaration.result;};
	
formDeclaration returns [Form result]
: 	FormIdent LEFTCBR blockContent RIGHTCBR {$result = new Form(new StringLiteral($FormIdent.text), $blockContent.result);};

blockContent returns [Block result]
@init 
{
	List l = new ArrayList();
	result = new Block(l);	
}
: (blockLine {if($blockLine.result != null) {$result.addLine($blockLine.result);}} )* 
;
	
blockLine returns [AbstractBlockElement result]
:  question {$result = $question.result;}
| ifStatement {$result = $ifStatement.result;}
;

question returns [Question result]
	: ident Assign String type {$result = new Question($ident.result, new StringLiteral($String.text), $type.result);}
	| ident Assign String type '(' e=orExpr ')' {$result = new Question($ident.result, new StringLiteral($String.text), $type.result, $e.result);}
;

ifStatement returns [IfStatement result]
: 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR {$result = new IfStatement($orExpr.result, $blockContent.result);}
;

ident returns [Ident result]
: Ident { $result = new Ident(new StringLiteral($Ident.text)); }
;

type returns [AbstractType result]
	:  boolType { $result = $boolType.result;}
	|  money   { $result = $money.result;} 
	|  intType { $result = $intType.result;}
	|  strType { $result = new StrType();}	
;
intType returns [IntType result]
	:	'integer' { $result = new IntType(); }
;
money	returns [Money result]
	: 	'money' { $result = new Money(); }
;
boolType returns [BooleanType result]
	:	'boolean'{$result = new BooleanType(); }
;
strType returns [StrType result]
	: 	'string'{$result = new StrType(); }
;
	

primary returns [Expr result]
  : Int   { $result = new IntLiteral(Integer.parseInt($Int.text)); }
  | ident { $result = $ident.result; }
  | String { $result = new StringLiteral($String.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }  
  //| BoolLit { $result = new BooleanLiteral(true); }
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

    
// Tokens

COMMENT 
     : 		'/*' .* '*/' {$channel=HIDDEN;}
     | 		'//' ( ~'\n' )* {$channel=HIDDEN;}
    ;
    
WS  :		(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; } ;
//BoolLit :	('true' | 'TRUE' | 'false' | 'FALSE');
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