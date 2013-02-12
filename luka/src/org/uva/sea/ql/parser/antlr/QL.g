grammar QL;

options { 
output=AST;
} 
//backtrack=true; 
//memoize=true; 
//TODO: var_scope, var_declaration, 
// easy & computed question
//if(VAR > CONST)
//if(VAR > 100)
// IF STATEMENT wie ?!
// SWITCH CASE for QL ?
// Factory for creating UI
// default value for user inputs ?
// Unit tests ?!
//Each block own variable scope ? holds it for itself
//use static value NULL in value for null pattern
//ELSE IF?!

tokens{
QUESTION_ASSIGNMENT;
QUESTION_LABEL;
CONST_ASSIGNMENT;
IDENT;
ASSIGNMENT_TYPE;
ASSIGNMENT_EXPRESSION;
IF_STATEMENT;
IF_CONDITION;
IF_BLOCK_TRUE;
IF_BLOCK_FALSE;

}
//BOOL_TYPE;
//MONEY_TYPE;
//INTEGER_TYPE;
@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}



/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
parse
	: FormStart FormId Lbr block+ Rbr EOF -> ^(FormId block+);
	
block
	:	(questionAssignment | constantAssignment | ifBlock ) ; 
	

questionAssignment 
	: Ident  Assignment_Indicator  String identType (atom)?  ->^(QUESTION_ASSIGNMENT ^(IDENT Ident) ^(ASSIGNMENT_TYPE identType) ^(QUESTION_LABEL  String)  ^(ASSIGNMENT_EXPRESSION atom)?)
	 ;


constantAssignment
	: Ident  Assignment_Indicator identType atom -> ^(CONST_ASSIGNMENT ^(IDENT Ident ) ^(ASSIGNMENT_TYPE identType) ^(ASSIGNMENT_EXPRESSION  atom))
	;
	

identType	
	: BooleanType -> BooleanType 
	| MoneyType -> MoneyType 
	;	


ifBlock 
	: ifStatement  ifStatementBlock  (elseBlock)?  ->^(IF_STATEMENT  ^(IF_CONDITION ifStatement )  ^(IF_BLOCK_TRUE ifStatementBlock) ^(IF_BLOCK_FALSE elseBlock)?) 
	;
	
ifStatement
	:  If RoundLbr orExpr  RoundRbr -> orExpr;	
	
//TODO ELSE IF!?	
ifStatementBlock	
	: 	Lbr  block* Rbr -> block*;

elseBlock
	: Else Lbr block* Rbr -> block*
	;
	
		 


atom returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text, new Bool(false)); } 
  | BooleanType {$result = new Bool(false);}
  | MoneyType { $result = new Int(Integer.parseInt($MoneyType.text));}
 // | Integer {$result = new Ident($Integer.text, new int(1));}
  |  RoundLbr!  x=orExpr^ RoundRbr! { $result = $x.result; } 
  ;
  
unExpr returns [Expr result]
    :  Add x=atom { $result = new Pos($x.result); }
    |  Sub x=atom { $result = new Neg($x.result); }
    |  Not x=atom { $result = new Not($x.result); }
    |  x=atom    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( Mul^ | Div^ ) rhs=unExpr 
    { 
      if ($op.text.equals($Mul)) {
        $result = new Mul($result, $rhs.result);
      }
      if ($op.text.equals($Div)) {
        $result = new Div($result, $rhs.result);      
      }
    })*
    ;
    
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=(Add^ | Sub^) rhs=mulExpr
    { 
      if ($op.text.equals($Add)) {
        $result = new Add($result, $rhs.result);
      }
      if ($op.text.equals($Sub)) {
        $result = new Sub($result, $rhs.result);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=(LT^|LTEqu^|GT^|GTEqu^|Equ^|NotEqu^) rhs=addExpr 
    { 
      if ($op.text.equals($LT)) {
        $result = new LT($result, $rhs.result);
      }
      if ($op.text.equals($LTEqu)) {
        $result = new LEq($result, $rhs.result);      
      }
      if ($op.text.equals($GT)) {
        $result = new GT($result, $rhs.result);
      }
      if ($op.text.equals($GTEqu)) {
        $result = new GEq($result, $rhs.result);      
      }
      if ($op.text.equals($Equ)) {
        $result = new Eq($result, $rhs.result);
      }
      if ($op.text.equals($NotEqu)) {
        $result = new NEq($result, $rhs.result);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( And^ rhs=relExpr { $result = new And($result, $rhs.result); } )* 
    ;
    

orExpr returns [Expr result]
    :  lhs=andExpr { $result = $lhs.result; } ( Or^ rhs=andExpr { $result = new Or($result, $rhs.result); } )* 
    ;



    
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/


WS  : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
COMMENT     : ('/*' .* '*/' | '//' ~('\r' | '\n')*)   { $channel = HIDDEN; } ;

FormStart: 'form' { System.out.println("Lex Start: "+getText()); };
Bool 	: 'true' 
	| 'false';

BooleanType : 'boolean' { System.out.println("Lex Boolean: "+getText()); };
MoneyType	: 'money' { System.out.println("Lex Money: "+getText()); };

If	: 'if' { System.out.println("Lex IF: "+getText()); };
Else	: 'else' { System.out.println("Lex ELSE: "+getText()); };
FormId 	: 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex FormId: "+getText()); };

String: '"' .*  '"' { System.out.println("Lex String: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };


Assignment_Indicator :	':';

RoundLbr : '(';

RoundRbr : ')'	;

Mul
	:	'*'
	;

Div
	:	'/'
	;

Add
	:	'+'
	;

Sub
	:	'-'
	;

LT
	:	'<'
	;

LTEqu
	:	'<='
	;

GT
	:	'>'
	;

GTEqu
	:	'>='
	;

Equ
	:	'=='
	;

NotEqu
	:	'!='
	;

And
	:	'&&'
	;

Or
	:	'||'
	;

Not
	:	'!'
	;