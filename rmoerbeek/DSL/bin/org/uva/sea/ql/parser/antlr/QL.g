grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.types.*;
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
// Form

form returns [Form result]
  : f='form' Ident body {
      $result = new Form( new Ident($Ident.text), $body.result);
    } EOF
  ;
  
topBody returns [Body result]
  : body EOF
  ;
  
//body returns [Body result]
//  @init { List<FormElem> elemList = new ArrayList<>() ; }
// //{ $result = new Body(elemList) ; }
 // : '{' (formElem { elemList.add($formElem.result); } )* '}'
 // { $result = new Body(elemList) ; }
 // ;
 
 body returns [Body result]
  @init
  {
    List<Statement> stats = new ArrayList<Statement>();
  }
  : '{' (s=statement {stats.add(s);})* '}' {$result = new Body(stats); } ;
  
 statement returns [Statement result]
    : i=ifStat {$result = $i.result;}
    | q=question {$result = $q.result;} 
    | b=body {$result = $b.result;}
    ;
  
//topFormElem returns [FormElem result]
//  : formElem {$result = $formElem.result ;} EOF
//  ;
  
//formElem returns [FormElem result]  
//  : question { $result = $question.result ; } 
//  | ifStat { $result = $ifStat.result ; } 
//  ;
 


// Questions

//topQuestionBlock returns [QuestionBlock result]
//  :questionBlock {$result = $questionBlock.result ;} EOF
//  ;

//questionBlock returns [QuestionBlock result]
//  @init { List<Question> qList = new ArrayList<>() ; }
//  : (question {qList.add($question.result) ; } )+
//  { $result = new QuestionBlock(qList) ; }
//  ;

topQuestion returns [Question result]
  : question {$result = $question.result ; } EOF
  ;

question returns [Question result]
    : id = Ident ':' label = StringLit t = type '(' expr = orExpr ')'
    { $result = new ComputedQuestion( new Ident($id.text), $label.text, $t.result, $expr.result); }
    | id = Ident ':' label = StringLit t = type
    { $result = new NonComputedQuestion(new Ident($id.text), $label.text, $t.result) ; }
    ;

//    : computedQuestion { $result = $computedQuestion.result ; }
//    | nonComputedQuestion {$result = $nonComputedQuestion.result ; }
//    ;

nonComputedQuestion returns [NonComputedQuestion result]
    : id = Ident ':' label = StringLit t = type
    { $result = new NonComputedQuestion(new Ident($id.text), $label.text, $t.result) ; }
    ;

computedQuestion returns [ComputedQuestion result]
    : id = Ident ':' label = StringLit t = type '(' expr = orExpr ')'
    { $result = new ComputedQuestion( new Ident($id.text), $label.text, $t.result, $expr.result); }
    ;


// Expressions

expression returns [Expr result]
  : orExpr { $result = $orExpr.result; } 
  ; 

primary returns [Expr result]
    : i = Int   { $result = new Int(Integer.parseInt($i.text)) ; }
    | id = Ident { $result = new Ident($id.text) ; }
    | str = StringLit { $result = new Str($str.text) ; }
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

// Conditional Statements


topIfStat returns [IfStat result] 
  : ifStat {$result = $ifStat.result ; }
  ;


ifStat returns [IfStat result]
  @init { List<ElseIfStat> elseIfStats = new ArrayList<>() ; 
  ElseStat elseStat = null ; }
  : 'if' '(' cond = expression ')' iB = body
  (
    'else if' '(' eCond = expression ')' eiB = body
    { elseIfStats.add( new ElseIfStat($eCond.result, $eiB.result) ) ; }
  )*
  (
    'else' eB = body
    { elseStat = new ElseStat($eB.result) ; }
  )?
  { $result = new IfStat($cond.result, $iB.result, elseIfStats, elseStat) ; }
  ;


// Types

type returns [Type result]
    : b = Boolean { $result = new BooleanType(); }
    | m = Money { $result = new MoneyType(); }
    | i = Inttype { $result = new IntType(); }
    | s = String { $result = new StringType(); }
    ;
    
    
// Tokens

Boolean
    : 'boolean'
    ;
    
Money
    : 'money'
    ;

String
    : 'string'
    ;
    
Inttype
    : 'integer'
    ;

WS  
    :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

comment 
    : ( MultiLineComment | SingleLineComment )+
    ;
    
//StringLit  
//  : '"'
//  (
//    '\\' '"' | ~('"'|'\r'|'\n')
//  )*
//  '"'
//  ;

StringLit : '"' ('""' | ~'"')* '"'; 

MultiLineComment
    : '/*' .* '*/' {$channel=HIDDEN;}
    ;
    
SingleLineComment 
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

Ident
    : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

Int
    : ('0'..'9')+
    ;