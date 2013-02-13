grammar QL;
options  {output=Ast;} //backtrack=true; memoize=true;}



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

/*  TYPE CHECKING
(px an '+' na dw type tis left timis meta type tis right timis kai an einai similar ok. O visitor mas voithaei na kanoume 
to idio se periptwseis opws 3 * 5 + 6 * 7)!!!! */
 
//form  

form returns[Form result]   
    @init { List<Statement> formparts = new ArrayList<Statement>();}
 :  'form' ident '{' (parts {formparts.add($parts.result);})+ '}'  {$result = new Form (new Ident($ident.text), formparts);}
 ; 
 
//form end 

parts returns [Statement result]
  : ifthen { $result = $ifthen.result; } 
  | questions { $result = $questions.result; }
//| ifthenelse { $result= $ifthenelse.result; } 
  ; 

//if-then statement
  
ifthen returns [Statement result]
  @init { List<Statement> ifBlock = new ArrayList<Statement>();}
  : 'if' expression '{' (parts {ifBlock.add($parts.result);})+ '}' {$result = new IfThen($expression.result , ifBlock);}
  ;
                                      
//if-then end
                                          
//if-then-else

/*ifthenelse returns [Statement result]
  @init { List<Statement> block1 = new ArrayList<Statement>(); List<Statement> block2 = new ArrayList<Statement>();}
  : 'if' expression '{' (p1=part {block1.add($p1.result);})+ '}' 'else' '{' (p2=part {block2.add($p2.result);})+ '}' {$result = new Ifthenelse($expression.result , block1, block2);}
  ;
*/
//if-then-else end  

//questions 
 
 questions returns [Statement result]
  : ident ':' string type {$result = new Question(new Ident($ident.text) , new String_lit($string.text) , $type.result);}
  | ident ':' string type expression  {$result = new ComQuestion(new Ident($ident.text) , new String_lit($string.text) , $type.result , $expression.result);}
  ; 

/*questions returns [Question result]
  : ident1=type ':' string1=type bool1=type {$result = new Questions(ident1 , string1 , bool1);} //simple question
  | ident2=type ':' string2=type bool2=type expr=expression {$result = new ComQuestions(ident2 , string2 , bool2, expr);} // computed question
  ;
  */ 

//end of questions 
                                           
expression returns [Expr result] 
  : value
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

value returns [Value result]
  : integer {$result = new Int(Integer.parseInt($integer.text));}
  | ident {$result = new Ident($ident.text);}
  | bool { $result = new Bool(Boolean.parseBoolean($bool.text));}
  | string { $result = new String_lit($string.text);}
  | money {$result = new Money(Float.parseFloat($money.text));}
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