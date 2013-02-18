module visualization::PrintOutput

import Prelude;
import syntax::AbstractSyntax;

//  Convert expressions into text
public str make(moneyCon(real M)) = "<M>";
public str make(boolCon(bool B)) = "<B>";
public str make(integer(bool B)) = "<B>";
public str make(strCon(str S)) = S;
public str make(str S) = S;				//Adding str make to print id and other strings
public str make(Type T) = "<T>";

public str make(syntax::AbstractSyntax::id(str name)) = name;  // not working
public str make(add(Expression E1, Expression E2)) = "<make(E1)> + <make(E2)>";
public str make(sub(Expression E1, Expression E2)) = "<make(E1)> - <make(E2)>";
public str make(mul(Expression E1, Expression E2)) = "<make(E1)> * <make(E2)>";
public str make(div(Expression E1, Expression E2)) = "<make(E1)> / <make(E2)>";
public str make(lt(Expression E1, Expression E2)) = "<make(E1)> \< <make(E2)>";
public str make(leq(Expression E1, Expression E2)) = "<make(E1)> \<= <make(E2)>";
public str make(gt(Expression E1, Expression E2)) = "<make(E1)> \> <make(E2)>";
public str make(geq(Expression E1, Expression E2)) = "<make(E1)> \>= <make(E2)>";
public str make(eq(Expression E1, Expression E2)) = "<make(E1)> == <make(E2)>";
public str make(geq(Expression E1, Expression E2)) = "<make(E1)> != <make(E2)>";
public str make(or(Expression E1, Expression E2)) = "<make(E1)> || <make(E2)>";
public str make(and(Expression E1, Expression E2)) = "<make(E1)> && <make(E2)>";

public str make(question:easyQuestion(str id, str labelQuestion, Type tp)) {
	return "<make(id)> + <make(labelQuestion)> + <make(tp)>"; 
}

public str make(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)) {
	return "<make(id)> + <make(labelQuestion)> + <make(tp)> + <make(exp)>";   
}