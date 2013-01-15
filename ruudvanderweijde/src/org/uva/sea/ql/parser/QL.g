grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser;
}

form returns [Form result]
  : 'form' Ident OBrace statements=block CBrace
	  { 
	    $result = new Form(new Ident($Ident.text), $statements.result); 
	  } 
  ;

block returns [List<Statement> result]
  @init
  {
      $result = new ArrayList<Statement>();
  }
  : OBrace ( stmt=statement { $result.add(stmt); } )* CBrace
  ;
  
statement returns [Statement result]
  : q=question    { $result = $q.result; }
  | i=ifStatement { $result = $i.result; }
  ;
  
ifStatement returns [Statement result]
  : If OParen condition=orExpr CParen ifBlock=block
    ( (Else)=> Else elseBlock=block
    | ( ) // nothing
    )
    {
      if (elseBlock != null) {
        $result = new ifElse(condition, ifBlock, elseBlock);
      } else {
        $result = new ifThen(condition, ifBlock);
      }
    }
  ;
  
question returns [Statement result]
  : Ident Colon String tp=type { $result = new Question(new Ident($Ident.text), $String.text, tp); }
  ;

type returns [Type result]
  : 'string'  { $result = new StringType(); }  ( cp=computation { $result.add(cp); } )? 
  | 'boolean' { $result = new BooleanType(); } ( cp=computation { $result.add(cp); } )? 
  | 'integer' { $result = new IntegerType(); } ( cp=computation { $result.add(cp); } )? 
  ;
  
computation returns [Computation result]
  : '(' expr=orExpr ')' { $result = new Computation(expr); }
  ;

primary returns [Expr result]
  : Int     { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident   { $result = new Ident($Ident.text); }
  | Bool    { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | String  { $result = new StringLiteral($String.text); }
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

OBrace  : '{' ;
CBrace  : '}' ;
OParen  : '(' ;
CParen  : ')' ;
Colon   : ':' ;

Bool    : 'true' | 'false' ;
Int     : '-'? Digit+ ;    
Ident   : (Letter | '_') (Letter | Digit | '_')* ;  
String
@after { 
  setText(getText().substring(1, getText().length()-1).replaceAll("\\\\(.)", "$1")); 
}  
        :  '"'  (~('"' | '\\')  | '\\' .)* '"'   
        |  '\'' (~('\'' | '\\') | '\\' .)* '\''   
        ;
            
WS      :	(' ' | '\t' | '\n' | '\r')  { $channel=HIDDEN; } ;
SComment: '//' ~('\r' | '\n')*        { $channel=HIDDEN; } ;  
MComment: '/*' .* '*/'                { $channel=HIDDEN; } ;
        
fragment Digit  : '0'..'9' ;
fragment Letter : ('a'..'z' | 'A'..'Z') ;