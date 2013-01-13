grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expression result]
  : Bool             { $result = new Bool( Boolean.parseBoolean( $Bool.text ) ); }
  | Int              { $result = new Int( Integer.parseInt( $Int.text ) ); }
  | strExpr          { $result = $strExpr.result; }
  | Ident            { $result = new Ident( $Ident.text ); }
  | '(' x=orExpr ')' { $result = $x.result; }
  ;

strExpr returns [Str result]
  : Str { $result = new Str( $Str.text.substring( 1, $Str.text.length() - 1 ) ); }
  ;
    
unExpr returns [Expression result]
    :  '+' x=unExpr { $result = new Pos( $x.result ); }
    |  '-' x=unExpr { $result = new Neg( $x.result ); }
    |  '!' x=unExpr { $result = new Not( $x.result ); }
    |  x=primary    { $result = $x.result; }
    ;
    
mulExpr returns [Expression result]
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
    
  
addExpr returns [Expression result]
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
  
relExpr returns [Expression result]
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
    
andExpr returns [Expression result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expression result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;

Bool:   'true'|'false';

Str:    '\"' ('\\"'|~'\"')* '\"';

Ident:  ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int:    ('0'..'9')+;