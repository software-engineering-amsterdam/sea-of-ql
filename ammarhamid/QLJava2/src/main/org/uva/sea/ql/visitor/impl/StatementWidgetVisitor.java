package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.BlockNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.variable.observer.ConditionObserver;
import org.uva.sea.ql.visitor.StatementVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatementWidgetVisitor implements StatementVisitor
{
    private final JFrame frame;
    private final JPanel panel;
    private final VariableState variableState;

    private StatementWidgetVisitor(final JFrame frame, final JPanel panel, final VariableState variableState)
    {
        this.frame = frame;
        this.panel = panel;
        this.variableState = variableState;
    }

    public static JPanel render(final JFrame frame, final JPanel panel, final Statement statement, final VariableState variableState)
    {
        final StatementWidgetVisitor statementWidgetVisitor = new StatementWidgetVisitor(frame, panel, variableState);
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

        addQuestionPanel(questionPanel);
        addTypePanel(typePanel);
    }

    @Override
    public void visit(final IfNode ifNode)
    {
        final List<ConditionObserver.BranchComponent> branchComponents = new ArrayList<>();
        final List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            JPanel jPanel = new JPanel();
            final BlockNode blockNode = branch.getBlock();
            final List<Component> components = new ArrayList<>();
            final Collection<Statement> statements = blockNode.getStatements();
            for(final Statement statement : statements)
            {
                jPanel = render(this.frame, jPanel, statement, this.variableState);

                final Component question = jPanel.getComponent(0);
                final Component type = jPanel.getComponent(1);

                components.add(question);
                components.add(type);

                question.setVisible(false);
                type.setVisible(false);

                addQuestionPanel(question);
                addTypePanel(type);
            }

            branchComponents.add(new ConditionObserver.BranchComponent(branch, components));
        }
        // register dependencies
        final ConditionObserver conditionObserver = registerConditionDependency(branchComponents);

        // trigger if there is an 'else' statement to be initialize
        conditionObserver.update(null, null);
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public ConditionObserver registerConditionDependency(final Collection<ConditionObserver.BranchComponent> branchComponents)
    {
        final ConditionObserver conditionObserver = new ConditionObserver(this.frame, branchComponents);
        this.variableState.addObserver(conditionObserver);
        return conditionObserver;
    }

    private void addQuestionPanel(final Component question)
    {
        this.panel.add(question, "left, gapright 10");
    }

    private void addTypePanel(final Component type)
    {
        this.panel.add(type, "left, span");
    }

}
