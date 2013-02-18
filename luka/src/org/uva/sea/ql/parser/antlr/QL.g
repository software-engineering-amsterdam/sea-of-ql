grammar QL;

options { 
output=AST;
backtrack=true;
memoize=true; 
} 

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
		typeEnv.put(new Ident(identName),type);
	}
	
	public Map<Ident,Type> getTypeEnf(){
		return typeEnv;
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
	: FormStart Ident Lbr blockItem* Rbr EOF{System.out.println("finished with grammar");} -> ^(Ident ^(BLOCK (blockItem)*));
	
blockItem
	:	(questionAssignment | constantAssignment | ifBlock )^ ; 
	

questionAssignment 
	: Ident  Assignment_Indicator  Str identType (atom)? {mapIdentToType($Ident.text,$identType.t);}  ->^(ASSIGNMENT ^(IDENT Ident) ^(ASSIGNMENT_TYPE identType) ^(QUESTION_LABEL  Str)  ^(ASSIGNMENT_EXPRESSION atom)?)
	 
	 ;


constantAssignment
	: Ident  Assignment_Indicator identType atom {mapIdentToType($Ident.text,$identType.t);} -> ^(ASSIGNMENT ^(IDENT Ident ) ^(ASSIGNMENT_TYPE identType) ^(ASSIGNMENT_EXPRESSION  atom))
	;
	
//
identType  returns [Type t]	
	: BooleanType {$t = new BoolType();}  -> BooleanType  
	| MoneyType  {$t = new MoneyType();} -> MoneyType  
	| IntegerType {$t = new IntType();}  -> IntegerType 
	| StringType {$t = new StringType();}  -> StringType
	| DoubleType {$t = new DoubleType();}  -> DoubleType
	;	


ifBlock 
	: ifCondition  ifStatementBlock  (elseBlock)?  ->^(IF_STATEMENT  ^(IF_CONDITION ifCondition )  ^(IF_BLOCK_TRUE ifStatementBlock) ^(IF_BLOCK_FALSE elseBlock)?) 
	;
	
ifCondition
	:  If RoundLbr orExpr  RoundRbr -> orExpr;	
	
	
ifStatementBlock	
	: 	Lbr  blockItem* Rbr -> ^(BLOCK blockItem*);

elseBlock
	: Else Lbr blockItem* Rbr -> ^(BLOCK blockItem*)
	;
	
		 


atom 
  : Int  
  | Ident 
  | Doub
  | Str
  | Bool
  |  RoundLbr!  x=orExpr^ RoundRbr! 
  ;
  
unExpr 
    :  Sub atom -> ^(UNARY_MINUS atom) 
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

FormStart: 'form'  { System.out.println("Start grammar"); };
Bool 	: 'true' 
	| 'false';

BooleanType : 'boolean'; 
MoneyType	: 'money';
IntegerType 	: 'integer';	
StringType : 'string';	
DoubleType : 'double';	
If	: 'if'; 
Else	: 'else'; 


Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*; 
Str: '"' .*  '"'; 




Int: ('0'..'9')+; 
Doub	: Int '.' Int;

Lbr	:	'{'; 
Rbr	:	'}'; 


Assignment_Indicator :	':';

RoundLbr : '(';

RoundRbr : ')';

Mul :	'*';

Div	:'/';

Add	:'+';

Sub	:'-';

LT	:'<';

LTEqu	:'<=';

GT	:'>';

GTEqu	:'>=';

Equ	:'==';

NotEqu 	:'!=';

And	:'&&';

Or	:'||';

Not	:'!';