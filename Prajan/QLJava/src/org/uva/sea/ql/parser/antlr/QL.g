grammar QL;
options {backtrack=false; memoize=true; language = Java;}  

@header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.alg.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import java.util.Map;
import java.util.HashMap;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.types.*;
}

@members
{
    private final Map<String, Ident> variables = new HashMap<String, Ident>();
}

form returns [Form f] 
    :
      'form' Ident {$f = new Form($Ident.text); } '{' a = statements {$f.setStatements(a);} '}'
    ;


statements returns [Statements a]
    :
      {$a = new Statements();} ( q = question { $a.addQuestion(q); }  
    | ce = ifconditionalexpr { $a.addIfConditionalExpr(ce); })*
    ;

question returns [Question q]
    :
      (String {$q = new Question($String.text); }) ( d = declaration {$q.addDeclaration(d); }  
    | c = calculation { $q.addCalculation(c); } )
    ;
  
declaration returns [Declaration d]
    : 
      d1  = Ident ':' d2 = type
       { 
         Ident ident = new Ident($d1.text);      
         $d = new Declaration(ident, $type.type); 
         this.variables.put($d1.text, ident);
      }
    ;


type returns [Type type]
    :
      'integer' {$type = new IntType();}
    | 'boolean' {$type = new BoolType();}
    | 'string'  {$type = new StrType();}
    | 'money'   {$type = new MoneyType();}
    ;


ifconditionalexpr returns [IfConditionalExpr ifce]
    :
      'if' '(' ce1 = orExpr {$ifce = new IfConditionalExpr(ce1); } ')' '{' a = statements{ $ifce.setStatements(a); } '}' ('else' '{' (ce3 = question {$ifce.addElse(ce3); } )* '}')?
    ; 

calculation returns [Calculation c]
    :
      d1 = Ident  '='  or1 = orExpr {$c = new Calculation($d1.text, or1); }
    ;
    
primary returns [Expr result]
    : Int   { $result = new Int(Integer.parseInt($Int.text)); }
    | Ident { $result = new Ident($Ident.text); }
    | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
    | String{ $result = new Str($String.text); }
    | Money { $result = new Money(Double.parseDouble($Money.text)); }
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

Bool
    : 'true' | 'false'
    ;

Money 
    : Int'.'Int
    ;

String
    :  '"' (~('\\' | '"' | '\r' | '\n'))* '"'
    ;
  
WS  : (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

Comment 
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~('\n')* {$channel=HIDDEN;}
    ;

Ident
    :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

Int
    : ('0'..'9')+
    ;
    
