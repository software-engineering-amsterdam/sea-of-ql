grammar QL;

options {
//backtrack=true; 
//memoize=true;  
output=AST;
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
} 
tokens{
ROOT;
QUESTION_BLOCK;
QUESTION_VAR;
QUESTION_LABEL;
IF_BLOCK;
IF_EXPRESSION;
IF_TRUE;
IF_FALSE;
VAR_TYPE;
VAR_NAME;
VAR_VALUE;
CONST_VAR;
CONST_TYPE;
CONST_VALUE;
CONST_NAME;
CONST_TYPE_INT;
VALUE_CALC;
UNARY_EXPR;
NEG_EXPR;
INT_LITERAL;
IDENT_LITERAL;
BOOL_LITERAL;
STR_LITERAL;
MONEY_LITERAL;
BOOL_TYPE;
INT_TYPE;
MONEY_TYPE;
STR_TYPE;
INTEGER_TYPE;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.questionnaire.*;
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
	: FormStart formName=FormId Lbr statement+ Rbr EOF -> ^(FormId statement+);
	
statement
	:	(answerableStatement | assignmentStatement | ifStatement ) ; //*
	

//Answerable and NOT answerable (calculates value, just for presentation, uses (orExpr)? ) //'(' orExpr ')'
answerableStatement 
	: varName=Ident  Assignment_Indicator  label=QuestionLabel identType (atom)?  ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(IDENT_LITERAL $varName identType)  ^(VAR_VALUE atom)?)  ^(QUESTION_LABEL ^(STR_LITERAL $label)))
	 ;

//Constant internal variable assignment, normal value and computed value
assignmentStatement
	: constName=Ident  Assignment_Indicator identType atom -> ^(CONST_VAR ^(IDENT_LITERAL CONST_NAME $constName) ^(CONST_TYPE CONST_TYPE_INT) ^(CONST_VALUE  atom))
	;
	
//Question type
identType	
	: Boolean -> ^(BOOL_TYPE) 
	| Money -> ^(MONEY_TYPE) 
	//| Integer -> ^(INTEGER_TYPE) 
	;	








//IF / IF ELSE STATEMENT PARTS 
ifStatement 
	:If ifConditionalExpression  ifStatementBlock  (elseBlock)?  ->^(IF_BLOCK  ^(IF_EXPRESSION ifConditionalExpression )  ^(IF_TRUE ifStatementBlock) ^(IF_FALSE elseBlock)?) //^(IF_EXPRESSION orExpr)
	;
	
ifConditionalExpression
	:  RoundLbr orExpr  RoundRbr -> orExpr;	
	
ifStatementBlock	
	: 	Lbr  statement* Rbr -> statement*;

elseBlock
	: Else Lbr statement* Rbr -> statement*
	;
	
		 


atom returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text, new Bool(false)); } 
  | Boolean {$result = new Bool(false);}
  | Money { $result = new Int(Integer.parseInt($Money.text));}
 // | Integer {$result = new Ident($Integer.text, new int(1));}
  |  RoundLbr!  x=orExpr^ RoundRbr! { $result = $x.result; } 
  ;
  
unExpr returns [Expr result]
    :  '+' x=atom { $result = new Pos($x.result); }
    |  '-' x=atom { $result = new Neg($x.result); }
    |  '!' x=atom { $result = new Not($x.result); }
    |  x=atom    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*'^ | '/'^ ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, $rhs.result);
      }
      if ($op.text.equals("<=")) {
        $result = new Div($result, $rhs.result);      
      }
    })*
    ;
    
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+'^ | '-'^) rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, $rhs.result);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, $rhs.result);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'^|'<='^|'>'^|'>='^|'=='^|'!='^) rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, $rhs.result);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, $rhs.result);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, $rhs.result);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, $rhs.result);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, $rhs.result);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, $rhs.result);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&'^ rhs=relExpr { $result = new And($result, $rhs.result); } )* 
    ;
    

orExpr returns [Expr result]
    :  lhs=andExpr { $result = $lhs.result; } ( '||'^ rhs=andExpr { $result = new Or($result, $rhs.result); } )* 
    ;



    
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/


WS  : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
COMMENT     : ('/*' .* '*/' | '//' ~('\r' | '\n')*)   { $channel = HIDDEN; } ;

FormStart: 'form' { System.out.println("Lex Start: "+getText()); };
//Ident types
Boolean : 'boolean' { System.out.println("Lex Boolean: "+getText()); };
Money	: 'money' { System.out.println("Lex Money: "+getText()); };
//Integer: 'int' { System.out.println("Lex Int: "+getText()); };

//Integer	:'integer' { System.out.println("Lex Integer: "+getText()); };
If	: 'if' { System.out.println("Lex IF: "+getText()); };
Else	: 'else' { System.out.println("Lex ELSE: "+getText()); };
FormId 	: 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex FormId: "+getText()); };

QuestionLabel: '"' .*  '"' { System.out.println("Lex Question: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };


Assignment_Indicator
	:	':'
	;

RoundLbr
	:	'('
	;

RoundRbr
	:	')'
	;