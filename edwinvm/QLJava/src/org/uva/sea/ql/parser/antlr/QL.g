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
    |   String Ident '=' e=orExpression { $result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str($String.text), new Ident($Ident.text), $e.result); }
    ;

conditionBlock returns [ConditionBlock result]
    :   'if' '(' condition=orExpression ')' ifBody=statementBody 'else' elseBody=statementBody
        { $result = new IfThenElse(condition, ifBody, elseBody); }
    |   'if' '(' condition=orExpression ')' ifBody=statementBody
        { $result = new IfThen(condition, ifBody); }
    ;

statementBody returns [StatementBody result]
	@init  { StatementBody statements = new StatementBody(); }
    @after { $result = statements; }
    :   '{' (statement=formStatement { statements.add(statement); })+ '}'
    |   (statement=formStatement { statements.add(statement); })+
    ;

primary returns [Expression result]
    :   Int    { $result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt($Int.text)); }
    |   Bool   { $result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean($Bool.text)); }
    |   Money  { $result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble($Money.text.replace(',', '.'))); }
    |   String { $result = new org.uva.sea.ql.ast.expressions.literal.Str($String.text); }
    |   Ident  { $result = new Ident($Ident.text); }
    |   '(' x=orExpression ')'{ $result = $x.result; }
    ;
    
unExpression returns [Expression result]
    :   '+' x=unExpression { $result = new Pos($x.result); }
    |   '-' x=unExpression { $result = new Neg($x.result); }
    |   '!' x=unExpression { $result = new Not($x.result); }
    |   x=primary    { $result = $x.result; }
    ;    
    
mulExpression returns [Expression result]
    :   lhs=unExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpression 
    { 
        if ($op.text.equals("*")) { $result = new Mul($result, rhs); }
        if ($op.text.equals("/")) { $result = new Division($result, rhs); }
    })*
    ;
    
addExpression returns [Expression result]
    :   lhs=mulExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpression
    { 
        if ($op.text.equals("+")) { $result = new Addition($result, rhs); }
        if ($op.text.equals("-")) { $result = new Sub($result, rhs); }
    })*
    ;
  
relExpression returns [Expression result]
    :   lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
    { 
        if ($op.text.equals("<"))  { $result = new LT($result, rhs);  }
        if ($op.text.equals("<=")) { $result = new LEq($result, rhs); }
        if ($op.text.equals(">"))  { $result = new GT($result, rhs);  }
        if ($op.text.equals(">=")) { $result = new GEq($result, rhs); }
        if ($op.text.equals("==")) { $result = new Eq($result, rhs);  }
        if ($op.text.equals("!=")) { $result = new NEq($result, rhs); }
    })*
    ;
    
andExpression returns [Expression result]
    :   lhs=relExpression { $result=$lhs.result; } ( '&&' rhs=relExpression { $result = new And($result, rhs); } )*
    ;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*
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