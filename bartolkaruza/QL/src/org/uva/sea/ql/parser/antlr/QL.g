grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result] 
    : 'form' lbl=Ident '{' qs=questions '}' { $result = new Form($lbl.text, $qs.result ); }
    ;

questions returns [Questions result]
	  : q=question qs=questions {$result = new Questions(); $result.add($q.result); $result.add($qs.result); }
	  | s=statement qs=questions {$result = new Questions($s.result); $result.add($qs.result); } 
	  | {return null; } // Empty string
	  ;

question returns [Question result]
    : label=Ident':' '\"' text=Ident* '\"' TYPE
    ;
    
statement returns [Stmt result] 
    : IF (x=expr) '{' qs=questions '}' { $result = new Stmt($x.result, $qs.result); }
    ;

primary returns [Expr result]
	  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
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
    
expr returns [Expr result]
    : e=orExpr { $result = $e.result; }
    ;
    
// Tokens

TYPE : 'boolean' | 'number' | 'textfield';

IF : 'if';

//NL : '\n' | '\r' { $channel=HIDDEN; };

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

COMMENT : '/*' .* '*/' {$channel=HIDDEN; };

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;