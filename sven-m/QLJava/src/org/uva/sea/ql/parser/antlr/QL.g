grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.form.types.*;
import org.uva.sea.ql.ast.misc.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@parser::members {
  @Override
  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new RuntimeException(e);
  }
}

form returns [Form result]
  : frm='form' IDENT body {
      $result = new Form($IDENT.text, $body.result, new Location($frm.line,
        $frm.pos, null));
    } EOF
  ;
  
topLevelBody returns [Body result]
  : body EOF { $result = $body.result; }
  ;
  
body returns [Body result]
  @init { List<FormElement> tempList = new ArrayList<>(); }
  @after
    {
      $result = new Body(tempList, new Location($open.line, $open.pos,
        $close.line, $close.pos + $close.text.length()));
    }
  : open='{' (formElement { tempList.add($formElement.result); })* close='}'
  ;
  
formElement returns [FormElement result]
  : question { $result = $question.result; }
  | ifStatement { $result = $ifStatement.result; }
  ;
  
topLevelFormElement returns [FormElement result]
  : formElement EOF { $result = $formElement.result; }
  ;
  
question returns [Question result]
  : id=IDENT ':' lbl=STRING_LITERAL type
    {
      $result = new Question(
        new Ident($id.text, new Location($id.line, $id.pos, $id.line,
          $id.pos + $id.text.length())),
        $lbl.text.substring(1, $lbl.text.length() - 1), $type.result);
    }
  | id=IDENT ':' lbl=STRING_LITERAL type '(' cond=expression close=')'
    {
      $result = new Computed(
        new Ident($id.text, new Location($id.line, $id.pos, $id.line,
          $id.pos + $id.text.length())),
        $lbl.text.substring(1, $lbl.text.length() - 1), $type.result,
          $cond.result, new Location(null, $close.line,
          $close.pos + $close.text.length()));
    }
  ;
  
type returns [Type result]
  : boolTok='boolean'
    {
      $result = new BoolType(new Location($boolTok.line, $boolTok.pos,
        $boolTok.line, $boolTok.pos + $boolTok.text.length()));
    }
  | strTok='string'
    {
      $result = new StrType(new Location($strTok.line, $strTok.pos,
         $strTok.line, $strTok.pos + $strTok.text.length()));
    }
  | intTok='integer'
    {
      $result = new IntType(new Location($intTok.line, $intTok.pos,
         $intTok.line, $intTok.pos + $intTok.text.length()));
    }
  ;

ifStatement returns [AbstractConditional result]
  @init {
    Body elseBody = null;
  }
  : ifTok='if' '(' cond=expression ')' ifTrue=body
    (
      elseTok='else' ifFalse=body
      {
        elseBody = $ifFalse.result;
      }
    )?
    {
      if (elseBody == null) {
        $result = new IfStatement($cond.result, $ifTrue.result,
          new Location($ifTok.line, $ifTok.pos, null)); 
      } else {
        $result = new IfElseStatement($cond.result, $ifTrue.result,
          $ifFalse.result, new Location($ifTok.line, $ifTok.pos, null)); 
      }
    }
  ;

topLevelExpression returns [Expr result]
  : expression EOF { $result = $expression.result; }
  ;

expression returns [Expr result]
  : orExpr { $result = $orExpr.result; }
  ;

primary returns [Expr result]
  : INT
    {
      $result = new IntLiteral(Integer.parseInt($INT.text), new Location($INT.line,
        $INT.pos, $INT.line, $INT.pos + $INT.text.length()));
    }
  | bool=BOOL_LITERAL
    {
      $result = new BoolLiteral($bool.text.equals("true"), new Location(
        $bool.line, $bool.pos, $bool.line,
          $bool.pos + $bool.text.length()));
    }
  | id=IDENT
    {
      $result = new Ident($id.text, new Location($id.line, $id.pos,
          $id.line, $id.pos + $id.text.length()));
    }
  | str=STRING_LITERAL
    {
      $result = new StrLiteral($str.text.substring(1, $str.text.length() - 1),
        new Location($str.line, $str.pos, $str.line,
          $str.pos + $str.text.length()));
    }
  | '(' orExpr ')' { $result = $orExpr.result; }
  ;
    
unExpr returns [Expr result]
  : pos='+' x=unExpr { $result = new Pos($x.result, new Location($pos.line,
      $pos.pos, null)); }
  | neg='-' x=unExpr { $result = new Neg($x.result, new Location($neg.line,
      $neg.pos, null)); }
  | not='!' x=unExpr { $result = new Not($x.result, new Location($not.line,
      $not.pos, null)); }
  | x=primary    { $result = $x.result; }
  ;    
    
mulExpr returns [Expr result]
  : lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
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
  : lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
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
  : lhs=addExpr { $result = $lhs.result; }
    ( op=('<' | '<=' | '>' | '>=' | '==' | '!=') rhs=addExpr 
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
  : lhs=relExpr { $result=$lhs.result; }
    ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
  ;
    

orExpr returns [Expr result]
  : lhs=andExpr { $result = $lhs.result; }
    ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
  ;

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel = HIDDEN; }
    ;

COMMENT :  '/*' .* '*/' { $channel = HIDDEN; }
        ;

BOOL_LITERAL  : 'true' | 'false'
              ;

IDENT : LETTER (LETTER | DIGIT | '_')*
      ;

INT :    DIGIT+
    ;

STRING_LITERAL  : '"'
                  (
                    '\\' '"' | ~('"'|'\r'|'\n')
                  )*
                  '"'
                ;

fragment DIGIT: '0'..'9';
fragment LETTER: 'a'..'z'|'A'..'Z';
