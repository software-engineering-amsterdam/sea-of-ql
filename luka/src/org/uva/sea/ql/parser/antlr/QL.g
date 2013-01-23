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
SINGLE_STATEMENT;
COMPUTED_STATEMENT;
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
BOOL_TYPE;
INT_TYPE;
MONEY_TYPE;
STR_TYPE;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.literals.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
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
	: FormStart Ident qContentBlock EOF -> ^(FormStart qContentBlock);
	
 	
//Start of questionnaire
qContentBlock 

	:  Lbr qContentBlockItem Rbr ->^(Ident qContentBlockItem); 

qContentBlockItem
	:	(constantValueDeclaration | questionDeclaration  | ifStatement )* ;
	
//question with child elements
questionDeclaration 
	: varName=Ident  ':'  label=QuestionLabel qType ('(' orExpr ')')?  ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(IDENT_LITERAL $varName) ^(qType) ^(VAR_VALUE ^(COMPUTED_STATEMENT orExpr))?)  ^(QUESTION_LABEL ^(STR_TYPE $label)))
	 ;
	//| QuestionVariable  ':' QuestionLabel qType ->^(QUESTION_BLOCK ^(QUESTION_VAR ^(VAR_NAME QuestionVariable) ^(VAR_TYPE qType))  ^(QUESTION_LABEL QuestionLabel)) 
	
//questionLabel
//	:	'"' (Ident)+ .* '"'
//	;

ifStatement 
	:If  '(' orExpr  ')' Lbr qContentBlockItem Rbr  elseBlock?  ->^(IF_BLOCK  ^(IF_EXPRESSION orExpr) ^(IF_TRUE qContentBlockItem) ^(IF_FALSE elseBlock)?)
	;
	
elseBlock
	:Else Lbr qContentBlockItem Rbr -> qContentBlockItem
	;
	
		 
constantValueDeclaration
	: constName=Ident  ':' atom -> ^(CONST_VAR ^(CONST_NAME $constName) ^(CONST_TYPE CONST_TYPE_INT) ^(CONST_VALUE  atom))
	;

//Question type
qType	
	: Boolean -> ^(BOOL_TYPE) | Money -> ^(MONEY_TYPE) ;	

atom //returns [Expr result]
  : Int    -> ^(INT_LITERAL Int) //{ $result = new IntNode(Integer.parseInt($Int.text)); }
  | Ident  -> ^(IDENT_LITERAL Ident) //{ $result = new Ident($Ident.text); }
  | Boolean  -> ^(BOOL_LITERAL Boolean) //{$result = new BoolNode($Boolean.text);}
 // | QuestionVariable   -> ^(SINGLE_STATEMENT QuestionVariable) //{ $result = new Ident($QuestionVariable.text);}
  | Money -> ^(SINGLE_STATEMENT Money) // { $result = new MoneyNode(Integer.parseInt($Money.text));}
  |  '('  x=orExpr ')'-> ^(COMPUTED_STATEMENT orExpr) // { $result = $x.result; } 
  ; 
  
  //Unary  UNARY_MIN TODO
unExpr //returns [Expr result]
    :  '+'^ x=atom //{ $result = new Pos($x.result); } 
    |  '-'^ x=atom //{ $result = new Neg($x.result); }
    |  '!'^ x=atom //{ $result = new Not($x.result); }
    |  x=atom    //{ $result = $x.result; }
    ;  
    
mulExpr //returns [Expr result]
    :   lhs=unExpr ( op=( '*'^ | '/'^ ) rhs=unExpr )* // lhs=unExpr { $result=$lhs.result; } ( op=( '*'^ | '/'^ ) rhs=unExpr 
   //  { 
   //    if ($op.text.equals("*")) {
  //       $result = new Mul($result, $rhs.result);
  //     }
  //     if ($op.text.equals("<=")) {
  //       $result = new Div($result, $rhs.result);      
  //     }
 //    }
   // 
    ;
    
  
addExpr //returns [Expr result]
    :   lhs=mulExpr ( op=('+'^ | '-'^ ) rhs=mulExpr)* // lhs=mulExpr { $result=$lhs.result; } ( op=('+'^ | '-'^) rhs=mulExpr
   // { 
   //   if ($op.text.equals("+")) {
   //     $result = new Add($result, $rhs.result);
   //   }
   //   if ($op.text.equals("-")) {
   //     $result = new Sub($result, $rhs.result);      
   //   }
   // }
    ;
  
relExpr //returns [Expr result]
    :   lhs=addExpr  ( op=('<'^|'<='^|'>'^|'>='^ |'=='^ |'!='^) rhs=addExpr )* // lhs=addExpr { $result=$lhs.result; } ( op=('<'^|'<='^|'>'^|'>='^ |'=='^ |'!='^) rhs=addExpr
 //   { 
//      if ($op.text.equals("<")) {
//        $result = new LT($result, $rhs.result);
//      }
//      if ($op.text.equals("<=")) {
//        $result = new LEq($result, $rhs.result);      
//      }
//      if ($op.text.equals(">")) {
//        $result = new GT($result, $rhs.result);
//      }
//      if ($op.text.equals(">=")) {
//        $result = new GEq($result, $rhs.result);      
//      }
//      if ($op.text.equals("==")) {
//        $result = new Eq($result, $rhs.result);
//      }
//      if ($op.text.equals("!=")) {
//        $result = new NEq($result, $rhs.result);
//      }
//    }
     
    ;
    
andExpr //returns [Expr result]
    :   lhs=relExpr ( '&&'^ rhs=relExpr  )* //lhs=relExpr { $result=$lhs.result; } ( '&&'^ rhs=relExpr { $result = new And($result, $rhs.result); } )*
    ;
    

orExpr //returns [Expr result]
    :   lhs=andExpr ( '||'^ rhs=andExpr )* //lhs=andExpr { $result = $lhs.result; } ( '||'^ rhs=andExpr { $result = new Or($result, $rhs.result); } )*
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
//FormId 	: 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex FormId: "+getText()); };
//QuestionVariable : 'a'..'z'('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex QuesionID: "+getText()); };
QuestionLabel: '"' .*  '"' { System.out.println("Lex Question: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };
