package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.statement.AssignmentNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.IfNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.main.QLMainApp;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.visitor.StatementVisitor;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StatementWidgetVisitor implements StatementVisitor, Observer
{
    public static final String CONSTRAINTS = "right, gapright 12";
    private final JPanel mainPanel;
    private final VariableState variableState;
    private final ConcurrentMap<String, IfNode> ifNodes;

    public StatementWidgetVisitor(final JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        this.variableState = new VariableState();
        variableState.addObserver(this);
        this.ifNodes = new ConcurrentHashMap<>();
    }

    @Override
    public void visit(final AssignmentNode assignmentNode)
    {
        final String question = assignmentNode.getQuestion();
        final Type type = assignmentNode.getType();
        this.mainPanel.add(new JLabel(question), CONSTRAINTS);
        type.accept(new TypeWidgetVisitor(this.mainPanel, assignmentNode.getIdentifier(), this.variableState));
    }

    @Override
    public void visit(final BlockNode blockNode)
    {
        Collection<Statement> statements = blockNode.getStatements();
        for(Statement statement : statements)
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfNode ifNode)
    {
        System.out.println("Visiting ifNode");
        IfNode ifNode1 = this.ifNodes.putIfAbsent(ifNode.toString(), ifNode);

        final List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            Value value = branch.evaluateExpression();
            // TODO check if casting is necessary here !!!
            BooleanValue value1 = ((BooleanValue) value);
            if(value1!=null && value1.getValue())
            {
                visit((BlockNode)(branch.getBlock()));
                mainPanel.revalidate();
                mainPanel.repaint();
                QLMainApp.getFrame().pack();
                return;
            }
        }
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println("add variable: " +arg);
        Map<String, Value> variableMap = VariableState.getVariableMap();
        for(Map.Entry<String, Value> stringValueEntry : variableMap.entrySet())
        {
            System.out.println("stringValueEntry = " + stringValueEntry);
        }

        for(Map.Entry<String, IfNode> stringIfNodeEntry : ifNodes.entrySet())
        {
            visit(stringIfNodeEntry.getValue());
        }
    }
}
