package org.uva.sea.ql.ast.statement;

import com.sun.tools.javac.util.*;
import com.sun.tools.javac.util.List;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class IfStatement implements Statement {
    private Expr orExpression;
    private Block ifBlock;
    private Block elseBlock;

    public IfStatement() {
        this.orExpression = null;
        this.ifBlock = null;
        this.elseBlock = null;
    }

    public void addOrExpression(Expr orExpression)
    {
        this.orExpression = orExpression;
    }

    public void addIfBlock(Block ifBlock)
    {
        this.ifBlock = ifBlock;
    }

    public void addElseBlock(Block elseBlock)
    {
        this.elseBlock = elseBlock;
    }

    public Expr getOrExpression() {
        return this.orExpression;
    }

    public Block getIfBlock() {
        return this.ifBlock;
    }

    public Block getElseBlock() {
        return this.elseBlock;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
