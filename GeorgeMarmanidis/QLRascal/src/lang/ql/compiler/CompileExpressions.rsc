@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::CompileExpressions
//change the name
import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;
import IO;

alias BDITS=list[FormBodyItem];

public str generateJavaScriptExpr(ident(str name),BDITS bodyItems){
	str code="";
	switch(getVariableType(name,bodyItems)){
	case integer() : code= "parseInt(document.getElementById(\"<name>\").value)";
	case string()  : code= "document.getElementById(\"<name>\").value";
	case boolean() : code= "document.getElementById(\"<name>\").checked";
	case date()	   : code= "document.getElementById(\"<name>\").value";
	case money()   : code= "document.getElementById(\"<name>\").value";
	case float()   : code= "parseFloat(document.getElementById(\"<name>\").value)";
	}
	return code;
}
public str generateJavaScriptExpr(\int(int ivalue),BDITS bodyItems)="parseInt(\"<ivalue>\")";
public str generateJavaScriptExpr(/string(str strValue),BDITS bodyItems)="<strValue>";
public str generateJavaScriptExpr(/boolean(str bValue),BDITS bodyItems)="<bValue>";
public str generateJavaScriptExpr(/date(str dValue),BDITS bodyItems)="<dValue>"; //I think parseDate?
public str generateJavaScriptExpr(/money (str monValue),BDITS bodyItems)="\"<monValue> Euro\"";
public str generateJavaScriptExpr(/float (real fValue),BDITS bodyItems)="parseFloat(\"<fValue>\")";

public str generateJavaScriptExpr(add(Expr addLeft, Expr addRight),BDITS bodyItems)="<generateJavaScriptExpr(addLeft,bodyItems)>  + <generateJavaScriptExpr(addRight,bodyItems)>";
public str generateJavaScriptExpr(mul(Expr multLeft, Expr multright),BDITS bodyItems)="<generateJavaScriptExpr(multLeft,bodyItems)> * <generateJavaScriptExpr(multright,bodyItems)>";
public str generateJavaScriptExpr(div(Expr divLeft, Expr divRight),BDITS bodyItems)="<generateJavaScriptExpr(divLeft,bodyItems)>/<generateJavaScriptExpr(divRight,bodyItems)>";
public str generateJavaScriptExpr(sub(Expr subLeft, Expr subRight),BDITS bodyItems)="<generateJavaScriptExpr(subLeft,bodyItems)> - <generateJavaScriptExpr(subRight,bodyItems)>";

public str generateJavaScriptExpr(pos(Expr posValue),BDITS bodyItems)="Math.abs(<generateJavaScriptExpr(posValue,bodyItems)>)";
public str generateJavaScriptExpr(neg(Expr negValue),BDITS bodyItems)="-Math.abs(<generateJavaScriptExpr(negValuebodyItems)>)";
public str generateJavaScriptExpr(not(Expr notValue),BDITS bodyItems)="!(<generateJavaScriptExpr(notValue,bodyItems)>)";

public str generateJavaScriptExpr(lt(Expr ltLeft, Expr ltRight),BDITS bodyItems)="<generateJavaScriptExpr(ltLeft,bodyItems)> \< <generateJavaScriptExpr(ltRight,bodyItems)>";
public str generateJavaScriptExpr(leq(Expr leqLeft, Expr leqRight),BDITS bodyItems)="<generateJavaScriptExpr(leqLeft,bodyItems)> \<= <generateJavaScriptExpr(leqRight,bodyItems)>";
public str generateJavaScriptExpr(gt(Expr gtLeft, Expr gtRight),BDITS bodyItems)="<generateJavaScriptExpr(gtLeft,bodyItems)> \> <generateJavaScriptExpr(gtRight,bodyItems)>";
public str generateJavaScriptExpr(geq(Expr getLeft, Expr getRight),BDITS bodyItems)="<generateJavaScriptExpr(getLeft,bodyItems)> \>= <generateJavaScriptExpr(getRight,bodyItems)>";
public str generateJavaScriptExpr(eq(Expr eqLeft, Expr eqRight),BDITS bodyItems)="(<generateJavaScriptExpr(eqLeft,bodyItems)>) == (<generateJavaScriptExpr(eqRight,bodyItems)>)";
public str generateJavaScriptExpr(neq(Expr neqLeft, Expr neqRight),BDITS bodyItems)="(<generateJavaScriptExpr(neqLeft,bodyItems)>) != (<generateJavaScriptExpr(neqRight,bodyItems)>)";

public str generateJavaScriptExpr(and(Expr andLeft, Expr andRight),BDITS bodyItems)="(<generateJavaScriptExpr(andLeft,bodyItems)>) && (<generateJavaScriptExpr(andRight,bodyItems)>)";
public str generateJavaScriptExpr(or(Expr orLeft, Expr orRight),BDITS bodyItems)="(<generateJavaScriptExpr(orLeft,bodyItems)>) || (<generateJavaScriptExpr(orRight,bodyItems)>)";