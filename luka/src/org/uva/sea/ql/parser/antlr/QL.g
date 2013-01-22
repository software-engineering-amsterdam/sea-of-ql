grammar QL;
//TODO: var_scope, var_declaration, 
// easy & computed question
//if(VAR > CONST)
//if(VAR > 100)
// IF STATEMENT wie ?!
// SWITCH for QL ?
options {
backtrack=true; 
memoize=true;  
output=AST;
//ASTLabelType=CommonTree;
} 
tokens{
//QUESTIONNAIRE;
QUESTION_BLOCK;
QUESTION_VAR;
QUESTION_LABEL;
IF_BLOCK;
IF_STATEMENT;
IF_TRUE;
IF_FALSE;
VAR_TYPE;
VAR_NAME;
CONST_VAR;
CONST_TYPE;
CONST_VALUE;
CONST_NAME;
CONST_TYPE_INT;
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
	: FormStart FormId qContentBlock EOF -> ^(FormStart qContentBlock);
	
 	
//Start of questionnaire
qContentBlock 

	:  Lbr qContentBlockItem Rbr ->^(FormId qContentBlockItem); 

qContentBlockItem
	:	( qDeclaration  | ifStatement | constantDeclarationExpr )+;
	
//question with child elements
qDeclaration 
	: QuestionVariable  ':' QuestionLabel qType ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(VAR_NAME QuestionVariable) ^(VAR_TYPE qType))  ^(QUESTION_LABEL QuestionLabel)) 
	| QuestionVariable  ':' QuestionLabel qType '(' orExpr ')'  ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(VAR_NAME QuestionVariable) ^(VAR_TYPE qType) ^(VALUE_CALC orExpr))  ^(QUESTION_LABEL QuestionLabel)) ;


// if(x<y) / verschachtelt TODO
ifStatement 
	: If  '(' orExpr ')'   Lbr ifTrue=qContentBlockItem Rbr Else Lbr ifFalse=qContentBlockItem Rbr  ->^(IF_BLOCK ^(IF_STATEMENT orExpr) ^(IF_TRUE $ifTrue) ^(IF_FALSE $ifFalse)) 
	| If  '(' orExpr ')'   Lbr ifTrue=qContentBlockItem Rbr  ->^(IF_BLOCK ^(IF_STATEMENT orExpr) ^(IF_TRUE $ifTrue))
	;
	
constantDeclarationExpr
	:	QuestionVariable  ':' Int -> ^(CONST_VAR ^(CONST_NAME QuestionVariable) ^(CONST_TYPE CONST_TYPE_INT) ^(CONST_VALUE Int));

//Question type
qType	
	: Boolean | Money ;	

atom returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); } //
  | Boolean {$result = new Bool($Boolean.text);}
  | QuestionVariable  { $result = new Ident($QuestionVariable.text);}// $QuestionVariable.text-> ^(VAR_NAME QuestionVariable) //{$result = $QuestionId.result;}
  | Money { $result = new Int(Integer.parseInt($Money.text));}
  |  '('!  x=orExpr ')'! { $result = $x.result; } 
  ;
  
  //Unary  UNARY_MIN TODO
unExpr returns [Expr result]
    :  '+'^ x=atom { $result = new Pos($x.result); } 
    |  '-'^ x=atom { $result = new Neg($x.result); }
    |  '!'^ x=atom { $result = new Not($x.result); }
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

If	: 'if' { System.out.println("Lex IF: "+getText()); };
Else	: 'else' { System.out.println("Lex ELSE: "+getText()); };
FormId 	: 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex FormId: "+getText()); };
QuestionVariable : 'a'..'z'('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex QuesionID: "+getText()); };
QuestionLabel: '"' .*  '"' { System.out.println("Lex Question: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };
