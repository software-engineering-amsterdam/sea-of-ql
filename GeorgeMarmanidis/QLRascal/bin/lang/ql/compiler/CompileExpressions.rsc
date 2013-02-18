@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::CompileExpressions

import lang::ql::ast::AST;

import IO;

public str generateJavaScriptExpr(ident(str name))="document.getElementById(\"<name>\").value";
public str generateJavaScriptExpr(\int(int ivalue))="parseInt(\"<ivalue>\")";
public str generateJavaScriptExpr(/string(str strValue))="<strValue>";
public str generateJavaScriptExpr(/boolean(str bValue))="<bValue>";
public str generateJavaScriptExpr(/date(str dValue))="<dValue>"; //I think parseDate?
public str generateJavaScriptExpr(/money (str monValue))="\"<monValue> Euro\"";
public str generateJavaScriptExpr(/float (real fValue))="parseFloat(\"<fValue>\")";

public str generateJavaScriptExpr(add(Expr addLeft, Expr addRight))="<generateJavaScriptExpr(addLeft)>  + <generateJavaScriptExpr(addRight)>";
public str generateJavaScriptExpr(mul(Expr multLeft, Expr multright))="<generateJavaScriptExpr(multLeft)> * <generateJavaScriptExpr(multright)>";
public str generateJavaScriptExpr(div(Expr divLeft, Expr divRight))="<generateJavaScriptExpr(divLeft)>/<generateJavaScriptExpr(divRight)>";
public str generateJavaScriptExpr(sub(Expr subLeft, Expr subRight))="<generateJavaScriptExpr(subLeft)> - <generateJavaScriptExpr(subRight)>";

public str generateJavaScriptExpr(pos(Expr posValue))="Math.abs(<generateJavaScriptExpr(posValue)>)";
public str generateJavaScriptExpr(neg(Expr negValue))="-Math.abs(<generateJavaScriptExpr(negValue)>)";
public str generateJavaScriptExpr(not(Expr notValue))="!(<generateJavaScriptExpr(notValue)>)";

public str generateJavaScriptExpr(lt(Expr ltLeft, Expr ltRight))="<generateJavaScriptExpr(ltLeft)> \< <generateJavaScriptExpr(ltRight)>";
public str generateJavaScriptExpr(leq(Expr leqLeft, Expr leqRight))="<generateJavaScriptExpr(leqLeft)> \<= <generateJavaScriptExpr(leqRight)>";
public str generateJavaScriptExpr(gt(Expr gtLeft, Expr gtRight))="<generateJavaScriptExpr(gtLeft)> \> <generateJavaScriptExpr(gtRight)>";
public str generateJavaScriptExpr(geq(Expr getLeft, Expr getRight))="<generateJavaScriptExpr(getLeft)> \>= <generateJavaScriptExpr(getRight)>";
public str generateJavaScriptExpr(eq(Expr eqLeft, Expr eqRight))="<generateJavaScriptExpr(eqLeft)> == <generateJavaScriptExpr(eqRight)>";
public str generateJavaScriptExpr(neq(Expr neqLeft, Expr neqRight))="<generateJavaScriptExpr(neqLeft)> != <generateJavaScriptExpr(neqRight)>";

public str generateJavaScriptExpr(and(Expr andLeft, Expr andRight))="<generateJavaScriptExpr(andLeft)> && <generateJavaScriptExpr(andRight)>";
public str generateJavaScriptExpr(or(Expr orLeft, Expr orRight))="<generateJavaScriptExpr(orLeft)> || <generateJavaScriptExpr(orRight)>";