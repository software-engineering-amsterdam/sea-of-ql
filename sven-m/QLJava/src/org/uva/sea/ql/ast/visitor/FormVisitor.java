package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.form.BoolType;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.ElseIfStatement;
import org.uva.sea.ql.ast.form.ElseStatement;
import org.uva.sea.ql.ast.form.IntType;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.StrType;

public interface FormVisitor<T> {
	T visit(Form ast);
	T visit(Body ast);
	T visit(IfStatement ast);
	T visit(ElseIfStatement ast);
	T visit(ElseStatement ast);
	T visit(Question ast);
	T visit(Computed ast);
	T visit(IntType ast);
	T visit(BoolType ast);
	T visit(StrType ast);
}
