grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.ast.types.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form: primary+;

formStatement returns [FormStatement result]
    :   question         { $result = $question.result; }
    |   computedQuestion { $result = $computedQuestion.result; }
    |   conditionBlock   { $result = $conditionBlock.result; }
    ;

question returns [Question result]
    :   String Ident ':' t=type { $result = new Question(new org.uva.sea.ql.ast.values.Str($String.text), new Ident($Ident.text), t); }
    ;
  
computedQuestion returns [ComputedQuestion result]
    :   String Ident '=' e=orExpr { $result = new ComputedQuestion(new org.uva.sea.ql.ast.values.Str($String.text), new Ident($Ident.text), $e.result); }
    ;

conditionBlock returns [ConditionBlock result]
    :   'if' '(' condition=orExpr ')' '{' ifBody=formStatement '}' 'else' ('{')? elseBody=formStatement ('}')?
        { $result = new ConditionBlock(condition, $ifBody.result, $elseBody.result); }
    |   'if' '(' x=orExpr ')' '{' (formStatement)* '}'
        { $result = new ConditionBlock(condition, ifBody); }
    ;

primary returns [Expr result]
    :   Int    { $result = new org.uva.sea.ql.ast.values.Int(Integer.parseInt($Int.text)); }
    |   Bool   { $result = new org.uva.sea.ql.ast.values.Bool(Boolean.parseBoolean($Bool.text)); }
    |   String { $result = new org.uva.sea.ql.ast.values.Str($String.text); }
    |   Ident  { $result = new Ident($Ident.text); }
    |   '(' x=orExpr ')'{ $result = $x.result; }
    ;
    
unExpr returns [Expr result]
    :   '+' x=unExpr { $result = new Pos($x.result); }
    |   '-' x=unExpr { $result = new Neg($x.result); }
    |   '!' x=unExpr { $result = new Not($x.result); }
    |   x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
        if ($op.text.equals("*"))  { $result = new Mul($result, rhs); }
        if ($op.text.equals("<=")) { $result = new Div($result, rhs); }
    })*
    ;
    
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
        if ($op.text.equals("+")) { $result = new Add($result, rhs); }
        if ($op.text.equals("-")) { $result = new Sub($result, rhs); }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
        if ($op.text.equals("<"))  { $result = new LT($result, rhs);  }
        if ($op.text.equals("<=")) { $result = new LEq($result, rhs); }
        if ($op.text.equals(">"))  { $result = new GT($result, rhs);  }
        if ($op.text.equals(">=")) { $result = new GEq($result, rhs); }
        if ($op.text.equals("==")) { $result = new Eq($result, rhs);  }
        if ($op.text.equals("!=")) { $result = new NEq($result, rhs); }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

type returns [Type result]
    :   'integer' { $result = new org.uva.sea.ql.ast.types.Int();    }
    |   'string'  { $result = new org.uva.sea.ql.ast.types.Str(); }
    |   'boolean' { $result = new org.uva.sea.ql.ast.types.Bool();   }
    ;

    
// Tokens
WS:	     (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

COMMENT: ('/*' .* '*/' | '//') { $channel=HIDDEN; };

Bool:    ('true'|'false');

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

String:	 ('"' .* '"');

Int:     ('0'..'9')+;