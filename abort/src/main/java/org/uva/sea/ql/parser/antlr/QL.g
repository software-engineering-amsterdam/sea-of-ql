grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.parser.errors.*;
import org.uva.sea.ql.parser.errors.base.*;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.types.literals.*;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.conditionals.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.parser.errors.*;
import org.uva.sea.ql.parser.errors.base.*;
}

@lexer::members {
  // Syntax error reporter to use instead of the default (see: http://www.antlr.org/wiki/display/ANTLR3/Error+reporting+and+recovery)
  private ISyntaxErrorReporter syntaxErrorReporter;
  
  public void setErrorReporter(final ISyntaxErrorReporter syntaxErrorReporter) {
    this.syntaxErrorReporter = syntaxErrorReporter;
  }

  @Override
  public void reportError(RecognitionException e) {
    if (syntaxErrorReporter == null) {
      super.reportError(e);
      return;
    }
    final String message = getErrorMessage(e, this.getTokenNames());
    syntaxErrorReporter.reportError(new SyntaxErrorMessage(new SyntaxPosition(e.line, e.charPositionInLine), message));
  }
}

@parser::members {
  // Syntax error reporter to use instead of the default (see: http://www.antlr.org/wiki/display/ANTLR3/Error+reporting+and+recovery)
  private ISyntaxErrorReporter syntaxErrorReporter;
  
  public void setErrorReporter(final ISyntaxErrorReporter syntaxErrorReporter) {
    this.syntaxErrorReporter = syntaxErrorReporter;
  }
  
  private SyntaxPosition getSyntaxPosition(final Token token) {
    return new SyntaxPosition(token.getLine(), token.getCharPositionInLine());
	}
	
	private String getUnquotedString(final String text) {
	  return text.substring(1, text.length() - 1);
	}

	@Override
  public void reportError(RecognitionException e) {
    if (syntaxErrorReporter == null) {
      super.reportError(e);
      return;
    }
    
    final String message = getErrorMessage(e, this.getTokenNames());
    syntaxErrorReporter.reportError(new SyntaxErrorMessage(new SyntaxPosition(e.line, e.charPositionInLine), message));
  }
}

form returns [Form result]
  : formStatement='form' Ident '{' formStatements=statements '}' {    
    $result = new Form($Ident.text, formStatements, getSyntaxPosition($formStatement));
  };

statements returns [List<Statement> results]
  @init { $results = new ArrayList<Statement>(); }
  : (statement { $results.add($statement.result); })*;

statement returns [Statement result]
    : question { $result = $question.result; }
    | computation { $result = $computation.result; }
    | ifStatement { $result = $ifStatement.result; };

ifStatement returns [IfStatement result]
    : line=('if' '(' condition=orExpression ')' '{' successStatements=statements '}' 'else' '{' elseStatements=statements '}')
    {
      $result = new IfThenElse($condition.result, successStatements, elseStatements, getSyntaxPosition($line));
    }
    | line=('if' '(' condition=orExpression ')' '{' successStatements=statements '}')
    {
      $result = new IfThen($condition.result, successStatements, getSyntaxPosition($line));
    };

computation returns [Computation result]
  : id=Ident ':' String parameter=dataType '(' operation=orExpression ')' {
    final Ident ident = new Ident($id.text, getSyntaxPosition($id));
    $result = new Computation(ident, getUnquotedString($String.text), $parameter.result, $operation.result, getSyntaxPosition($id));
  };

question returns [Question result]
  : id=Ident ':' String parameter=dataType {
    final Ident ident = new Ident($id.text, getSyntaxPosition($id)); 
    $result = new Question(ident, getUnquotedString($String.text), $parameter.result, getSyntaxPosition($id));
  };
  
dataType returns [DataType result]
 : Type {
    if ($Type.text.equals("string")) $result = new StringType();
    else if ($Type.text.equals("integer")) $result = new IntType();
    else if ($Type.text.equals("money")) $result = new MoneyType();
    else if ($Type.text.equals("boolean")) $result = new BoolType();
 };
 
primary returns [Expression result]
  : Int   { $result = new IntLiteral(Integer.parseInt($Int.text), getSyntaxPosition($Int)); }
  | Money { $result = new MoneyLiteral($Money.text, getSyntaxPosition($Money)); }
  | Bool { $result = new BoolLiteral(Boolean.parseBoolean($Bool.text), getSyntaxPosition($Bool)); }
  | Ident { $result = new Ident($Ident.text, getSyntaxPosition($Ident)); }
  | String { $result = new StringLiteral(getUnquotedString($String.text), getSyntaxPosition($String)); }
  | '(' orExpression ')' { $result = $orExpression.result; };

unExpression returns [Expression result]
    :  op='+' x=unExpression { $result = new Pos($x.result, getSyntaxPosition($op)); }
    |  op='-' x=unExpression { $result = new Neg($x.result, getSyntaxPosition($op)); }
    |  op='!' x=unExpression { $result = new Not($x.result, getSyntaxPosition($op)); }
    |  x=primary    { $result = $x.result; };    
    
mulExpression returns [Expression result]
    :   lhs=unExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpression 
    { 
      final SyntaxPosition syntaxPosition = getSyntaxPosition($op);

      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs, syntaxPosition);
      }
      if ($op.text.equals("/")) {
        $result = new Div($result, rhs, syntaxPosition); 
      }
    })*;

addExpression returns [Expression result]
    :   lhs=mulExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpression
    { 
      final SyntaxPosition syntaxPosition = getSyntaxPosition($op);
    
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs, syntaxPosition);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs, syntaxPosition);
      }
    })*;
  
relExpression returns [Expression result]
    :   lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
    {
      final SyntaxPosition syntaxPosition = getSyntaxPosition($op);
    
      if ($op.text.equals("<")) {
        $result = new LT($result, rhs, syntaxPosition);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, rhs, syntaxPosition);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, rhs, syntaxPosition);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, rhs, syntaxPosition);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, rhs, syntaxPosition);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, rhs, syntaxPosition);
      }
    })*;
    
andExpression returns [Expression result]
    :   lhs=relExpression { $result=$lhs.result; } ( op='&&' rhs=relExpression { $result = new And($result, rhs, getSyntaxPosition($op)); } )*;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( op='||' rhs=andExpression { $result = new Or($result, rhs, getSyntaxPosition($op)); } )*;


// Tokens
COMMENT 
     : '/*' .* '*/' { $channel=HIDDEN; }  // multi line
     | '//' ~('\n'|'\r')* { $channel=HIDDEN; } // single line
;

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

Type: 'boolean' | 'integer' | 'money' | 'string';

Bool: 'TRUE' | 'FALSE' | 'true' | 'false';

Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Money: ('0'..'9')+ ('.' ('0'..'9')+)?;

String: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment EscapedCharacterSequence: '\\' ('\"' | '\\');