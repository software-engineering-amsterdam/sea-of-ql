package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.value.impl.IntegerValue;
import org.uva.sea.ql.value.impl.MoneyValue;
import org.uva.sea.ql.value.impl.StringValue;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.TypeVisitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        checkBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new BooleanValue(checkBox.isSelected()));
            }
        });
        this.panel.add(checkBox);

    }

    @Override
    public void visit(StringType stringType)
    {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new StringValue(jTextField.getText()));
            }
        });
        this.panel.add(jTextField);
    }


    @Override
    public void visit(IntegerType integerType)
    {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new IntegerValue(jTextField.getText()));
            }
        });
        this.panel.add(jTextField);
    }

    @Override
    public void visit(MoneyType moneyType)
    {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                variableState.add(TypeWidgetVisitor.this.identifier, new MoneyValue(jTextField.getText()));
            }
        });
        this.panel.add(jTextField);
    }

    public JPanel getPanel()
    {
        return panel;
    }
}
