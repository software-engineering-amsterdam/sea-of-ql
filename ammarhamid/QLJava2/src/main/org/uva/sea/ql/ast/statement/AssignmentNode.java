package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class AssignmentNode implements Statement
{
    private final String question;
    private final String identifier;
    private final Type type;

    public AssignmentNode(final String question, final String identifier, final Type type)
    {
        this.question = question;
        this.identifier = identifier;
        this.type = type;
    }

    public void accept(final StatementVisitor statementVisitor)
    {
        statementVisitor.visit(this);
    }

    public String getQuestion()
    {
        return question;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public Type getType()
    {
        return type;
    }

    // TODO move this code to GUI interpreter
//    public Value evaluate()
//    {
//        this.variableScope.assign(this.identifier, this.value);
//        return null;
//    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + this.identifier + " = " +this.value.toTreeString(" ");
//    }
}
