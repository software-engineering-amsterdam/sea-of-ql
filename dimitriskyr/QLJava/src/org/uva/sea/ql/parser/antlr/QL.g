grammar QL;
options  {output=Ast;} //backtrack=true; memoize=true;



@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.values.*;
}
 
//form  

form returns[Form result]   
  :  'form' ident '{' block '}'  {$result = new Form (new Ident($ident.text), $block.result);}
; 
 
 
//form end

block returns [Block result]
@init{ Block block = new Block(); }
  : (body {block.addBody($body.result);})* {$result=block;}
  ; 
 

body returns [Statement result]
  : ifthen { $result = $ifthen.result; } 
  | simplequestion { $result = $simplequestion.result; }
  | comquestion {$result = $comquestion.result; }
  //| ifthenelse { $result= $ifthenelse.result; } 
  ; 


//if-then statement
  
ifthen returns [Statement result]
  : 'if' expression '{' b=block '}' {$result = new IfThen($expression.result , $b.result);}
;
                                     
//if-then end
                                          
//if-then-else

ifthenelse returns [Statement result]
  : 'if' expression '{' b1=block '}' 'else' '{' b2=block '}' {$result = new IfThenElse($expression.result , $b1.result, $b2.result);}
;

//if-then-else end  

//questions 
 
simplequestion returns [Statement result]
  : ident ':' string type {$result = new SimpleQuestion(new Ident($ident.text) , new String_lit($string.text) , $type.result);}
; 
  
comquestion returns [Statement result]
  : ident ':' string type expression  {$result = new ComQuestion(new Ident($ident.text) , new String_lit($string.text) , $type.result , $expression.result);}
;                                           

//end of questions 
                                           
expression returns [Expr result] 
  : integer {$result = new Int(Integer.parseInt($integer.text));}
  | bool { $result = new Bool(Boolean.parseBoolean($bool.text));}
  | string { $result = new String_lit($string.text);}
  | money {$result = new Money(Float.parseFloat($money.text));}
  | ident {$result = new Ident($ident.text);}
  | '(' x=orExpr ')' {$result = $x.result;}
  ; 


 
unExpr returns [Expr result]
    :  '+' pos=unExpr { $result = new Pos($pos.result); }
    |  '-' neg=unExpr { $result = new Neg($neg.result); }
    |  '!' not=unExpr { $result = new Not($not.result); }
    |  x=expression    { $result = $x.result; }
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
  : lhs=relExpr {$result = $lhs.result;} ( '&&' rhs=relExpr {$result = new And ($result, rhs); } )* ;
  

orExpr returns [Expr result]
  : lhs=andExpr {$result = $lhs.result;}  ( '||' rhs=andExpr {$result = new Or($result,rhs); } )* ;

//end of expressions
 
//types

type returns [Type result]
 :  ( whattype =('integer'|'boolean'|'string'|'money')
    { 
      if ($whattype.text.equals("integer")) {
        $result = new IntegerType();
      }
      if ($whattype.text.equals("boolean")) {
        $result = new BooleanType();      
      }
      if ($whattype.text.equals("string")) {
        $result = new StringType();
     }
     if ($whattype.text.equals("money")) {
        $result = new MoneyType();
     }
    })+
  ; 
   
integer : Int ; 
string : String_literal ; 
bool : Bool ;
ident : Ident ;
money : Money ;
//end of values 
  
// Tokens

Comments : ('/*' .* '*/' | '//' .* ('\n' | '\r')) {$channel=HIDDEN;};

WS : (' ' | '\t' | '\n' | 'r') {$channel = HIDDEN;} ;  

Int : ('0'..'9')+ ;

Money : ('0'..'9')+'.'('0'..'9')+;

Bool: ('true' | 'false'); 

Ident : ('a'..'z' | 'A'..'Z')( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;
   
String_literal : '"' .* '"' ;
  
  /* : '"'
    ( '"' '"'
    | ~('"'|'\n'|'\r')
    )*
    ( '"'
    | // nothing -- write error message
    )
  ; */