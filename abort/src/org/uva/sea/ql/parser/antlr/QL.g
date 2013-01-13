grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.types.*;
import org.uva.sea.ql.parser.antlr.operators.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

// TODO: comment out = successful tests
@lexer::members {
//  @Override
//  public void reportError(RecognitionException e) {
//    throw new RuntimeException(e.getMessage()); 
//  }
}

// TODO: comment out = successful tests
@parser::members {
//  @Override
//  public void reportError(RecognitionException e) {
//   throw new RuntimeException(e.getMessage()); 
//  }
}
// Change the start symbol of the parser to parse forms, instead of Expressions.

formExpression returns [Form result]
 : FORM Ident BLOCK_START elements=formElementArray BLOCK_END {
 
    
    $result = new Form(elements);
  };

formElementArray returns [List<FormExpression> formExpressions]
  @init { $formExpressions = new ArrayList<FormExpression>(); }
  : (e=formElementExpression { $formExpressions.add($e.result); })+;

formElementExpression returns [FormExpression result]
    : questionExpression { $result = $questionExpression.result; }
    | formIfExpression { $result = $formIfExpression.result; }
    ;

formIfExpression returns [IfExpression result]
    : IF IF_STATEMENT_PREFIX statement=orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements=formElementArray BLOCK_END ELSE BLOCK_START elseStatements=formElementArray BLOCK_END
    {
      $result = new IfElse($statement.result, successStatements, elseStatements);
    }
    | IF IF_STATEMENT_PREFIX statement=orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements=formElementArray BLOCK_END
    {
      $result = new If($statement.result, successStatements);
    };  

questionArray returns [List<FormQuestion> expressions]
    @init { $expressions = new ArrayList<FormQuestion>(); }
    : (e=questionExpression { $expressions.add($e.result); })+;

questionExpression returns [FormQuestion result]
  : label=Ident ':' question=String parameter=dataTypeExpression {
    $result = new FormQuestion($label.text, $question.text, $parameter.result);
  };
  
dataTypeExpression returns [DataType result]
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
  | '(' x=orExpression ')'{ $result = $x.result; }
  ;

//ifExpression returns [IfExpression result]
//    : IF IF_STATEMENT_PREFIX statement=orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements=orExpression BLOCK_END ELSE BLOCK_START elseStatements=orExpression BLOCK_END
//    {
//      $result = new IfElse($statement.result, $successStatements.result, $elseStatements.result);
//    }
//    | IF IF_STATEMENT_PREFIX statement=orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements=orExpression BLOCK_END
//    {
//      $result = new If($statement.result, $successStatements.result);
//    };  
//    
    
unExpression returns [Expression result]
    :  '+' x=unExpression { $result = new Pos($x.result); }
    |  '-' x=unExpression { $result = new Neg($x.result); }
    |  '!' x=unExpression { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpression returns [Expression result]
    :   lhs=unExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpression 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
//typeExpression returns [String result]
//  : type=Type { $result = $type.text; };
  
addExpression returns [Expression result]
    :   lhs=mulExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpression
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
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
    })*
    ;
    
andExpression returns [Expression result]
    :   lhs=relExpression { $result=$lhs.result; } ( '&&' rhs=relExpression { $result = new And($result, rhs); } )*
    ;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*
    ;


// Tokens
COMMENT 
     : '/*' .* '*/' { $channel=HIDDEN; }  // multi line
     | '//' ~('\n'|'\r')* { $channel=HIDDEN; } // single line
;

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; };

IF: 'if';
IF_STATEMENT_PREFIX: '(';
IF_STATEMENT_SUFFIX: ')';
BLOCK_START: '{';
BLOCK_END: '}';
ELSE: 'else';

FORM: 'form';

Type: 'boolean' | 'integer' | 'money' | 'string';


Bool: ('TRUE' | 'FALSE' | 'true' | 'false');

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Money: ('0'..'9')+ ('.' ('0'..'9')+)?;

//String: '"'~('"');


String: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment
EscapedCharacterSequence: '\\' ('\"' | '\\')
;