grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [QLForm result]
  : 'form' IDENT body { $result = new QLForm($IDENT.text, $body.result); }
  ;
  
body returns [Body result]
  @init { ArrayList<FormElement> tempList = new ArrayList<FormElement>(); }
  @after { $result = new Body(tempList); }
  : '{' (formElement { tempList.add($formElement.result); })* '}'
  ;
  
formElement returns [FormElement result]
  : question { $result = $question.result; }
  | ifStatement { $result = $ifStatement.result; }
  ;
  
question returns [Question result]
  @init { boolean computed = false; }
  : IDENT ':' STRING_LITERAL type
    ( '(' expression ')' { computed = true; } )?
    {
      if (computed) {
        $result = new ComputedQuestion(new Ident($IDENT.text),
          $STRING_LITERAL.text, $type.result, $expression.result);
      } else {
        $result = new Question(new Ident($IDENT.text),
          $STRING_LITERAL.text, $type.result);
      }
    }
  ;
  
type returns [ExprType result]
  : 'boolean' { $result = new BoolType(); }
  | 'string' { $result = new StrType(); }
  | 'integer' { $result = new IntType(); }
  ;

ifStatement returns [IfStatement result]
  : 'if' '(' expression ')' body
    {
      $result = new IfStatement($expression.result, $body.result);
    }
  ;

expression returns [Expr result]
  : INT   { $result = new Int(Integer.parseInt($INT.text)); }
  | IDENT { $result = new Ident($IDENT.text); }
  | STRING_LITERAL { $result = new Str($STRING_LITERAL.text); }
  | '(' x=orExpr ')' { $result = $x.result; }
  ;
    
unExpr returns [Expr result]
  : '+' x=unExpr { $result = new Pos($x.result); }
  | '-' x=unExpr { $result = new Neg($x.result); }
  | '!' x=unExpr { $result = new Not($x.result); }
  | x=expression    { $result = $x.result; }
  ;    
    
mulExpr returns [Expr result]
  : lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
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
  : lhs=addExpr { $result = $lhs.result; }
    ( op=('<' | '<=' | '>' | '>=' | '==' | '!=') rhs=addExpr 
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
  : lhs=relExpr { $result=$lhs.result; }
    ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
  ;
    

orExpr returns [Expr result]
  : lhs=andExpr { $result = $lhs.result; }
    ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
  ;

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel = HIDDEN; }
    ;

COMMENT :  '/*' .* '*/' { $channel = HIDDEN; }
        ;

IDENT : LETTER (LETTER | DIGIT | '_')*
      ;

INT :    DIGIT+
    ;

STRING_LITERAL  : '"'
                  (
                    '\\' '"' | ~('"'|'\r'|'\n')
                  )*
                  '"'
                ;

fragment DIGIT: '0'..'9';
fragment LETTER: 'a'..'z'|'A'..'Z';
