grammar QL;

options {
backtrack=true; 
memoize=true;  
output=AST;
ASTLabelType=CommonTree;
} 
tokens{
//QUESTIONNAIRE;
QUESTION_BLOCK;
QUESTION_VAR;
QUESTION_LABEL;
IF_BLOCK;
IF_CONDITION;
IF_CONDITION_TRUE;
VAR_TYPE;
VAR_NAME;
VALUE_CALC;
UNARY_EXPR;
NEG_EXPR;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
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
	: FormStart qStartExp EOF -> ^(FormStart qStartExp);
	
 	
//Start of questionnaire
qStartExp 

	: FormId Lbr qStartQExpr Rbr ->^(FormId qStartQExpr); 

//Start of sum of questions	
qStartQExpr 
	: (qDeclaration | ifStatementExpr)*;

//question with child elements
qDeclaration 
	: QuestionVariable  ':' QuestionLabel qType ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(VAR_NAME QuestionVariable) ^(VAR_TYPE qType))  ^(QUESTION_LABEL QuestionLabel)) 
	| QuestionVariable  ':' QuestionLabel qType '(' orExpr ')'  ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(VAR_NAME QuestionVariable) ^(VAR_TYPE qType) ^(VALUE_CALC orExpr))  ^(QUESTION_LABEL QuestionLabel)) ;


// if(x<y) / verschachtelt TODO
ifStatementExpr 
	:	 IF  '(' orExpr ')'   Lbr ifBlockContentExpr Rbr ->^(IF_BLOCK ^(IF_CONDITION orExpr) ^(IF_CONDITION_TRUE ifBlockContentExpr));


ifBlockContentExpr
	:	( qDeclaration  | ifStatementExpr )+;
	
	

//Question type
qType	
	: Boolean | Money ;	


primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Boolean {$result = new Bool($Boolean.text);}
  | QuestionVariable  { $result = new Ident($QuestionVariable.text); } -> ^(VAR_NAME QuestionVariable) //{$result = $QuestionId.result;}
  | Money { $result = new Int(Integer.parseInt($Money.text));}
  |  '('!  x=orExpr ')'! { $result = $x.result; }  
  ;
  
  //Unary  UNARY_MIN TODO
unExpr returns [Expr result]
    :  '+'^ x=unExpr { $result = new Pos($x.result); }
    |  '-'^ x=unExpr { $result = new Neg($x.result); }
    |  '!'^ x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
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
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'^|'<='^|'>'^|'>='^ |'=='^ |'!='^) rhs=addExpr 
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
    :   lhs=andExpr { $result = $lhs.result; } ( '||'^ rhs=andExpr { $result = new Or($result, $rhs.result); } )*
    ;



    
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/


WS  : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
COMMENT     : ('/*' .* '*/' | '//' ~('\r' | '\n')*)   { $channel = HIDDEN; } ;

FormStart: 'form' { System.out.println("Lex Start: "+getText()); };
Boolean : 'boolean' { System.out.println("Lex Boolean: "+getText()); };
Money	: 'money' { System.out.println("Lex Money: "+getText()); };

IF	: 'if' { System.out.println("Lex IF: "+getText()); };

FormId 	: 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex FormId: "+getText()); };
QuestionVariable : 'a'..'z'('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex QuesionID: "+getText()); };
QuestionLabel: '"' .*  '"' { System.out.println("Lex Question: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };
