package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public interface TypeVisitor {

	AbstractVisibleControl visit(BoolType bool, Ident ident);

	AbstractVisibleControl visit(IntType i, Ident ident);

	AbstractVisibleControl visit(MoneyType money, Ident ident);

	AbstractVisibleControl visit(StringType str, Ident ident);

	AbstractVisibleControl visit(NumericType i, Ident ident);

	AbstractVisibleControl visit(UndefinedType i, Ident ident);
}
