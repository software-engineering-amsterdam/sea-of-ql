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
    :   String Ident ':' t=type { $result = new AnswerableQuestion(new org.uva.sea.ql.ast.expressions.literal.Str($String.text), new Ident($Ident.text), t); }
    |   String Ident '=' e=expression { $result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str($String.text), new Ident($Ident.text), $e.result); }
    ;

conditionBlock returns [ConditionBlock result]
    :   'if' '(' condition=expression ')' ifBody=statementBody 'else' elseBody=statementBody
        { $result = new IfThenElse(condition, ifBody, elseBody); }
    |   'if' '(' condition=expression ')' ifBody=statementBody
        { $result = new IfThen(condition, ifBody); }
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
    |   '(' x=expression ')'{ $result = $x.result; }
    ;
    
unaryExpression returns [Expression result]
    :   '+' x=unaryExpression { $result = new PositiveExpression($x.result); }
    |   '-' x=unaryExpression { $result = new NegativeExpression($x.result); }
    |   '!' x=unaryExpression { $result = new NegationalExpression($x.result); }
    |   x=primary    { $result = $x.result; }
    ;    
    
multiplicationExpression returns [Expression result]
    :   lhs=unaryExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unaryExpression 
    { 
        if ($op.text.equals("*")) { $result = new Multiplication($result, rhs); }
        if ($op.text.equals("/")) { $result = new Division($result, rhs); }
    })*
    ;
    
additionExpression returns [Expression result]
    :   lhs=multiplicationExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=multiplicationExpression
    { 
        if ($op.text.equals("+")) { $result = new Addition($result, rhs); }
        if ($op.text.equals("-")) { $result = new Subtraction($result, rhs); }
    })*
    ;
  
relationalExpression returns [Expression result]
    :   lhs=additionExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=additionExpression 
    { 
        if ($op.text.equals("<"))  { $result = new LessThanExpression($result, rhs);  }
        if ($op.text.equals("<=")) { $result = new LessThanOrEqualToExpression($result, rhs); }
        if ($op.text.equals(">"))  { $result = new GreaterThanExpression($result, rhs);  }
        if ($op.text.equals(">=")) { $result = new GreaterThanOrEqualToExpression($result, rhs); }
        if ($op.text.equals("==")) { $result = new EqualToExpression($result, rhs);  }
        if ($op.text.equals("!=")) { $result = new NotEqualToExpression($result, rhs); }
    })*
    ;
    
logicallyEquivalentExpression returns [Expression result]
    :   lhs=relationalExpression { $result=$lhs.result; } ( '&&' rhs=relationalExpression { $result = new LogicallyEquivalentExpression($result, rhs); } )*
    ;
    

logicallyNotEquivalentExpression returns [Expression result]
    :   lhs=logicallyEquivalentExpression { $result = $lhs.result; } ( '||' rhs=logicallyEquivalentExpression { $result = new LogicallyNotEquivalentExpression($result, rhs); } )*
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