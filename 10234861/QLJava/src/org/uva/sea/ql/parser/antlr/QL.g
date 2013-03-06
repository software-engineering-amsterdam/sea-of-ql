grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stmnt.*;
import org.uva.sea.ql.ast.types.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

ifStatement returns [IfStatement result]
: 'if' '(' condition=orExpr ')' body {result = new IfStatement(condition, $body.result); }
;

question returns [Question result]
: ( computedQuestion { result = $computedQuestion.result; } | normalQuestion { result = $normalQuestion.result; } )
;

normalQuestion returns [Question result]
: Ident ':' String type
{ result = new Question(new Ident($Ident.text), new StringLiteral($String.text), $type.result); }
;

computedQuestion returns [ComputedQuestion result]
: Ident ':' String type '(' orExpr ')'
{ result = new ComputedQuestion(new Ident($Ident.text), new StringLiteral($String.text), $type.result, $orExpr.result); }
;

type returns [Type result]
: 'int' { $result = new IntType(); }
| 'bool' { $result = new BoolType(); }
| 'string' { $result = new StringType(); }
;

statement returns [Statement result]
: (question { $result = $question.result; }
| ifStatement { $result = $ifStatement.result; } )
;

body returns [Body result]
@init { List<Statement> statements = new ArrayList<Statement>(); }
: '{' ( statement { statements.add($statement.result); } )* '}' { $result = new Body(statements); }
;

form returns [Form result]
    : 'form' Ident body { $result = new Form (new Ident($Ident.text), $body.result); }
    ;

primary returns [Expr result]
   : Int { $result = new IntLiteral(Integer.parseInt($Int.text)); }
   | Bool { $result = new BoolLiteral ($Bool.text); }
   | String { $result = new StringLiteral ($String.text); }
   | Ident { $result = new Ident($Ident.text); }
   | '(' x=orExpr ')'{ $result = $x.result; }
   ;
    
unExpr returns [Expr result]
    : '+' x=unExpr { $result = new Pos($x.result); }
    | '-' x=unExpr { $result = new Neg($x.result); }
    | '!' x=unExpr { $result = new Not($x.result); }
    | x=primary { $result = $x.result; }
    ;
    
mulExpr returns [Expr result]
    : lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr
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
    : lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
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
    : lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr
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
    : lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result]
    : lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;
    
// Tokens
WS : (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

MLINE_COMMENT : '/*' .* '*/' { $channel=HIDDEN; };
    
SLINE_COMMENT : '//' .* ('\n'|'\r') { $channel=HIDDEN; };

Bool: ('true' | 'false');

String: '"' ~('\n' | '\r' | '"')* '"';

Int: ('0'..'9')+;

Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
