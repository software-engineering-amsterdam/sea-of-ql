package org.uva.sea.ql.variable.observer;

import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.main.QLMainApp;
import org.uva.sea.ql.value.impl.BooleanValue;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class ConditionObserver implements Observer
{
    private final Collection<BranchPanel> branchPanels;

    public ConditionObserver(final Collection<BranchPanel> branchPanels)
    {
        this.branchPanels = branchPanels;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        for(final BranchPanel branchPanel : branchPanels)
        {
            final IfNode.Branch branch = branchPanel.getBranch();
            final JPanel panel = branchPanel.getJPanel();
            final BooleanValue booleanValue = ((BooleanValue) branch.evaluateExpression());
            if(booleanValue!=null && booleanValue.getValue())
            {
                // clearing all states
                clearingAllStates();
                // set the current block to be true and exit the loop right away
                panel.setVisible(!panel.isVisible());
                break;
            }
            else
            {
                panel.setVisible(false);
            }
        }

        QLMainApp.getFrame().pack();
    }

    private void clearingAllStates()
    {
        for(final JPanel jPanel : getAllPanels())
        {
            jPanel.setVisible(false);
        }
    }

    private Collection<JPanel> getAllPanels()
    {
        Collection<JPanel> jPanels = new ArrayList<>();
        for(final BranchPanel branchPanel : branchPanels)
        {
            jPanels.add(branchPanel.getJPanel());
        }
        return jPanels;
    }

    public static class BranchPanel
    {
        private final IfNode.Branch branch;
        private final JPanel jPanel;

        public BranchPanel(final IfNode.Branch branch, final JPanel jPanel)
        {
            this.branch = branch;
            this.jPanel = jPanel;
        }

        public IfNode.Branch getBranch()
        {
            return branch;
        }

        public JPanel getJPanel()
        {
            return jPanel;
        }
    }

}
