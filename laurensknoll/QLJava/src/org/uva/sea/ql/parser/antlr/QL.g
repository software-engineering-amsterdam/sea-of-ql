grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [AbstractExpr result]
	:	Int		{ $result = new Int(Integer.parseInt($Int.text)); }
	|	x=identExpr	{ $result = $x.result; }
	|	x=stringExpr	{ $result = $x.result; }
	|	x=expression	{ $result = $x.result; }
	;

identExpr returns [Ident result]
	:	Ident		{ $result = new Ident($Ident.text); }
	;
	
stringExpr returns [Literal result]
	:	String		{ $result = new Literal($String.text); }
	;

// Expressions
expression returns [AbstractExpr result]
	:	'(' x=orExpr ')' { $result = $x.result; }
	;

unExpr returns [AbstractExpr result]
	:	'+' x=unExpr	{ $result = new Pos($x.result); }
	|	'-' x=unExpr	{ $result = new Neg($x.result); }
	|	'!' x=unExpr	{ $result = new Not($x.result); }
	|	x=primary	{ $result = $x.result; }
	;    
    
mulExpr returns [AbstractExpr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("/")) {
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
  
addExpr returns [AbstractExpr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
relExpr returns [AbstractExpr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, rhs);
      }
    })*
    ;
    
andExpr returns [AbstractExpr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [AbstractExpr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

answerExpr returns [AbstractExpr result]
	:	questionStatement expression
	;

// Statements
form returns [QuestionForm result]
	:	x=statement { $result = new QuestionForm($x.result); }
	;

statement returns [AbstractStatement result]
    	:	x=blockStatement { $result = $x.result; }
    	|	x=ifStatement { $result = $x.result; }
    	|	x=declStatement { $result = $x.result; }
    	;

blockStatement returns [AbstractStatement result]
	@init
	{
		List<AbstractStatement> list = new ArrayList<AbstractStatement>();
	}
	@after
	{
		$result = new Block(list);
	}
	:	'{' (s=statement { list.add(s); })* '}'
	;

ifStatement returns [AbstractStatement result]
    	:	'if' condition=expression truePath=statement
    		{ $result = new IfStatement($condition.result, $truePath.result); }
	;

declStatement returns [AbstractStatement result]
	:	q=questionStatement	{ $result = $q.result; }
	;

questionStatement returns [AbstractStatement result]
	:	ident=identExpr ':' description=stringExpr type=answerTypeStatement
		{
			$result = new Question($ident.result, $description.result, $type.result);
		}
	;

answerTypeStatement returns [AbstractType result]
	:	'boolean'	{ $result = new Bool(); }
	|	'money'		{ $result = new Money(); }
	;
	
// Tokens
WS
	:	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
	;

COMMENT 
	:	'//' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }
	|	'/*' .* '*/' { $channel=HIDDEN; }
	;

String
	:	'"' .* '"'
	;
    
Ident
	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

Int
	:	('0'..'9')+
	;