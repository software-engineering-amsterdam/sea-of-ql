package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.questionnaire.ui.swing.control.Control;

public interface TypeVisitor {

	Control visit(BoolType bool);

	Control visit(IntType i);

	Control visit(MoneyType money);

	Control visit(StringType str);

	Control visit(NumericType i);

	Control visit(UndefinedType i);
}
