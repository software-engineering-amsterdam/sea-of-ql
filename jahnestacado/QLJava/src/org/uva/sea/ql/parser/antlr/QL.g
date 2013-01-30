grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.binary.algebraic.*;
import org.uva.sea.ql.ast.expr.binary.bool.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.values.*;

}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;

}



type returns [Type result]
	:INTEGER { $result = new IntType();} 
	|BOOLEAN { $result = new BoolType();} 
	|STRING { $result = new StringType();}
	|MONEY {$result = new MoneyType();}
	;
	
	

form returns [Form result]
	:'form' Ident  '{' body '}' EOF {$result = new Form(new Ident($Ident.text),$body.result);}
	;
	
	

	
		
	body returns [Body result]
  @init { Body body= new Body();  }
  :(element  { body.addElement($element.result) ; } )*
  {$result=body;}
  ;
	
element returns [BodyElement result]
		:conditionalElement {$result=$conditionalElement.result;}
		|question {$result=$question.result;}
		|computedQuestion {$result=$computedQuestion.result;}
	;
	
	
question returns [Question result]
  : Ident ':' StringLit type {$result=new Question(new Ident($Ident.text),new StringLit($StringLit.text),$type.result);};
  
computedQuestion returns [ComputedQuestion result]
  : Ident ':' StringLit type '(' expr=orExpr ')' {$result=new ComputedQuestion(new Ident($Ident.text),new StringLit($StringLit.text),$type.result,expr);};
  
  
conditionalElement returns [ConditionalElement result]
	:'if' '(' expr=orExpr ')' '{'b1=body'}' 'else' '{'b2= body'}'  {$result=new IfThenElse(expr,$b1.result,$b2.result);}
	|'if' '(' expr=orExpr ')' '{' body'}' {$result=new IfThen(expr,$body.result);}
	;
  



primary returns [Expr result]
  : Decimal { $result = new Decimal(Float.parseFloat($Decimal.text)); }
  | Int { $result = new Int(Integer.parseInt($Int.text)); }
  | StringLit {$result = new StringLit($StringLit.text);}
  | BoolLit  {$result = new BoolLit(Boolean.parseBoolean($BoolLit.text));}
  | Ident { $result = new Ident($Ident.text); }
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



   
// Tokens




INTEGER:'int';
STRING:'string';
BOOLEAN:'boolean';
MONEY:'money';


BoolLit	:	('true' | 'false');  



WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : ('/*' .* '*/'|'//'  ){$channel=HIDDEN;}  
     ;
     
  
    
StringLit	:	'"' .* '"' ;


Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Decimal : Int '.' Int ;
Int: ('0'..'9')+;





