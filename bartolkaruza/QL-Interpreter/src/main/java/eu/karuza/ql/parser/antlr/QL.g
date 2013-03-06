grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package eu.karuza.ql.parser.antlr;
import eu.karuza.ql.ast.*;
import eu.karuza.ql.ast.expr.*;
import eu.karuza.ql.ast.value.*;
import eu.karuza.ql.ast.type.*;
import eu.karuza.ql.ast.statement.*;
import eu.karuza.ql.error.*;
}

@lexer::header
{
package eu.karuza.ql.parser.antlr;
import eu.karuza.ql.error.*;
}

@parser::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e); 
  }
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e); 
  }
}

form returns [Form result] 
    : 'form' lbl=Ident '{' stmts=statements '}' { $result = new Form($lbl.text, $stmts.result ); }
    ;

statements returns [List<Statement> result]
    :  { $result = new ArrayList<Statement>(); } (stmt=statement {$result.add($stmt.result); })*  
    ;

statement returns [Statement result] 
    : firstToken=IF (x=expr) '{' ifstmts=statements '}' ELSE '{' elsestmts=statements '}' {$result = new IfElseConditionalStatement($x.result, $ifstmts.result, $elsestmts.result, $firstToken.line); }
    | firstToken=IF (x=expr) '{' stmts=statements '}' { $result = new IfConditionalStatement($x.result, $stmts.result, $firstToken.line); }
    | question {$result = $question.result; }
    ;

question returns [Question result]
    : name=Ident':' label=STRING_VALUE qt=type 
      { $result = new AnswerableQuestion($name.text, $label.text.substring(1, $STRING_VALUE.text.length() - 1), $qt.result, $name.line ); }
    | name=Ident':' label=STRING_VALUE ex=expr 
      { $result = new ComputedQuestion($name.text, $label.text.substring(1, $STRING_VALUE.text.length() - 1), $ex.result, $name.line ); }   
    ;

type returns [Type result]
    : TYPE {
      if ($TYPE.text.equals("boolean")) {
        $result = new BoolType();
      }
      if ($TYPE.text.equals("integer")) {
        $result = new IntType();
      }
      if ($TYPE.text.equals("string")) {
        $result = new TextType();
      }
      if ($TYPE.text.equals("money")) {
        $result = new MoneyType();
      }};
    

primary returns [Expr result]
	  : INT_VALUE   { $result = new Int($INT_VALUE.line, $INT_VALUE.text); }
	  | STRING_VALUE { $result = new Text($STRING_VALUE.line, $STRING_VALUE.text.substring(1, $STRING_VALUE.text.length() - 1)); }
	  | BOOLEAN_VALUE { $result = new Bool($BOOLEAN_VALUE.line, $BOOLEAN_VALUE.text); }
	  | MONEY_VALUE { $result = new Money($MONEY_VALUE.line, $MONEY_VALUE.text); }
	  | Ident { $result = new Ident($Ident.line, $Ident.text); }
	  | '(' x=orExpr ')'{ $result = $x.result; }
	  ;
    
unExpr returns [Expr result]
    :  op='+' x=unExpr { $result = new Pos($op.line, $x.result); }
    |  op='-' x=unExpr { $result = new Neg($op.line, $x.result); }
    |  op='!' x=unExpr { $result = new Not($op.line, $x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result = $lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($op.line, $result, rhs);
      }
      if ($op.text.equals("/")) {
        $result = new Div($op.line, $result, rhs);      
      }
    })*
    ;
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($op.line, $result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($op.line, $result, rhs);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($op.line, $result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($op.line, $result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($op.line, $result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($op.line, $result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($op.line, $result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($op.line, $result, rhs);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result = $lhs.result; } ( op='&&' rhs=relExpr { $result = new And($op.line, $result, rhs); } )*
    ;

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( op='||' rhs=andExpr { $result = new Or($op.line, $result, rhs); } )*
    ;
    
expr returns [Expr result]
    : e=orExpr { $result = $e.result; }
    ;
    
// Tokens

TYPE : 'boolean' | 'integer' | 'string' | 'money';

IF : 'if';

ELSE : 'else';

BOOLEAN_VALUE: 'true' | 'false';

STRING_VALUE : '\"' .* '\"';

MONEY_VALUE : ('0'..'9')+ '.' ('0'..'9')+;

INT_VALUE: ('0'..'9')+;

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

NL : ('\n' | '\r' | '\n\r' ) { $channel=HIDDEN; };

WS  :	(' ' | '\t' ) { $channel=HIDDEN; };

COMMENT : '/*' .* '*/' | '//' .* NL {$channel=HIDDEN; };