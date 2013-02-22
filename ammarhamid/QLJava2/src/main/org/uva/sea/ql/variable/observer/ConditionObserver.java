package org.uva.sea.ql.variable.observer;

import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.value.impl.BooleanValue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class ConditionObserver implements Observer
{
    private final Collection<BranchComponent> branchComponents;
    private final JFrame frame;

    public ConditionObserver(final JFrame frame, final Collection<BranchComponent> branchComponents)
    {
        this.frame = frame;
        this.branchComponents = branchComponents;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        for(final BranchComponent branchComponent : branchComponents)
        {
            final IfNode.Branch branch = branchComponent.getBranch();
            final Collection<Component> components = branchComponent.getComponents();
            final BooleanValue booleanValue = ((BooleanValue) branch.evaluateExpression());
            if(booleanValue!=null && booleanValue.getValue())
            {
                // clearing all states
                clearingAllStates();
                for(Component component : components)
                {
                    component.setVisible(!component.isVisible());
                }
                break;
            }
            else
            {
                for(Component component : components)
                {
                    component.setVisible(false);
                }
            }
        }

        this.frame.pack();
    }

    private void clearingAllStates()
    {
        for(final Collection<Component> components : getAllComponents())
        {
            for(final Component component : components)
            {
                component.setVisible(false);
            }

        }
    }

    private Collection<Collection<Component>> getAllComponents()
    {
        Collection<Collection<Component>> components = new ArrayList<>();
        for(final BranchComponent branchComponent : branchComponents)
        {
            components.add(branchComponent.getComponents());
        }
        return components;
    }

    public static class BranchComponent
    {
        private final IfNode.Branch branch;
        private final Collection<Component> components;

        public BranchComponent(final IfNode.Branch branch, final Collection<Component> components)
        {
            this.branch = branch;
            this.components = components;
        }

        public IfNode.Branch getBranch()
        {
            return branch;
        }

        public Collection<Component> getComponents()
        {
            return components;
        }
    }

}
