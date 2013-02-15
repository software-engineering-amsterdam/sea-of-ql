grammar QL;
options { 	
	backtrack=true; 
	memoize=true; 
	language=Java;  
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.parser.test.*;
import java.util.LinkedList;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}
@members {
	private List<String> errors = new LinkedList<String>();
	
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) { 
        String hdr = getErrorHeader(e);        
        String msg = getErrorMessage(e, tokenNames);	      
	    
	    errors.add(hdr + " -- " + msg);
	       
	}
	public boolean isErrorFound(){
		return this.errors.size() != 0;
	}
	public List<String> getErrors(){
		return this.errors;
	}
}

primary returns [Expr result]
  : Int   { $result = new IntLiteral(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Bool { $result = new BoolLiteral($Bool.text);}
  | Str { $result = new StrLiteral($Str.text);}
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
    
unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
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

form returns [Form result]
    : Form Ident '{' formElements '}' { $result = new Form(new Ident($Ident.text), $formElements.result); };

formElement returns [FormElement result] 
    : question {$result = $question.result;}
    | condition {$result = $condition.result;}
    | computation {$result = $computation.result;}
    ;

formElements returns [ArrayList<FormElement> result]
    @init { result = new ArrayList<FormElement>(); }
    : (element = formElement { $result.add(element);})*
    ;
computation returns [Computation result]
    : Ident ':' Str type '(' orExpr ')' { $result = new Computation(new Ident($Ident.text), new StrLiteral($Str.text), $orExpr.result, $type.result); }
    ;
question returns [Question result] 
    : Ident ':' Str type { $result = new Question(new Ident($Ident.text), new StrLiteral($Str.text), $type.result); }
    ;
condition returns [Condition result]
    : If '(' orExpr ')' '{' ifElems = formElements '}' Else '{' elseElems = formElements '}' { $result = new Condition($orExpr.result, $ifElems.result, $elseElems.result);}
    | If '(' orExpr ')' '{' formElements '}' { $result = new Condition($orExpr.result, $formElements.result); }
    ;

type returns [Type result]
    : 'boolean' {$result = new BoolType();}
    | 'string'  {$result = new StrType();}
    | 'int'     {$result = new IntType();}
    ;
// Tokens
WS:	(' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; };

Comment: '/*' .* '*/' {$channel=HIDDEN;}
        | '//'  ~ ('\n' | '\r')* {$channel=HIDDEN;};

SpecialChars: ('!' | '?' | ',' | '.' | '<' | '>' | '=' | '+' | '-' | '[' | ']' | '|' | ':' | '/' | '\\' | '\'');

Bool: ('true' | 'false');

If: ('if');

Else: ('else');

Form: 'form';

Str: '"' (Ident | WS | Int | SpecialChars)* '"';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;