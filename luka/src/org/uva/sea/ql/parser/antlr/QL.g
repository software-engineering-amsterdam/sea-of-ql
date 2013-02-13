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
// Module and square ?!!
//TODO ELSE IF!?
tokens{
BLOCK;
ASSIGNMENT;
QUESTION_LABEL;
IDENT;
ASSIGNMENT_TYPE;
ASSIGNMENT_EXPRESSION;
IF_STATEMENT;
IF_CONDITION;
IF_BLOCK_TRUE;
IF_BLOCK_FALSE;
UNARY_MINUS;
UNARY_NEGATE;
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
import java.util.Map; 
import java.util.HashMap; 
}

@parser::members{
	public Map<Ident,Type> typeEnv = new HashMap<Ident,Type>();
	private void mapIdentToType(String identName,Type type){
	//System.out.println(identName+type.toString());
		typeEnv.put(new Ident(identName),type);
	}
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
	: FormStart FormId Lbr blockItem* Rbr EOF -> ^(FormId ^(BLOCK blockItem*));
	
blockItem
	:	(questionAssignment | constantAssignment | ifBlock ) ; 
	

questionAssignment 
	: Ident  Assignment_Indicator  String identType (atom)? {mapIdentToType($Ident.text,$identType.t);}  ->^(ASSIGNMENT ^(IDENT Ident) ^(ASSIGNMENT_TYPE identType) ^(QUESTION_LABEL  String)  ^(ASSIGNMENT_EXPRESSION atom)?)
	 
	 ;


constantAssignment
	: Ident  Assignment_Indicator identType atom {mapIdentToType($Ident.text,$identType.t);} -> ^(ASSIGNMENT ^(IDENT Ident ) ^(ASSIGNMENT_TYPE identType) ^(ASSIGNMENT_EXPRESSION  atom))
	;
	
//
identType  returns [Type t]	
	: BooleanType {$t = new BoolType();}  -> BooleanType 
	| MoneyType {$t = new MoneyType();}  -> MoneyType 
	;	


ifBlock 
	: ifCondition  ifStatementBlock  (elseBlock)?  ->^(IF_STATEMENT  ^(IF_CONDITION ifCondition )  ^(IF_BLOCK_TRUE ifStatementBlock) ^(IF_BLOCK_FALSE elseBlock)?) 
	;
	
ifCondition
	:  If RoundLbr orExpr  RoundRbr -> orExpr;	
	
//TODO ELSE IF!?	
ifStatementBlock	
	: 	Lbr  blockItem* Rbr -> ^(BLOCK blockItem*);

elseBlock
	: Else Lbr blockItem* Rbr -> ^(BLOCK blockItem*)
	;
	
		 


atom 
  : Int  
  | Ident 
  | BooleanType
  | MoneyType 
 // | Integer {$result = new Ident($Integer.text, new int(1));}
  |  RoundLbr!  x=orExpr^ RoundRbr! 
  ;
  
unExpr 
    :  Sub atom -> ^(UNARY_MINUS atom) //<- NEGATIVE//Add x=atom
    |  Not atom -> ^(UNARY_NEGATE atom)
    |  atom    
    ;    
    
mulExpr 
    :   lhs=unExpr  ( op=( Mul | Div )^ rhs=unExpr )*
    ;
    
  
addExpr 
    :   lhs=mulExpr ( op=(Add | Sub )^ rhs=mulExpr )*
    ;
  
relExpr 
    :   lhs=addExpr  ( op=(LT |LTEqu |GT |GTEqu |Equ |NotEqu)^ rhs=addExpr )*
    ;
    
andExpr 
    :   lhs=relExpr ( And^ rhs=relExpr  )* 
    ;
    

orExpr 
    :  lhs=andExpr ( Or^ rhs=andExpr )* 
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