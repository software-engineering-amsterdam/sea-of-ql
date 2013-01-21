grammar QL;

options
{
	language = Java;
	output = AST;
    ASTLabelType = CommonTree;
	backtrack = true;
	memoize = true;
}

tokens
{
    NEGATION;
    NOT;
    EXPRESSION;
    STATEMENTS;
    ASSIGNMENT;
    IF;
    FORM;
}

@lexer::header
{
	package org.uva.sea.ql.parser;
}

@parser::header
{
	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.parser.exception.ParserException;
}

@parser::members
{
	@Override
	public void reportError(RecognitionException e)
	{
		super.reportError(e);
		throw new ParserException(e.getMessage());
	}
}

form
	:	'form' Identifier '{' statementBlock* '}' -> ^(FORM Identifier ^(STATEMENTS statementBlock*))
	;

statementBlock
	:	ifStatement
		| assignmentStatement
	;

ifStatement
	:   ifStat elseIfStat* elseStat? -> ^(IF ifStat elseIfStat* elseStat?)
	;

ifStat
    :   'if' expression '{' statementBlock+ '}' -> ^(EXPRESSION expression ^(STATEMENTS statementBlock+))
    ;

elseIfStat
    :   'else' 'if' expression '{' statementBlock+ '}' -> ^(EXPRESSION expression ^(STATEMENTS statementBlock+))
    ;

elseStat
    :   'else' '{' statementBlock+ '}' -> ^(EXPRESSION ^(STATEMENTS statementBlock+))
    ;

assignmentStatement
	:	Identifier ':' StringLiteral type -> ^(ASSIGNMENT Identifier type)
	;

type
	:	'boolean'
		| 'integer'
		| 'string'
		| 'money'
	;

terminal
	:   Boolean
	|	Integer
	|   StringLiteral
	|   Money
	|	Identifier
	|	'('! expression ')'!
	;

unary
	:   '!' terminal -> ^(NOT terminal)
	|   '-' terminal -> ^(NEGATION terminal)
	|   '+'! terminal
	|   terminal
	;

mult
	:	unary (('*' | '/')^ unary)*
	;

add
	:	mult (('+' | '-')^ mult)*
	;

relation
	:	add (('==' | '!=' | '<' | '<=' | '>=' | '>')^ add)*
	;

expression
	:	relation (('&&' | '||')^ relation)*
	;

StringLiteral
	:	'"'
		{ StringBuilder b = new StringBuilder(); }
		(	'\\' '"' { b.appendCodePoint('"');}
		|	c = ~('"'|'\r'|'\n') { b.appendCodePoint(c);}
		)*
		'"'
		{ setText(b.toString()); }
	;

Boolean
    :   'true'
    |   'false'
    ;

Money
    :   Digit+ '.' Digit+
    ;

Integer
    :   Digit+
    ;

Identifier
    :   Letter (Letter | Digit | '_')*
    ;

Whitespace
    :   (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;}
    ;

Comment
    :   '//' .* ('\n'|'\r') {$channel = HIDDEN;}
    ;

MultilineComment
    :   '/*' .* '*/' {$channel = HIDDEN;}
    ;

fragment Letter
    :   ('a'..'z' | 'A'..'Z')
    ;

fragment Digit
    :   '0'..'9'
    ;
