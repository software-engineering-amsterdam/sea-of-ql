grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.value.Number;
import org.uva.sea.ql.ast.value.*;
import org.uva.sea.ql.ast.expr.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result] 
    : 'form' lbl=Ident '{' stmts=statements '}' { $result = new Form($lbl.text, $stmts.result ); }
    ;

statements returns [List<Statement> result]
    :  { $result = new ArrayList<Statement>(); } (stmt=statement {$result.add($stmt.result); })*  
    ;

statement returns [Statement result] 
    : firstToken=IF (x=expr) '{' stmts=statements '}' { $result = new ConditionalStatement($x.result, $stmts.result, $firstToken.line); }
    | question {$result = $question.result; }
    ;

question returns [Question result]
    : name=Ident':' '\"' label=Ident* '\"' TYPE {
      $result = new Question($name.text, $label.text, $name.line);
      if ($TYPE.text.equals("boolean")) {
        $result.setValue(new Bool());
      }
      if ($TYPE.text.equals("integer")) {
        $result.setValue(new Number());
      }
      if ($TYPE.text.equals("string")) {
        $result.setValue(new TextString());
      }
      if ($TYPE.text.equals("money")) {
        $result.setValue(new Money());
      }
    }
    ;
    

primary returns [Expr result]
	  : Int   { $result = new Int(Integer.parseInt($Int.text), $Int.line); }
	  | Ident { $result = new Ident($Ident.text, $Ident.line); }
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

TYPE : 'boolean' | 'integer' | 'string' | 'money';

IF : 'if';

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

COMMENT : '/*' .* '*/' {$channel=HIDDEN; };

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;