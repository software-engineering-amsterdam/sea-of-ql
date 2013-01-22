grammar QL;
options {language = Java;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
	@init { List<FormUnit> formUnits = new ArrayList<FormUnit>();}
	: 'form' Ident ':' (formUnit {formUnits.add($formUnit.result);})* 'endform' { $result = new Form($Ident.text, formUnits); }
	;
	

formUnit returns [FormUnit result]
	: question    { $result = $question.result; }
	| ifStatement { $result = $ifStatement.result; }
	;

question returns [Question result]
	: Ident ':' sentence '(' returnType ')' { $result = new Question($Ident.text, $sentence.text, $returnType.result); }
	; 
		
ifStatement returns [IfStatement result]
	@init { List<FormUnit> formUnits = new ArrayList<FormUnit>();}
	: 'if' '(' orExpr ')' (formUnit {formUnits.add($formUnit.result);})* 'endif' { $result = new IfStatement($orExpr.result, formUnits); }
	; 
	
returnType returns [ReturnType result]
  : 'Boolean' {$result = new TypeBool(1);}
  | 'Integer' {$result = new TypeInt(2);}
  | 'String'  {$result = new TypeString(3);}
  | 'Money'		{$result = new TypeMoney(4);}
  ;

sentence
  : '"' .* '"'
  ; 

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
    
unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Binary result]
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
WS  :	(' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
    ;

SINGLECOMMENT : '//' .* ('\n' | '\r') {$channel=HIDDEN;} ;

COMMENT 
    : '/*' .* '*/' {$channel=HIDDEN;} ;
    
Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;