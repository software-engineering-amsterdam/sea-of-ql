grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.values.*;

}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;

}



type returns [Type result]
	: (Type {
	 if ($Type.text.equals("int"))$result = new IntType($Type.text); 
	 else if ($Type.text.equals("boolean"))$result = new BoolType($Type.text); 
	  else if ($Type.text.equals("string"))$result = new StringType($Type.text);
		}
		);
	
	

form returns [Form result]
	: 'form' Ident  '{' bodyElements '}'  {$result = new Form(new Ident($Ident.text),$bodyElements.result);}
	;
	
	
	
bodyElements returns [List<BodyElements> result]
@init { List<BodyElements> bodyElements = new ArrayList(); }
	:( computedQuestion  {bodyElements.add($computedQuestion.result);}
	| question  {bodyElements.add($question.result);}
	|ifBlock {bodyElements.add($ifBlock.result);}
	 )+
	{$result=$bodyElements.result;}
	;
	
question returns [Question result]
  : Ident ':' StringLit type {$result=new Question($Ident.text,$StringLit.text,$type.result);};
  
computedQuestion returns [ComputedQuestion result]
  : Ident ':' StringLit type '(' expr=orExpr ')' {$result=new ComputedQuestion(new Ident($Ident.text),$StringLit.text,$type.result,expr);};
  
  
  ifBlock returns [IfBlock result]
  : 'if' '(' expr=orExpr ')' '{'  bodyElements'}' {$result=new IfBlock(expr,$bodyElements.result);};
  



primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | StringLit {$result = new StringLit($StringLit.text);}
  | BoolLit  {$result = new BoolLit($BoolLit.text);}
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



Type: ('int'|'string'|'boolean');
BoolLit	:	('true' | 'false');  


LB    :('\n'|'\r');

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : ('/*' .* '*/'|'//' ~(LB)* ){$channel=HIDDEN;}  
     ;
     
  
    
StringLit	:	'"' .* '"' ;


Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;





