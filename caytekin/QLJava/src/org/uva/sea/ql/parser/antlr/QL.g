grammar QL;
options {backtrack=true; memoize=true;}


@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}


form returns [QLForm result]
	: 'form' id = Ident   sb = statementBlock 
		{ $result = new QLForm($id.text, $sb.result); }  
	;

statementBlock returns [ ArrayList<Statement> result] 
	@init {
		result = new ArrayList<Statement> ();
	}
	: '{' (stmt = statement { result.add(stmt); } )* '}' 
	;


statement returns [Statement result]
	: qst = questionStatement { $result = $qst.result; } 
	| cstmt = conditionalStatement { $result = $cstmt.result; }
	;	
	
	
questionStatement returns [QuestionStatement result]
	: qst = question  { $result = $qst.result; }
	| cq = computedQuestion { $result = $cq.result; }
	;

	
conditionalStatement returns [ConditionalStatement result]
	:ifthels = ifThenElseStatement { $result = $ifthels.result; } 
	| ifths = ifThenStatement { $result = $ifths.result; }
	 
	;
	
	
ifThenStatement returns [IfThenStatement result]
	: 'if' e = orExpr 'then' sb = statementBlock
		{ result = new IfThenStatement($e.result, $sb.result); }
	;

	
ifThenElseStatement returns [IfThenElseStatement result]
	: 'if' e = orExpr
		'then' thenSb = statementBlock
		'else' elseSb = statementBlock
	  { result = new IfThenElseStatement($e.result, $thenSb.result, $elseSb.result); }		
	;


computedQuestion returns [ComputedQuestion result]
	: Ident ':' StringLiteral t=type '(' e=orExpr ')' 
	{ $result = new ComputedQuestion($Ident.text, $StringLiteral.text, $t.result, $e.result); }
	;


question returns [Question result] 
  : Ident ':' StringLiteral t=type
   { $result = new Question($Ident.text, $StringLiteral.text, $t.result); }
   ;
  
  
type returns [Type result]
  	: BooleanType { $result = new BooleanType(); }
  	| IntegerType { $result = new IntegerType(); }
  	| StringType { $result = new StringType(); } 
	;

reservedWord returns [ReservedWord result]
	: TrueRW { $result = new TrueRW(); }
	| FalseRW { $result = new FalseRW(); }
	| IfRW { $result = new IfRW(); }
	| ThenRW { $result = new ThenRW(); }
	| ElseRW { $result = new ElseRW(); }
	; 


	
primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | StringLiteral { $result = new StringLiteral($StringLiteral.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
    

unExpr returns [Expr result]
    : '+' x=unExpr { $result = new Pos($x.result); }
    | '-' x=unExpr { $result = new Neg($x.result); }
    | '!' x=unExpr { $result = new Not($x.result); }
    | x=primary { $result = $x.result; }
    ;
    
    
mulExpr returns [Expr result]
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
    
  
addExpr returns [Expr result]
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
  
relExpr returns [Expr result]
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
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;
    
SINGLE_LINE_COMMENT 
     	:	'//' .* '\n'  {$channel=HIDDEN;}
     	;
     	    
BooleanType 	:  'bool';

IntegerType 	:  'int';

StringType	:  'string';

TrueRW 		:  'true';

FalseRW 	:  'false'; 

IfRW 		:  'if';

ThenRW 		:  'then';

ElseRW		:  'else';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

StringLiteral	: '"' .* '"';




