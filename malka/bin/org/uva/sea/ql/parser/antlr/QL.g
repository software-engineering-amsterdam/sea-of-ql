grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.integer.*;
import org.uva.sea.ql.ast.expression.bool.*;
import org.uva.sea.ql.ast.expression.string.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.expression.integer.operation.*;
import org.uva.sea.ql.ast.expression.bool.operation.logical.*;
import org.uva.sea.ql.ast.expression.bool.operation.relational.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
	: FORM IDENT '{' elements=formElementList '}' { $result = new Form($elements.result); }
	;

formElementList returns [List<FormElement> result]
	: {$result = new ArrayList<FormElement>();} (element=formElement {$result.add($element.result);})*
	;

formElement returns [FormElement result]
	: IDENT ':' STRING t=type { $result = new Question(new Identifier($IDENT.text), new StringPrimitive($STRING.text), $t.result); }
	| IDENT ':' STRING t=type '(' x=addExpr ')' { $result = new FormText(new Identifier($IDENT.text), new StringPrimitive($STRING.text), $t.result, $x.result); }
	| IF '(' condition=orExpr ')' '{' if_list=formElementList '}' ( ELSE '{' else_list=formElementList '}' )?
	{
		if (condition instanceof BooleanExpression) {
			$result = new IfStatement((BooleanExpression)$condition.result, $if_list.result, $else_list.result);
		} else {
			throw new RecognitionException();
		}
	}
	;

primary returns [Expression result]
  : INT    { $result = new IntegerPrimitive(Integer.parseInt($INT.text)); }
  | BOOL   { $result = new BooleanPrimitive(Boolean.parseBoolean($BOOL.text)); }
  | STRING { $result = new StringPrimitive($STRING.text); }
  | IDENT  { $result = new Identifier($IDENT.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
  
type returns [Type result]
	: BOOL_TYPE {$result = new BooleanType();}
	| INT_TYPE {$result = new IntegerType();}
	| STRING_TYPE {$result = new StringType();}
	;
    
unExpr returns [Expression result]
    :  op=('+'|'-') x=unExpr 
    { 
    	IntegerExpression operand = null;
    	if ($x.result instanceof Identifier) {
       		operand = new IntegerVariable((Identifier) $x.result);
      	}
      	else if ($x.result instanceof IntegerExpression)
    	{
    		 operand = (IntegerExpression) $x.result;
    	}
    	
    	if (operand != null)
    	{
    		if ($op.text.equals("+"))
    			$result = new Pos( operand );
    		else if ($op.text.equals("-"))
    			$result = new Neg( operand );
    	}
    	else
    	{
    		throw new RecognitionException();
    	}
    	
    }
    |  '!' x=unExpr
    { 
    	BooleanExpression operand = null;
    	if ($x.result instanceof Identifier) {
       		operand = new BooleanVariable((Identifier) $x.result);
      	}
      	else if ($x.result instanceof BooleanExpression)
    	{
    		 operand = (BooleanExpression) $x.result;
    	}
    	
    	if (operand != null)
    	{
    		$result = new Not( operand );
    	}
    	else
    	{
    		throw new RecognitionException();
    	}
    }
    |  x=primary    { $result = $x.result; }
    ;
    
mulExpr returns [Expression result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      
      if (result instanceof Identifier) {
        $result = new IntegerVariable((Identifier) $result);
      }
      if (rhs instanceof Identifier) {
        rhs = new IntegerVariable((Identifier) rhs);
      }
       
      if ( result instanceof IntegerExpression
              && rhs instanceof IntegerExpression ) {
      	if ($op.text.equals("*")) {
          $result = new Mul((IntegerExpression)$result, (IntegerExpression)rhs);
        }
        if ($op.text.equals("/")) {
          $result = new Div((IntegerExpression)$result, (IntegerExpression)rhs);      
        }
        
        
      } else {
      	throw new RecognitionException();
      }
    })*
    ;
    
  
addExpr returns [Expression result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    {
      if (result instanceof Identifier) {
        $result = new IntegerVariable((Identifier) $result);
      }
      if (rhs instanceof Identifier) {
        rhs = new IntegerVariable((Identifier) rhs);
      }
      
      if ( result instanceof IntegerExpression
              && rhs instanceof IntegerExpression ) {
      	if ($op.text.equals("+")) {
        	$result = new Add((IntegerExpression)$result, (IntegerExpression)rhs);
      	}
      	if ($op.text.equals("-")) {
	        $result = new Sub((IntegerExpression)$result, (IntegerExpression)rhs);
    	}
      } else {
      	throw new RecognitionException();
      }
    })*
    ;
  
relExpr returns [Expression result]
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
    
andExpr returns [Expression result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr 
    {
      if (result instanceof Identifier) {
        $result = new BooleanVariable((Identifier) $result);
      }
      if (rhs instanceof Identifier) {
        rhs = new BooleanVariable((Identifier) rhs);
      }
      
      if ( result instanceof BooleanExpression
              && rhs instanceof BooleanExpression ) {
      	
      	$result = new And((BooleanExpression)$result, (BooleanExpression)rhs);
      } else {
      	throw new RecognitionException();
      }
    })*
    ;
    

orExpr returns [Expression result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr 
    {
      if (result instanceof Identifier) {
        $result = new BooleanVariable((Identifier) $result);
      }
      if (rhs instanceof Identifier) {
        rhs = new BooleanVariable((Identifier) rhs);
      }
      
      if ( result instanceof BooleanExpression
              && rhs instanceof BooleanExpression ) {
      	
      	$result = new Or((BooleanExpression)$result, (BooleanExpression)rhs);
      } else {
      	throw new RecognitionException();
      }
    })*
    ;


// Tokens
	    
COMMENT 
    : '/*' ( options{greedy=false;}: . )* '*/' {$channel=HIDDEN;}
    | '//' ( options{greedy=false;}: . )* '\n' {$channel=HIDDEN;}
    ;
    

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;
    

STRING
	: '"' ( options{greedy=false;}: . )* '"'
	| '\'' ( options{greedy=false;}: . )* '\''
	;

IF
	: 'if'
	;

ELSE
	: 'else'
	;

FORM
	: 'form'
	;

BOOL
	: 'true'
	| 'false'
	| 'TRUE'
	| 'FALSE'
	;

BOOL_TYPE
	: 'boolean'
	;

INT_TYPE
	: 'integer'
	;
	
STRING_TYPE
	: 'string'
	;

IDENT
	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

INT
	: ('0'..'9')+;