grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;
}
@parser::members {
    @Override
    public void reportError(RecognitionException e) {
        throw new RuntimeException(e);
    }
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
	@init { List<Statement> list = new ArrayList<Statement>(); }
	: 'form' Ident '{' (s=statement {list.add($s.result);})* '}' EOF { $result = new Form(new Ident($Ident.text), list); }
	;
	
statement returns [Statement result]
	: q=question { $result = $q.result; }
	| i=ifStatement { $result = $i.result; }
	;

ifStatement returns [IfStatement result]
	@init {List<Statement> list = new ArrayList<Statement>(); }
	: 'if' '(' x=orExpr ')' '{' (s=statement {list.add($s.result);})* '}' { $result = new IfStatement(x, list); }
	;
	
question returns [Question result]
	: Ident ':' Str type primary  { $result = new ComputableQuestion(new Ident($Ident.text, $type.result), new Str($Str.text), $type.result, $primary.result); }
	| Ident ':' Str type { $result = new AnswerableQuestion(new Ident($Ident.text, $type.result), new Str($Str.text), $type.result); }
	;

type returns [Type result]
	: 'boolean' { $result = new BoolType(); }
	| 'int' { $result = new IntType(); }
	| 'string' { $result = new StrType(); }
	| 'money' { $result = new MoneyType(); }
	;

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Str	  { $result = new Str($Str.text); }
  | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
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
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' { $channel=HIDDEN; }
     | '//' .* '\n' { $channel=HIDDEN; }
    ;

Bool: ('true'|'True'|'TRUE'|'false'|'False'|'FALSE');

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Str:   ('"' .* '"' | '“' .* '”');
