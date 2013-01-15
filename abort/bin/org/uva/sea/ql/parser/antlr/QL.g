grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.conditionals.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@lexer::members {
}

@parser::members {
}

// TODO: distinguish literals with non-literals (data type and parse)
form returns [Form result]
  : FORM Ident BLOCK_START e=elements BLOCK_END {    
    $result = new Form(e);
  };

elements returns [List<Element> results]
  @init { $results = new ArrayList<Element>(); }
  : (element { $results.add($element.result); })+;

element returns [Element result]
    : question { $result = $question.result; }
    | computation { $result = $computation.result; }
    | ifExpression { $result = $ifExpression.result; };

ifExpression returns [IfStatement result]
    : IF PARENTHESES_OPEN statement=orExpression PARENTHESES_CLOSE BLOCK_START successStatements=elements BLOCK_END ELSE BLOCK_START elseStatements=elements BLOCK_END
    {
      $result = new IfThenElse($statement.result, successStatements, elseStatements);
    }
    | IF PARENTHESES_OPEN statement=orExpression PARENTHESES_CLOSE BLOCK_START successStatements=elements BLOCK_END
    {
      $result = new IfThen($statement.result, successStatements);
    };  

questions returns [List<Question> results]
    @init { $results = new ArrayList<Question>(); }
    : (question { $results.add($question.result); })+;

computation returns [Computation result]
  : label=Ident ':' String parameter=dataType PARENTHESES_OPEN operation=orExpression PARENTHESES_CLOSE {
    $result = new Computation($label.text, $String.text, $parameter.result, $operation.result);
  };

question returns [Question result]
  : label=Ident ':' String parameter=dataType {
    $result = new Question($label.text, $String.text, $parameter.result);
  };
  
dataType returns [DataType result]
 : Type {
    if ($Type.text.equals("string")) $result = new StringLiteral();
    else if ($Type.text.equals("integer")) $result = new Int();
    else if ($Type.text.equals("money")) $result = new Money();
    else if ($Type.text.equals("boolean")) $result = new Bool();
 };
 
primary returns [Expression result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Money { $result = new Money($Money.text); }
  | Bool { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | String { $result = new StringLiteral($String.text.substring(1, $String.text.length() - 1)); }
  | PARENTHESES_OPEN orExpression PARENTHESES_CLOSE { $result = $orExpression.result; };

unExpression returns [Expression result]
    :  '+' x=unExpression { $result = new Pos($x.result); }
    |  '-' x=unExpression { $result = new Neg($x.result); }
    |  '!' x=unExpression { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; };    
    
mulExpression returns [Expression result]
    :   lhs=unExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpression 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new Div($result, rhs);      
      }
    })*;

addExpression returns [Expression result]
    :   lhs=mulExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpression
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*;
  
relExpression returns [Expression result]
    :   lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
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
    })*;
    
andExpression returns [Expression result]
    :   lhs=relExpression { $result=$lhs.result; } ( '&&' rhs=relExpression { $result = new And($result, rhs); } )*;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*;


// Tokens
COMMENT 
     : '/*' .* '*/' { $channel=HIDDEN; }  // multi line
     | '//' ~('\n'|'\r')* { $channel=HIDDEN; } // single line
;

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

IF: 'if';
PARENTHESES_OPEN: '(';
PARENTHESES_CLOSE: ')';
BLOCK_START: '{';
BLOCK_END: '}';
ELSE: 'else';

FORM: 'form';

Type: 'boolean' | 'integer' | 'money' | 'string';

Bool: 'TRUE' | 'FALSE' | 'true' | 'false';

Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Money: ('0'..'9')+ ('.' ('0'..'9')+)?;

String: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment
EscapedCharacterSequence: '\\' ('\"' | '\\')
;