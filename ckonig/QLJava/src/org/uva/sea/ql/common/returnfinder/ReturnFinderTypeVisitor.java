package org.uva.sea.ql.common.returnfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;
 class ReturnFinderTypeVisitor extends AbstractReturnFinderVisitor
        implements TypeVisitor {

    public ReturnFinderTypeVisitor(List<Question> q) {
        super(q);
    }

    @Override
    public final void visit(BooleanType b) {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(Money m) {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(StrType s) {
        this.ret = StrType.class;
    }

    @Override
    public final void visit(IntType i) {
        this.ret = AbstractMathType.class;
    }

    @Override
    public void visit(NullType n) {
        this.ret = NullType.class;
    }
}
