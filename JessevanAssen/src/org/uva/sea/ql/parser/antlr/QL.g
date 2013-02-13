grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@lexer::members {
  private ErrorReporter errorReporter = null;
  public void setErrorReporter(ErrorReporter errorReporter) {
    this.errorReporter = errorReporter;
  }

  @Override
  public void reportError(RecognitionException e) {
    if(errorReporter != null)
      errorReporter.reportError(e.toString());
    else
      throw new RuntimeException(e);
  }
}
@parser::members {
  private ErrorReporter errorReporter = null;
  public void setErrorReporter(ErrorReporter errorReporter) {
    this.errorReporter = errorReporter;
  }

  @Override
  public void reportError(RecognitionException e) {
    if(errorReporter != null)
      errorReporter.reportError(e.toString());
    else
      throw new RuntimeException(e);
  }
}


primary returns [Expression result]
    : Bool          { $result = new org.uva.sea.ql.ast.expression.value.Bool(Boolean.parseBoolean($Bool.text)); }
    | Int           { $result = new org.uva.sea.ql.ast.expression.value.Int(Integer.parseInt($Int.text)); }
    | strExpression { $result = $strExpression.result; }
    | Identifier    { $result = new Identifier($Identifier.text); }
    | '(' x=orExpression ')'{ $result = $x.result; }
    ;
    
strExpression returns [org.uva.sea.ql.ast.expression.value.Str result]
    : Str   { $result = new org.uva.sea.ql.ast.expression.value.Str($Str.text.substring(1, $Str.text.length() - 1)); }
    ;    
    
unaryExpression returns [Expression result]
    :  '+' x=unaryExpression { $result = new Positive($x.result); }
    |  '-' x=unaryExpression { $result = new Negative($x.result); }
    |  '!' x=unaryExpression { $result = new Not($x.result); }
    |  primary               { $result = $primary.result; }
    ;    
    
multiplyExpression returns [Expression result]
    :   lhs=unaryExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unaryExpression 
    { 
      if ($op.text.equals("*")) {
        $result = new Multiply($result, rhs);
      }
      if ($op.text.equals("/")) {
        $result = new Divide($result, rhs);      
      }
    })*
    ;
    
  
addExpression returns [Expression result]
    :   lhs=multiplyExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=multiplyExpression
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Subtract($result, rhs);      
      }
    })*
    ;
  
relationExpression returns [Expression result]
    :   lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
    { 
      if ($op.text.equals("<")) {
        $result = new LesserThan($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LesserThanOrEqualTo($result, rhs);      
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
    
andExpression returns [Expression result]
    :   lhs=relationExpression { $result=$lhs.result; } ( '&&' rhs=relationExpression { $result = new And($result, rhs); } )*
    ;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*
    ;

form returns [Form result]
    : 'form' Identifier '{' statements '}' { 
        $result = new Form(new Identifier($Identifier.text), $statements.result); 
      }
    ;
    
statements returns [Statement result]
    @init {
        ArrayList<Statement> statements = new ArrayList<Statement>();
    }
    @after {
        if(statements.isEmpty())
            result = new NullStatement();
        else if(statements.size() == 1)
            result = statements.get(0);
        else
            result = new CompositeStatement(statements);
    }
    : (statement { statements.add($statement.result); })*
    ;
    
statement returns [Statement result]
    : ifStatement { $result = $ifStatement.result; }
    | questionStatement { $result = $questionStatement.result; }
    | computedStatement { $result = $computedStatement.result; }
    | storedExpressionStatement { $result = $storedExpressionStatement.result; }
    ;
    
storedExpressionStatement returns [StoredExpression result]
    : Identifier '=' orExpression { $result = new StoredExpression(new Identifier($Identifier.text), $orExpression.result); }
    ;
    
questionStatement returns [Question result]
    : strExpression Identifier ':' typeDeclaration { 
        $result = new Question($strExpression.result.getValue(), new Identifier($Identifier.text), $typeDeclaration.result); }
    ;

Type: 'string'|'boolean'|'integer'; 
typeDeclaration returns [Type result]
    : Type {
        if($Type.text.equals("boolean"))
          $result = new org.uva.sea.ql.ast.type.Boolean();
        else if($Type.text.equals("integer"))
          $result = new org.uva.sea.ql.ast.type.Integer();
        else if($Type.text.equals("string"))
          $result = new org.uva.sea.ql.ast.type.String();
      }
    ;

computedStatement returns [Computed result]
    : strExpression orExpression { $result = new Computed($strExpression.result.getValue(), $orExpression.result); }
    ;
   
ifStatement returns [Statement result]
    : 'if' '(' orExpression ')' '{' ifElements = statements '}' 'else' elseElement = ifStatement
        { $result = new IfElse($orExpression.result, $ifElements.result, $elseElement.result); }
    | 'if' '(' orExpression ')' '{' ifElements = statements '}' 'else' '{' elseElements = statements'}' 
        { $result = new IfElse($orExpression.result, $ifElements.result, $elseElements.result); }
    | 'if' '(' orExpression ')' '{' statements '}' 
        { $result = new If($orExpression.result, $statements.result); }
    ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~NewLine* {$channel=HIDDEN;}
    ;

NewLine: '\n' | '\r\n';

Bool: 'true'|'false';

Str: '\"' ('\\"'|~'\"')* '\"';

Identifier:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;