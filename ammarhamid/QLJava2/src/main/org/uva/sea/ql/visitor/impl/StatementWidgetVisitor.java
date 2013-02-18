package org.uva.sea.ql.visitor.impl;

import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.BlockNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.observer.ConditionObserver;
import org.uva.sea.ql.visitor.StatementVisitor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatementWidgetVisitor implements StatementVisitor
{
    private final JPanel panel;
    private final VariableState variableState;

    private StatementWidgetVisitor(final VariableState variableState)
    {
        this.panel = new JPanel(new MigLayout("hidemode 3"));
        this.variableState = variableState;
    }

    public static JPanel render(final Statement statement, final VariableState variableState)
    {
        final StatementWidgetVisitor statementWidgetVisitor = new StatementWidgetVisitor(variableState);
        statement.accept(statementWidgetVisitor);
        return statementWidgetVisitor.getPanel();
    }

    @Override
    public void visit(final AssignmentNode assignmentNode)
    {
        final String question = assignmentNode.getQuestion();
        final JPanel questionPanel = new JPanel();
        questionPanel.add(new JLabel(question));

        final JPanel typePanel = new JPanel();
        final Type type = assignmentNode.getType();
        type.accept(new TypeWidgetVisitor(typePanel, assignmentNode.getIdentifier(), this.variableState));

        this.panel.add(questionPanel, "left, gapright 10");
        this.panel.add(typePanel, "left, span");
    }

    @Override
    public void visit(final BlockNode blockNode)
    {
        final Collection<Statement> statements = blockNode.getStatements();
        for(Statement statement : statements)
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(final IfNode ifNode)
    {
        final List<ConditionObserver.BranchPanel> branchPanels = new ArrayList<>();
        final List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            final Statement statement = (Statement) branch.getBlock();
            final JPanel branchBlockPanel = render(statement, this.variableState);
            branchBlockPanel.setVisible(false);
            this.panel.add(branchBlockPanel, "grow, span");
            branchPanels.add(new ConditionObserver.BranchPanel(branch, branchBlockPanel));
        }
        // register dependencies
        final ConditionObserver conditionObserver = registerConditionDependency(branchPanels);

        // trigger if there is an 'else' statement to be initialize
        conditionObserver.update(null, null);
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public ConditionObserver registerConditionDependency(final Collection<ConditionObserver.BranchPanel> branchPanels)
    {
        final ConditionObserver conditionObserver = new ConditionObserver(branchPanels);
        this.variableState.addObserver(conditionObserver);
        return conditionObserver;
    }

}
