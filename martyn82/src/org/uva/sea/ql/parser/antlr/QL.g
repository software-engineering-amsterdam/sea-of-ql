grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.declaration.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;
import org.uva.sea.ql.ast.type.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expression result]
  : Bool             { $result = new org.uva.sea.ql.ast.expression.value.Bool( Boolean.parseBoolean( $Bool.text ) ); }
  | Int              { $result = new org.uva.sea.ql.ast.expression.value.Int( Integer.parseInt( $Int.text ) ); }
  | strExpr          { $result = $strExpr.result; }
  | Ident            { $result = new Ident( $Ident.text ); }
  | '(' x=orExpr ')' { $result = $x.result; }
  ;

strExpr returns [org.uva.sea.ql.ast.expression.value.Str result]
  : Str { $result = new org.uva.sea.ql.ast.expression.value.Str( $Str.text.substring( 1, $Str.text.length() - 1 ) ); }
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

varDecl returns [VarDeclaration result]
    : strExpr Ident ':' typeDecl {
          $result = new VarDeclaration( new Ident( $Ident.text ), $typeDecl.result );
      }
    ;

typeDecl returns [Type result]
    :  Type {
           if ( $Type.text.equals( "boolean" ) ) {
               $result = new org.uva.sea.ql.ast.type.Bool();
           }
           else if ( $Type.text.equals( "integer" ) ) {
               $result = new org.uva.sea.ql.ast.type.Int();
           }
           else if ( $Type.text.equals( "string" ) ) {
               $result = new org.uva.sea.ql.ast.type.Str();
           }
       }
    ;

    
// Tokens
Type
  : 'boolean' | 'integer' | 'string'
  ;

WS  : (' ' | '\t' | NEWLINE) { $channel=HIDDEN; }
    ;

COMMENT 
    : ('//' ~(NEWLINE)* | '/*' .* '*/') {$channel=HIDDEN;}
    ;

fragment NEWLINE
    : ('\r' | '\n')
    ;

Bool:   'true' | 'false';
Str:    '\"' ('\\"' | ~'\"')* '\"';
Ident:  ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Int:    ('0'..'9')+;
