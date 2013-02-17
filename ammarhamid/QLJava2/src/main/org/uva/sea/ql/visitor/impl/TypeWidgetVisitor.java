package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.visitor.TypeVisitor;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TypeWidgetVisitor implements TypeVisitor
{
    public static final int LENGTH = 10;
    private final JPanel panel;
    private final VariableState variableState;
    private final String identifier;

    public TypeWidgetVisitor(JPanel panel, String identifier, VariableState variableState)
    {
        this.panel = panel;
        this.variableState = variableState;
        this.identifier = identifier;
    }

    @Override
    public void visit(BooleanType booleanType)
    {
        final JCheckBox checkBox = new JCheckBox("Yes");
        this.panel.add(checkBox);

        checkBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new BooleanValue(checkBox.isSelected()));
            }
        });
    }

    @Override
    public void visit(StringType stringType)
    {
        this.panel.add(new JTextField(LENGTH));
    }

    @Override
    public void visit(IntegerType integerType)
    {
        this.panel.add(new JTextField(LENGTH));
    }

    @Override
    public void visit(MoneyType moneyType)
    {
        this.panel.add(new JTextField(LENGTH));
    }

    public JPanel getPanel()
    {
        return panel;
    }
}
