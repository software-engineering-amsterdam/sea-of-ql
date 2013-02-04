grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result]
    : Bool    { $result = new org.uva.sea.ql.ast.expr.value.Bool(Boolean.parseBoolean($Bool.text)); }
    | Int     { $result = new org.uva.sea.ql.ast.expr.value.Int(Integer.parseInt($Int.text)); }
    | strExpr { $result = $strExpr.result; }
    | Ident   { $result = new Ident($Ident.text); }
    | '(' x=orExpr ')'{ $result = $x.result; }
    ;
    
strExpr returns [org.uva.sea.ql.ast.expr.value.Str result]
    : Str   { $result = new org.uva.sea.ql.ast.expr.value.Str($Str.text.substring(1, $Str.text.length() - 1)); }
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
    : 'form' Ident '{' statements '}' { 
        $result = new Form(new Ident($Ident.text), $statements.result); 
      }
    ;
    
statements returns [Statement result]
    @init {
        ArrayList<Statement> statements = new ArrayList<Statement>();
    }
    @after {
        if(statements.isEmpty())
            result = new NullStatement();
        else if(statements.size() == 1)
            result = statements.get(0);
        else
            result = new CompositeStatement(statements);
    }
    : (statement { statements.add($statement.result); })*
    ;
    
statement returns [Statement result]
    : ifStatement { $result = $ifStatement.result; }
    | questionStatement { $result = $questionStatement.result; }
    | computedStatement { $result = $computedStatement.result; }
    | storedExpressionStatement { $result = $storedExpressionStatement.result; }
    ;
    
storedExpressionStatement returns [StoredExpression result]
    : Ident '=' orExpr { $result = new StoredExpression(new Ident($Ident.text), $orExpr.result); }
    ;
    
questionStatement returns [Question result]
    : strExpr Ident ':' typeDeclaration { 
        $result = new Question($strExpr.result.getValue(), new Ident($Ident.text), $typeDeclaration.result); }
    ;

Type: 'string'|'boolean'|'integer'; 
typeDeclaration returns [Type result]
    : Type {
        if($Type.text.equals("boolean"))
          $result = new org.uva.sea.ql.ast.type.Bool();
        else if($Type.text.equals("integer"))
          $result = new org.uva.sea.ql.ast.type.Int();
        else if($Type.text.equals("string"))
          $result = new org.uva.sea.ql.ast.type.Str();
      }
    ;

computedStatement returns [Computed result]
    : strExpr orExpr { $result = new Computed($strExpr.result.getValue(), $orExpr.result); }
    ;
   
ifStatement returns [Statement result]
    : 'if' '(' orExpr ')' '{' ifElements = statements '}' 'else' elseElement = ifStatement
        { $result = new IfElse($orExpr.result, $ifElements.result, $elseElement.result); }
    | 'if' '(' orExpr ')' '{' ifElements = statements '}' 'else' '{' elseElements = statements'}' 
        { $result = new IfElse($orExpr.result, $ifElements.result, $elseElements.result); }
    | 'if' '(' orExpr ')' '{' statements '}' 
        { $result = new If($orExpr.result, $statements.result); }
    ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~NewLine* {$channel=HIDDEN;}
    ;

NewLine: '\n' | '\r\n';

Bool: 'true'|'false';

Str: '\"' ('\\"'|~'\"')* '\"';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;