grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.types.literals.*;
import org.uva.sea.ql.ast.types.datatypes.*;
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

form returns [Form result]
  : FORM Ident BLOCK_START e=elements BLOCK_END {    
    $result = new Form($Ident.text, e);
  };

elements returns [List<Element> results]
  @init { $results = new ArrayList<Element>(); }
  : (element { $results.add($element.result); })*;

element returns [Element result]
    : question { $result = $question.result; }
    | computation { $result = $computation.result; }
    | ifStatement { $result = $ifStatement.result; };

ifStatement returns [IfStatement result]
    : IF PARENTHESES_OPEN condition=orExpression PARENTHESES_CLOSE BLOCK_START successStatements=elements BLOCK_END ELSE BLOCK_START elseStatements=elements BLOCK_END
    {
      $result = new IfThenElse($condition.result, successStatements, elseStatements);
    }
    | IF PARENTHESES_OPEN condition=orExpression PARENTHESES_CLOSE BLOCK_START successStatements=elements BLOCK_END
    {
      $result = new IfThen($condition.result, successStatements);
    };  

questions returns [List<Question> results]
    @init { $results = new ArrayList<Question>(); }
    : (question { $results.add($question.result); })+;

computation returns [Computation result]
  : label=Ident ':' String parameter=dataType PARENTHESES_OPEN operation=orExpression PARENTHESES_CLOSE {
    $result = new Computation(new Ident($label.text), $String.text.substring(1, $String.text.length() - 1), $parameter.result, $operation.result);
  };

question returns [Question result]
  : label=Ident ':' String parameter=dataType {
    $result = new Question(new Ident($label.text), $String.text.substring(1, $String.text.length() - 1), $parameter.result);
  };
  
dataType returns [DataType result]
 : Type {
    // TODO: instances
    if ($Type.text.equals("string")) $result = new StringType();
    else if ($Type.text.equals("integer")) $result = new IntType();
    else if ($Type.text.equals("money")) $result = new MoneyType();
    else if ($Type.text.equals("boolean")) $result = new BoolType();
 };
 
primary returns [Expression result]
  : Int   { $result = new IntLiteral(Integer.parseInt($Int.text)); }
  | Money { $result = new MoneyLiteral($Money.text); }
  | Bool { $result = new BoolLiteral(Boolean.parseBoolean($Bool.text)); }
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
      if ($op.text.equals("/")) {
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
ENDOFFILE: EOF { $channel=HIDDEN; };

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