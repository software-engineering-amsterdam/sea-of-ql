grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.rel.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.ql.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.semanticchecker.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

qlform returns [QLForm result]
	: 'form' Ident '{' block '}' {$result = new QLForm(new Ident($Ident.text),  $block.result); }
	;
	
block returns [Block result]
	@init { Block block= new Block(); }
	:  (statement { block.addBlockElement($statement.result); })* {$result = block; }
	;
    
statement returns [Statement result]
	: question {$result=$question.result;}
	| computedQuestion {$result = $computedQuestion.result;}
	| conditionalQuestion {$result = $conditionalQuestion.result;}
	;
	
question returns [Question result]
	: Ident ':' StringLit type {$result=new Question(new Ident($Ident.text),$StringLit.text, $type.result);};
	
computedQuestion returns [ComputedQuestion result]
  : Ident ':' StringLit type '(' expr=orExpr ')' {$result=new ComputedQuestion(new Ident($Ident.text),$StringLit.text,$type.result,expr);};

conditionalQuestion returns [ConditionalQuestion result]
  :'if' '(' expr=orExpr ')' '{' b1=block '}' 'else' '{' b2=block '}'  {$result=new ConditionalElseQuestion($expr.result,$b1.result,$b2.result);}
  |'if' '(' expr=orExpr ')' '{' block '}' {$result=new ConditionalQuestion($expr.result,$block.result);}
  ; 

type returns [Type result]
	: BOOLEAN { $result = ReturnTypeHolder.getBoolType();}
	| INTEGER { $result = ReturnTypeHolder.getIntType();}
//	| DECIMAL { $result = ReturnTypeHolder.getDecType();}
	| STRING {$result = ReturnTypeHolder.getStringType();}
//	| MONEY {$result = ReturnTypeHolder.getMoneyType();}
	;
	  
primary returns [Expr result]
  : Int   { $result = new IntegerVal(Integer.parseInt($Int.text)); }
//  | Decimal {$result = new DecimalVal(Float.parseFloat($Decimal.text)); }
  | Bool {$result = new BooleanVal(Boolean.parseBoolean($Bool.text)); }
  | StringLit {$result = new StringVal($StringLit.text); }
  | Ident { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
	
unExpr returns [Expr result]
    : '+' x=unExpr { $result = new Pos($x.result); }
    | '-' x=unExpr { $result = new Neg($x.result); }
    | '!' x=unExpr { $result = new Not($x.result); }
    | x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
	: lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
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
    : lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
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
    : lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
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
    : lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    
orExpr returns [Expr result]
    : lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

    
// Tokens

BOOLEAN: 'boolean';
INTEGER: 'int';
//MONEY: 'money';
//DECIMAL: 'decimal';
STRING: 'text';

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;

Bool: 'true' | 'false';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Decimal : Int '.' Int ;

StringLit: '"' .* '"' ;