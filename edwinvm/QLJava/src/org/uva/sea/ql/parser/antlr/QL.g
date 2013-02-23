grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.forms.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.*;
import org.uva.sea.ql.ast.expressions.binary.logical.*;
import org.uva.sea.ql.ast.expressions.binary.relational.*;
import org.uva.sea.ql.ast.expressions.literal.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.statements.conditions.*;
import org.uva.sea.ql.ast.statements.questions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
import java.util.ArrayList;
import java.util.List;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
    :   'form' Ident '{' statementBody '}' { $result = new Form(new Ident($Ident.text), $statementBody.result); }
    ;

formStatement returns [FormStatement result]
    :   question       { $result = $question.result; }
    |   conditionBlock { $result = $conditionBlock.result; }
    ;

question returns [Question result]
    :   String Ident ':' type     { $result = new AnswerableQuestion(new org.uva.sea.ql.ast.expressions.literal.Str($String.text), new Ident($Ident.text), $type.result); }
    |   String Ident '=' expression { $result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str($String.text), new Ident($Ident.text), $expression.result); }
    ;

conditionBlock returns [ConditionBlock result]
    :   'if' '(' condition=expression ')' ifBody=statementBody 'else' elseBody=statementBody
        { $result = new IfThenElseStatement(condition, ifBody, elseBody); }
    |   'if' '(' condition=expression ')' ifBody=statementBody
        { $result = new IfThenStatement(condition, ifBody); }
    ;

statementBody returns [StatementBody result]
	@init  { StatementBody statements = new StatementBody(); }
    @after { $result = statements; }
    :   '{' (statement=formStatement { statements.add(statement); })+ '}'
    |       (statement=formStatement { statements.add(statement); })+
    ;

primary returns [Expression result]
    :   Int    { $result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt($Int.text)); }
    |   Bool   { $result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean($Bool.text)); }
    |   Money  { $result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble($Money.text.replace(',', '.'))); }
    |   String { $result = new org.uva.sea.ql.ast.expressions.literal.Str($String.text); }
    |   Ident  { $result = new Ident($Ident.text); }
    |   '(' e=expression ')'{ $result = $e.result; }
    ;
    
unaryExpression returns [Expression result]
    :   '+' e=unaryExpression { $result = new PositiveExpression($e.result); }
    |   '-' e=unaryExpression { $result = new NegativeExpression($e.result); }
    |   '!' e=unaryExpression { $result = new NegationalExpression($e.result); }
    |   e=primary             { $result = $e.result; }
    ;    
    
multiplicationExpression returns [Expression result]
    :   leftHandSide  = unaryExpression { $result = leftHandSide; } ( op = ('*' | '/') 
        rightHandSide = unaryExpression 
    { 
        if ($op.text.equals("*")) { $result = new Multiplication(leftHandSide, rightHandSide); }
        if ($op.text.equals("/")) { $result = new Division(leftHandSide,       rightHandSide); }
    })*
    ;
    
additionExpression returns [Expression result]
    :   leftHandSide  = multiplicationExpression { $result = leftHandSide; } ( op = ('+' | '-') 
        rightHandSide = multiplicationExpression
    { 
        if ($op.text.equals("+")) { $result = new Addition(leftHandSide,    rightHandSide); }
        if ($op.text.equals("-")) { $result = new Subtraction(leftHandSide, rightHandSide); }
    })*
    ;
  
relationalExpression returns [Expression result]
    :   leftHandSide  = additionExpression { $result = leftHandSide; } ( op = ('<'|'<='|'>'|'>='|'=='|'!=') 
        rightHandSide = additionExpression 
    { 
        if ($op.text.equals("<"))  { $result = new LessThanExpression(leftHandSide,             rightHandSide); }
        if ($op.text.equals("<=")) { $result = new LessThanOrEqualToExpression(leftHandSide,    rightHandSide); }
        if ($op.text.equals(">"))  { $result = new GreaterThanExpression(leftHandSide,          rightHandSide); }
        if ($op.text.equals(">=")) { $result = new GreaterThanOrEqualToExpression(leftHandSide, rightHandSide); }
        if ($op.text.equals("==")) { $result = new EqualToExpression(leftHandSide,              rightHandSide); }
        if ($op.text.equals("!=")) { $result = new NotEqualToExpression(leftHandSide,           rightHandSide); }
    })*
    ;
    
logicallyEquivalentExpression returns [Expression result]
    :   leftHandSide  = relationalExpression { $result = leftHandSide; } ( '&&' 
        rightHandSide = relationalExpression { $result = new LogicallyEquivalentExpression(leftHandSide, rightHandSide); } )*
    ;
    

logicallyNotEquivalentExpression returns [Expression result]
    :   leftHandSide  = logicallyEquivalentExpression { $result = leftHandSide; } ( '||' 
        rightHandSide = logicallyEquivalentExpression { $result = new LogicallyNotEquivalentExpression(leftHandSide, rightHandSide); } )*
    ;

expression returns [Expression result]
    :   getExpression=logicallyNotEquivalentExpression { $result = getExpression; }
    ;

type returns [Type result]
    :   'integer' { $result = new org.uva.sea.ql.ast.types.Int();   }
    |   'string'  { $result = new org.uva.sea.ql.ast.types.Str();   }
    |   'boolean' { $result = new org.uva.sea.ql.ast.types.Bool();  }
    |   'money'   { $result = new org.uva.sea.ql.ast.types.Money(); }
    ;

    
// Tokens
WS:	     (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

COMMENT: ('/*' .* '*/' | '//') { $channel=HIDDEN; };

Bool:    ('true'|'false');

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Money:   (('0'..'9')+ ('.' | ',') ('0'..'9')+);

String:	 ('"' .* '"');

Int:     ('0'..'9')+;