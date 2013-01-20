grammar QL;
options { 	
	backtrack=true; 
	memoize=true; 
	language=Java;  
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Bool { $result = new Bool($Bool.text);}
  | Str { $result = new Str($Str.text);}
  | Money { $result = new Money($Money.text); }
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

form returns [Form result]
    : Form Ident LeftBrace formElements RightBrace { $result = new Form(new Ident($Ident.text), $formElements.result); };

formElement returns [FormElement result] 
    : question {$result = $question.result;}
    | condition {$result = $condition.result;}
    ;

formElements returns [ArrayList<FormElement> result]
    @init { result = new ArrayList<FormElement>(); }
    : (element = formElement { $result.add(element);})*
    ;

question returns [Question result] 
    : Ident ':' Str Vars { $result = new Question(new Ident($Ident.text), $Str.text, $Vars.text); }
    ;

condition returns [Condition result]
    : If '(' orExpr ')' LeftBrace (question | condition)* RightBrace { $result = new Condition($orExpr.result); }
    // Else needs to be implemented
    ;
computation returns [Computation result]
    : Ident  ':' Str '(' orExpr ')' { $result = new Computation(new Ident($Ident.text), $Str.text, $orExpr.result ); }
    ;
 
// Tokens
Newline: ('\n' | '\r');

WS:	(' ' | '\t' | Newline) { $channel=HIDDEN; };

Comment: '/*' .* '*/' {$channel=HIDDEN;} 
       | '//' ~(Newline)* {$channel=HIDDEN;};

SpecialChars: ('!' | '?' | ',' | '.' | '<' | '>' | '=' | '+' | '-' | '[' | ']' | '|');

Vars: ('int' | 'boolean' | 'string' | 'money');

LeftBrace: '{';

RightBrace: '}';

Bool: ('true' | 'false');

If: ('if');

Else: ('else');

Form: 'form';

Str: '"' (Ident | WS | Int | SpecialChars)* '"';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Money: ('0'..'9') ',' ('0'..'9')('0'..'9');

Int: ('0'..'9')+;