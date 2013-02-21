grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@parser::members {
  @Override
  public void reportError(RecognitionException e) {
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
        $lbl.text, $type.result);
    }
  | id=IDENT ':' lbl=STRING_LITERAL type '(' cond=expression close=')'
    {
      $result = new Computed(
        new Ident($id.text, new Location($id.line, $id.pos, $id.line,
          $id.pos + $id.text.length())),
        $lbl.text, $type.result, $cond.result, new Location(null, $close.line,
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

ifStatement returns [IfStatement result]
  @init {
    List<ElseIfStatement> elseIfs = new ArrayList<>();
    ElseStatement elseStmt = null;
  }
  : ifTok='if' '(' ic=expression ')' ib=body
    (
      elseIfTok='else' 'if' '(' eic=expression ')' eib=body
      {
        elseIfs.add(new ElseIfStatement($eic.result, $eib.result,
          new Location($elseIfTok.line, $elseIfTok.pos, null)));
      }
    )*
    (
      elseTok='else' eb=body
      {
        elseStmt = new ElseStatement($eb.result, new Location($elseTok.line,
          $elseTok.pos, null));
      }
    )?
    {
      $result = new IfStatement($ic.result, $ib.result, elseIfs, elseStmt,
        new Location($ifTok.line, $ifTok.pos, null)); 
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
      $result = new Int(Integer.parseInt($INT.text), new Location($INT.line,
        $INT.pos, $INT.line, $INT.pos + $INT.text.length()));
    }
  | IDENT
    {
      $result = new Ident($IDENT.text, new Location($IDENT.line, $IDENT.pos,
          $IDENT.line, $IDENT.pos + $IDENT.text.length()));
    }
  | STRING_LITERAL
    {
      $result = new Str($STRING_LITERAL.text,
        new Location($STRING_LITERAL.line, $STRING_LITERAL.pos,
          $STRING_LITERAL.line,
          $STRING_LITERAL.pos + $STRING_LITERAL.text.length()));
    }
  | '(' orExpr ')' { $result = $orExpr.result; }
  ;
    
unExpr returns [Expr result]
  : '+' x=unExpr { $result = new Pos($x.result); }
  | '-' x=unExpr { $result = new Neg($x.result); }
  | '!' x=unExpr { $result = new Not($x.result); }
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
