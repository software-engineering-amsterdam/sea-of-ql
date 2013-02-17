package org.uva.sea.ql.visitor.impl;

import net.miginfocom.swing.MigLayout;
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
    private final JPanel panel;
    private final VariableState variableState;
    private final ConcurrentMap<IfNode, List<BranchPanel>> ifNodes;

    private StatementWidgetVisitor(final VariableState variableState)
    {
        this.panel = new JPanel(new MigLayout("hidemode 3"));
        this.variableState = variableState;
        variableState.addObserver(this);
        this.ifNodes = new ConcurrentHashMap<>();
    }

    public static JPanel render(Statement statement, VariableState variableState) {
        StatementWidgetVisitor statementWidgetVisitor = new StatementWidgetVisitor(variableState);
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

        this.panel.add(questionPanel, "right, gapright 12");
        this.panel.add(typePanel, "span");
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
        final List<BranchPanel> branchPanels = new ArrayList<>();
        final List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            Value value = branch.evaluateExpression();
            Statement statement = (Statement) branch.getBlock();
            JPanel branchBlockPanel = render(statement, this.variableState);
            branchBlockPanel.setVisible(false);
            branchPanels.add(new BranchPanel(branch, branchBlockPanel));
            panel.add(branchBlockPanel, "right, gapright 12, span");
        }
        ifNodes.put(ifNode, branchPanels);

        // trigger if there is an else statement to be initialize
        update(null, null);
    }

    public JPanel getPanel()
    {
        return panel;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        // TODO remove this print - debug usage only !!
        Map<String, Value> variableMap = VariableState.getVariableMap();
        for(Map.Entry<String, Value> stringValueEntry : variableMap.entrySet())
        {
            System.out.println("stringValueEntry = " + stringValueEntry);
        }

        // TODO refactor this IfNode update task !!!
        for(Map.Entry<IfNode, List<BranchPanel>> ifNodeListEntry : ifNodes.entrySet())
        {
            IfNode key = ifNodeListEntry.getKey();
            List<BranchPanel> branchPanels = ifNodeListEntry.getValue();

            List<JPanel> jPanels = new ArrayList<>();
            for(BranchPanel branchPanel : branchPanels)
            {
                jPanels.add(branchPanel.getjPanel());
            }

            for(BranchPanel branchPanel : branchPanels)
            {
                IfNode.Branch branch = branchPanel.getBranch();
                JPanel panel = branchPanel.getjPanel();
                Value value = branch.evaluateExpression();
                BooleanValue value1 = ((BooleanValue) value);
                if(value1!=null && value1.getValue())
                {
                    // clearing all states
                    for(JPanel jPanel1 : jPanels)
                    {
                        jPanel1.setVisible(false);
                    }
                    // set the current block to be true and exit the loop right away
                    panel.setVisible(!panel.isVisible());
                    break;
                }

            }
        }

        QLMainApp.getFrame().pack();
    }

    // TODO refactor this, maybe a new class ??
    private class BranchPanel
    {
        private final IfNode.Branch branch;
        private final JPanel jPanel;

        private BranchPanel(IfNode.Branch branch, JPanel jPanel)
        {
            this.branch = branch;
            this.jPanel = jPanel;
        }

        public IfNode.Branch getBranch()
        {
            return branch;
        }

        public JPanel getjPanel()
        {
            return jPanel;
        }
    }

}
