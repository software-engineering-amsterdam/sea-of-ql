grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.primary.*;
import org.uva.sea.ql.ast.unary.*;
import org.uva.sea.ql.ast.binary.*;
import org.uva.sea.ql.ast.statement.*;
}

@parser::members 
{
  private String removeOuterQuotes(String original) {
    return original.substring(1, original.length()-1);
  }
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
  : 'form' Ident '{' statementList '}'
	  {
	    $result = new Form($Ident.text, $statementList.result);
	  }
  ;
    
block returns [List<QLStatement> result]
  : '{' statementList '}'
	  {
	    $result = $statementList.result;
	  }
  ;
    
statementList returns [List<QLStatement> result]
  @init
  {
    $result = new ArrayList<QLStatement>();
  }
  : (stmnt=statement { result.add(stmnt); })*
  ;

statement returns [QLStatement result]
  : question { $result = $question.result; }
  | computation { $result = $computation.result; }
  | conditional { $result = $conditional.result; }
  ;

question returns [Question result]
  : Ident ':' Str datatype 
    {
	    Ident ident = new Ident($Ident.text);
	    Str label = new Str(removeOuterQuotes($Str.text));
	    Class<? extends Datatype<?>> datatype = $datatype.result;
	    $result = new Question(ident, label, datatype);
    }
  ;
  
datatype returns [Class<? extends Datatype<?>> result]
  : 'boolean' { $result = Bool.class; }
  | 'string' { $result = Str.class; }
  | 'integer' { $result = Int.class; }
  ;
  
computation returns [Computation result]
  : Ident ':' Str '(' orExpr ')'
    {
      Ident ident = new Ident($Ident.text);
      Str label = new Str(removeOuterQuotes($Str.text));
      ASTNode orExpression = $orExpr.result;
      $result = new Computation(ident, label, orExpression);
    }
  ;
  
conditional returns [Conditional result]
  : 'if' '(' condition=orExpr ')' success=block
    ( ('else') => 'else' failure=block { $result = new IfElseStatement(condition, success, failure); }
    | ( ) { $result = new IfStatement(condition, success); }
    )
  ;

primary returns [ASTNode result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | Str   { $result = new Str(removeOuterQuotes($Str.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;

unExpr returns [ASTNode result]
    :  '+' x=unExpr { $result = new Positive($x.result); }
    |  '-' x=unExpr { $result = new Negative($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [ASTNode result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
	    { 
	      if ($op.text.equals("*")) {
	        $result = new Multiply($result, rhs);
	      }
	      if ($op.text.equals("/")) {
	        $result = new Divide($result, rhs);      
	      }
	    })*
    ;
    
  
addExpr returns [ASTNode result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
	    { 
	      if ($op.text.equals("+")) {
	        $result = new Add($result, rhs);
	      }
	      if ($op.text.equals("-")) {
	        $result = new Subtract($result, rhs);      
	      }
	    })*
    ;
  
relExpr returns [ASTNode result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
	    { 
	      if ($op.text.equals("<")) {
	        $result = new LessThan($result, rhs);
	      }
	      if ($op.text.equals("<=")) {
	        $result = new LessThanOrEqualTo($result, rhs);      
	      }
	      if ($op.text.equals(">")) {
	        $result = new GreaterThan($result, rhs);
	      }
	      if ($op.text.equals(">=")) {
	        $result = new GreaterThanOrEqualTo($result, rhs);      
	      }
	      if ($op.text.equals("==")) {
	        $result = new EqualTo($result, rhs);
	      }
	      if ($op.text.equals("!=")) {
	        $result = new NotEqualTo($result, rhs);
	      }
	    })*
    ;
    
andExpr returns [ASTNode result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [ASTNode result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~('\n')* {$channel=HIDDEN;} 
    ;
    
Bool: 'true' | 'false';
Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Str: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment
EscapedCharacterSequence: '\\' ('\"' | '\\');

Int: ('0'..'9')+;