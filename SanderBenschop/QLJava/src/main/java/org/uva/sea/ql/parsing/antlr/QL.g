grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parsing.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.primary.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.parsing.error.*;
import org.uva.sea.ql.parsing.error.reporting.*;
}

@parser::members 
{
  private SyntacticErrorReporterImpl syntacticErrorReporter = null;
  
  public void setErrorReporter(SyntacticErrorReporterImpl syntacticErrorReporter) {
    this.syntacticErrorReporter = syntacticErrorReporter;
  }

  private String removeOuterQuotes(String original) {
    return original.substring(1, original.length() -1);
  }
  
  private SourceCodeInformation createSourceCodeInformation(Token token) {
    return new SourceCodeInformation(token.getLine(), token.getCharPositionInLine());
  }

  @Override
  public void reportError(RecognitionException e) {
    if (syntacticErrorReporter == null) {
      super.reportError(e);
    } else {
      String antlrMessage = getErrorMessage(e, this.getTokenNames());
      syntacticErrorReporter.reportError(new SyntacticQLError(e, antlrMessage));
    }
  }
}

@lexer::header
{
package org.uva.sea.ql.parsing.antlr;
}

form returns [Form result]
  : 'form' Ident '{' statementList '}'
	  {
	    $result = new Form($Ident.text, $statementList.result);
	  }
  ;
    
block returns [List<Statement> result]
  : '{' statementList '}'
	  {
	    $result = $statementList.result;
	  }
  ;
    
statementList returns [List<Statement> result]
  @init
  {
    $result = new ArrayList<Statement>();
  }
  : (stmnt=statement { result.add(stmnt); })*
  ;

statement returns [Statement result]
  : question { $result = $question.result; }
  | computation { $result = $computation.result; }
  | conditional { $result = $conditional.result; }
  ;

question returns [Question result]
  : Ident ':' Str datatype 
    {
	    Ident ident = new Ident($Ident.text, createSourceCodeInformation($Ident));
	    Str label = new Str(removeOuterQuotes($Str.text), createSourceCodeInformation($Str));
	    Type datatype = $datatype.result;
	    $result = new Question(ident, label, datatype);
    }
  ;
  
datatype returns [Type result]
  : 'boolean' { $result = new BooleanType(); }
  | 'string' { $result = new StringType(); }
  | 'integer' { $result = new IntegerType(); }
  ;
  
computation returns [Computation result]
  : Ident ':' Str '(' orExpr ')'
    {
      Ident ident = new Ident($Ident.text, createSourceCodeInformation($Ident));
      Str label = new Str(removeOuterQuotes($Str.text), createSourceCodeInformation($Str));
      Expression expression = $orExpr.result;
      $result = new Computation(ident, label, expression);
    }
  ;
  
conditional returns [Conditional result]
  : 'if' '(' condition=orExpr ')' success=block
    ( ('else') => 'else' failure=block { $result = new IfElseStatement(condition, success, failure); }
    | ( ) { $result = new IfStatement(condition, success); }
    )
  ;

primary returns [Expression result]
  : Int   { $result = new Int(Integer.parseInt($Int.text), createSourceCodeInformation($Int)); }
  | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text), createSourceCodeInformation($Bool)); }
  | Str   { $result = new Str(removeOuterQuotes($Str.text), createSourceCodeInformation($Str)); }
  | Ident { $result = new Ident($Ident.text, createSourceCodeInformation($Ident)); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;

unExpr returns [Expression result]
    :  op='+' x=unExpr { $result = new Positive($x.result, createSourceCodeInformation($op)); }
    |  op='-' x=unExpr { $result = new Negative($x.result, createSourceCodeInformation($op)); }
    |  op='!' x=unExpr { $result = new Not($x.result, createSourceCodeInformation($op)); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expression result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
	    { 
        SourceCodeInformation sourceCodeInformation = createSourceCodeInformation($op);
	      if ($op.text.equals("*")) {
	        $result = new Multiply($result, rhs, sourceCodeInformation);
	      }
	      if ($op.text.equals("/")) {
	        $result = new Divide($result, rhs, sourceCodeInformation);      
	      }
	    })*
    ;
    
  
addExpr returns [Expression result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
	    { 
	      SourceCodeInformation sourceCodeInformation = createSourceCodeInformation($op);
	      if ($op.text.equals("+")) {
	        $result = new Add($result, rhs, sourceCodeInformation);
	      }
	      if ($op.text.equals("-")) {
	        $result = new Subtract($result, rhs, sourceCodeInformation);      
	      }
	    })*
    ;
  
relExpr returns [Expression result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
	    { 
	      SourceCodeInformation sourceCodeInformation = createSourceCodeInformation($op);
	      if ($op.text.equals("<")) {
	        $result = new LessThan($result, rhs, sourceCodeInformation);
	      }
	      if ($op.text.equals("<=")) {
	        $result = new LessThanOrEqualTo($result, rhs, sourceCodeInformation);      
	      }
	      if ($op.text.equals(">")) {
	        $result = new GreaterThan($result, rhs, sourceCodeInformation);
	      }
	      if ($op.text.equals(">=")) {
	        $result = new GreaterThanOrEqualTo($result, rhs, sourceCodeInformation);      
	      }
	      if ($op.text.equals("==")) {
	        $result = new EqualTo($result, rhs, sourceCodeInformation);
	      }
	      if ($op.text.equals("!=")) {
	        $result = new NotEqualTo($result, rhs, sourceCodeInformation);
	      }
	    })*
    ;
    
andExpr returns [Expression result]
    :   lhs=relExpr { $result=$lhs.result; } ( op='&&' rhs=relExpr { $result = new And($result, rhs, createSourceCodeInformation($op)); } )*
    ;
    

orExpr returns [Expression result]
    :   lhs=andExpr { $result = $lhs.result; } ( op='||' rhs=andExpr { $result = new Or($result, rhs, createSourceCodeInformation($op)); } )*
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