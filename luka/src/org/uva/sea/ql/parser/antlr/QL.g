grammar QL;

options {
backtrack=true; 
memoize=true;  
ASTLabelType=CommonTree;
output=AST;
} 

tokens{
QUESTIONNAIRE;
QUESTION_BLOCK ;
IF_BLOCK;
VALUE_CALC;
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

//Statement: variablen zuweisung, if statement, loops
// Rule type
//Expressions  (RULES ???)
//hasSoldHouse: "Did you sell a house in 2010?" boolean
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
	// statement if
	// declaration (complete question)
	// expression (ein wort, nur frage
	//Type (boolean)
parse 
	: FormStart qStartExp EOF -> ^(QUESTIONNAIRE qStartExp);
	
 	
//Start of questionnaire
qStartExp 

	: FormId Lbr qStartQExpr Rbr ->^(FormId qStartQExpr);

//Start of sum of questions	
qStartQExpr 
	: (qDeclaration | ifStatementExpr)*;

//question with child elements
qDeclaration 
	: qIdentifier  ':' qLabel questionTypeDefExpr ->^(QUESTION_BLOCK qIdentifier qLabel questionTypeDefExpr);

//Type definition of question OR calculated value for type
questionTypeDefExpr
	:	(qType | qType qValueCalcExpr );
	
// if(x<y) / verschachtelt TODO
ifStatementExpr 
	:	 IF '(' qIdentifier ')' Lbr ifBlockContentExpr Rbr ->^(IF_BLOCK qIdentifier ifBlockContentExpr);

ifBlockContentExpr
	:	( qDeclaration  | ifStatementExpr )+;
// ANPASSEN !
qValueCalcExpr 
	:  '(' orExpr ')' ->^(VALUE_CALC orExpr); 
	
//Question ID / alos in IF STATEMENT, rename ?
qIdentifier : QuestionId ; //QuestionId;
//User Question
qLabel	: Question;
//Question type
qType	
	: Boolean | Money ;	


primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  //| Question {$result = new Question($Question.text);}
  | Boolean {$result = new Bool($Boolean.text);}
  | QuestionId {$result = null;}
  | Money { $result = new Int(Integer.parseInt($Money.text));}
  //| IF {$result = new Condition($IF.)}
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
  
  //Unary 
unExpr returns [Expr result]
    :  '+'^ x=unExpr { $result = new Pos($x.result); }
    |  '-'^ x=unExpr { $result = new Neg($x.result); }
    |  '!'^ x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*'^ | '/' ) rhs=unExpr 
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


//formName: Ident qForm;	
//qForm: '{' stat+ '}' stat*;
//stat	: qId Question qType;
//qId	: Ident ':'; //vll FALSCH!?
//uQuestion : '"' Ident '"';
//qType 	: (Boolean | Money);




    
// Tokens questionString, identifier, boolean, money, string
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
QuestionId : 'a'..'z'('a'..'z'|'A'..'Z'|'0'..'9')+  { System.out.println("Lex QuesionID: "+getText()); };
Question: '"' .*  '"' { System.out.println("Lex Question: "+getText()); };



Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ { System.out.println("Lex Ident: "+getText()); };
Int: ('0'..'9')+ { System.out.println("Lex Int: "+getText()); };

Lbr	:	'{' { System.out.println("Lex {: "+getText()); };
Rbr	:	'}' { System.out.println("Lex }: "+getText()); };

// ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_' | '/')+ ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_' | '/' | '?')* 
 //| ':' | '/' | '?'
//QuestionId : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ ':'+ { System.out.println("Lex QuestionId: "+getText()); };
//Question: '"' ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ '?' '"' { System.out.println("Lex Question: "+getText()); };
//Type 	: 'boolean' | 'money';
//questionString, id, boolean, money, string

//Question : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ ;

//Money 	:	('0'..'9')+ ('.' ('0'..'9')+)?;