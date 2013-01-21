grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.atom.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;

}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}


identExpr returns [org.uva.sea.ql.ast.expr.atom.Ident result]
	:	IDENT { $result = new org.uva.sea.ql.ast.expr.atom.Ident($IDENT.text); }
	;

primary returns [AbstractExpr result]
	:	INT		{ $result = new org.uva.sea.ql.ast.expr.atom.Int(Integer.parseInt($INT.text)); }
	|	BOOLEAN		{ $result = new org.uva.sea.ql.ast.expr.atom.Bool(Boolean.parseBoolean($BOOLEAN.text)); }
	|	MONEY		{ $result = new org.uva.sea.ql.ast.expr.atom.Money(Float.parseFloat($MONEY.text)); }
	|	x=identExpr	{ $result = $x.result; }
	|	x=stringExpr	{ $result = $x.result; }
	|	x=expr	{ $result = $x.result; }
	;

stringExpr returns [org.uva.sea.ql.ast.expr.atom.String result]
	:	STRING { $result = new org.uva.sea.ql.ast.expr.atom.String($STRING.text); }
	;

expr returns [AbstractExpr result]
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

form returns [QuestionForm result]
	:	'form' id=identExpr s=blockStatement { $result = new QuestionForm($id.result, $s.result); }
	;
	
// Statements
statement returns [AbstractStatement result]
    	:	x=blockStatement { $result = $x.result; }
    	|	x=ifStatement { $result = $x.result; }
    	|	x=declStatement { $result = $x.result; }
    	;

blockStatement returns [Block result]
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

ifStatement returns [IfStatement result]
    	:	'if' condition=expr truePath=statement
    		{ $result = new IfStatement($condition.result, $truePath.result); }
	;

declStatement returns [AbstractStatement result]
	:	q=questionStatement	{ $result = $q.result; }
	;

questionStatement returns [AbstractStatement result]
	:	id=identExpr ':' descr=stringExpr at=answerTypedef
		{
			$result = new Question($id.result, $descr.result, $at.result);
		}
		(ex=expr
		{
			$result = new ComputedQuestion((Question)$result, $ex.result);
		})?
	;

answerTypedef returns [AbstractType result]
	:	'boolean'	{ $result = new org.uva.sea.ql.ast.type.Bool(); }
	|	'integer'	{ $result = new org.uva.sea.ql.ast.type.Int(); }
	|	'money'		{ $result = new org.uva.sea.ql.ast.type.Money(); }
	|	'string'	{ $result = new org.uva.sea.ql.ast.type.String(); }
	;
	
// Tokens
WS
	:	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
	;

COMMENT 
	:	'//' .* '\r'? '\n' { $channel=HIDDEN; }
	|	'/*' .* '*/' { $channel=HIDDEN; }
	;

STRING
	:	'"' .* '"'
	;

BOOLEAN
	:	'true'
	|	'false'
	;

IDENT
	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

INT
	:	('0'..'9')+
	;

MONEY
	:	('0'..'9')+ '.' ('0'..'9') ('0'..'9')
	;