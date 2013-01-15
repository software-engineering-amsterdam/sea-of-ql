grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
  : 'form' id=Ident { $result = new Form(id); } LBrace stmt=statement { $result.addStatement(stmt); } RBrace
  ;

statement returns [Statement result]
  : id=Ident Colon lbl=String tp=type { $result = new Question(id, lbl, tp); }
  |
  ;
  
type returns [Type result]
  : 'string'  { $result = new TypeString(); }  ( cp=computation { $result.computation(cp); } )? 
  : 'boolean' { $result = new TypeBoolean(); } ( cp=computation { $result.computation(cp); } )? 
  : 'integer' { $result = new TypeInteger(); } ( cp=computation { $result.computation(cp); } )? 
  ;
  
computation returns [Computation result]
  : '(' x=orExpr ')' { $result = $x.result; }
  ;

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')' { $result = $x.result; }
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

    
// Tokens
If      : 'if' ;
Else    : 'else' ; 

LBrace  : '{' ;
RBrace  : '}' ;
Colon   : ':' ;

Bool    : 'true' | 'false' ;
Int     : '-' ? Digit+ ;    
Ident   : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | Int)* ;  
String
@after { 
  setText(getText().substring(1, getText().length()-1).replaceAll("\\\\(.)", "$1")); 
}  
        :  '"'  (~('"' | '\\')  | '\\' .)* '"'   
        |  '\'' (~('\'' | '\\') | '\\' .)* '\''   
        ;
            
WS      :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; } ;

Comment : '//' ~('\r' | '\n')*  {$channel=HIDDEN;}  
        |  '/*' .* '*/'         {$channel=HIDDEN;} 
        ;   