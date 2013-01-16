grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}


  
primary returns [Expr result]
  : IntLiteral           { $result = new IntLiteral(Integer.parseInt($IntLiteral.text)); }
  | MoneyLiteral         { $result = new MoneyLiteral(Double.parseDouble($MoneyLiteral.text)) ;}
  | BoolLiteral          { $result = new BoolLiteral(Boolean.parseBoolean($BoolLiteral.text)) ;}
  | StringLiteral        { $result = new StringLiteral($StringLiteral.text);}
  | Ident                { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'     { $result = $x.result; }
  ;
  
type returns [Type result]
   : 'boolean' { $result = new BoolType() ;}
   | 'string'  { $result = new StringType() ;}
   | 'int'     { $result = new IntType() ;}
   | 'money'   { $result = new MoneyType() ;}
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
      if ($op.text.equals("<=")) {
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

question returns [Question result]
    :   Ident ':' StringLiteral type '(' orExpr ')' { $result = new Question(new Ident($Ident.text) ,new StringLiteral($StringLiteral.text), $type.result, $orExpr.result); }
    |   Ident ':' StringLiteral type { $result = new Question(new Ident($Ident.text) ,new StringLiteral($StringLiteral.text), $type.result); }
    ;

ifThenElse returns [IfThenElse result]
    :   'if' '(' orExpr ')' thenbody=formblock ('else' elseBody=formblock)? { $result = new IfThenElse($orExpr.result, thenbody, elseBody); }
    ;

formElement returns [FormElement result]
    : ifThenElse { $result = $ifThenElse.result; }
    | question   { $result = $question.result; }
    ;
    
formblock returns [FormBlock result]
    @init {
        ArrayList<FormElement> formElements = new ArrayList<FormElement>();
    }
    : '{' (formElement { formElements.add($formElement.result); })* '}' {$result = new FormBlock(formElements); }
    ;

form returns [Form result]
    : 'form' Ident formblock { $result = new Form(new Ident($Ident.text), $formblock.result); }
    ;
// Tokens
Ws  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

BoolLiteral: 'true'|'false';

Comment : '/*' .* '*/' {$channel=HIDDEN;};

LineComment : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
    
StringLiteral : '"' .* '"';

Ident :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

IntLiteral : ('0'..'9')+;

MoneyLiteral : ('0'..'9')+ '\.' ('0'..'9')('0'..'9');