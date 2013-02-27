grammar QL;
//options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.values.*;

}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
	: 'form' Ident body=block {$result = new Form(new Ident($Ident.text), body);};
	
block returns [Block result]
	@init { List<FormUnit> formUnits = new ArrayList<FormUnit>();}
	: '{' (formUnit {formUnits.add($formUnit.result);})* '}' { $result = new Block(formUnits); }
	; 
	
formUnit returns [FormUnit result]
	: question         { $result = $question.result; }
  | computedQuestion { $result = $computedQuestion.result; }
	| ifStatement      { $result = $ifStatement.result; }
	;

question returns [Question result]
	: Ident ':' String '[' type ']' { $result = new Question(new Ident($Ident.text), $String.text, $type.result); }
	;
	
computedQuestion returns [ComputedQuestion result]
	: Ident ':' String '(' orExpr ')' '[' type ']' { $result = new ComputedQuestion(new Ident($Ident.text), $String.text, $orExpr.result, $type.result); }
	;
	
ifStatement returns [IfStatement result]
	@init { List<FormUnit> formUnits = new ArrayList<FormUnit>();}
	: 'if' '(' orExpr ')' 'then' ifBody=block 'endif' { $result = new IfStatement($orExpr.result, ifBody); }
	; 
	
ifElseStatement returns [IfElseStatement result]
	@init { List<FormUnit> formUnits = new ArrayList<FormUnit>();}
	: 'if' '(' orExpr ')' 'then' ifBody=block 'else' elseBody=block 'endif' { $result = new IfElseStatement($orExpr.result, ifBody, elseBody); }
	;  
	 
type returns [Type result]
  : 'Bool' {$result = new TypeBool();}
  | 'Int' {$result = new TypeInt();}
  | 'String'  {$result = new TypeString();}
  ;

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Bool {$result = new BoolValue(Boolean.parseBoolean($Bool.text)); }
  | String { $result = new StringValue($String.text); }
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
WS  :	(' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
    ;

SINGLECOMMENT : '//' .* ('\n' | '\r') {$channel=HIDDEN;} ;

COMMENT 
    : '/*' .* '*/' {$channel=HIDDEN;} ;
    
Bool: ('true' | 'false');

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

String: ('"' .* '"');