package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.type.*;
import org.uva.sea.ql.value.*;
import org.uva.sea.ql.value.StringValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RenderType implements TypeVisitor<Void> {
    private static final int LENGTH = 10;
    private static final String MESSAGE = "Incorrect numeric value. Please enter a number!!";
    private static final String TITLE = "Error Message";
    private boolean enabled;
    private Map<Ident, Value> variables;
    private Map<Ident, List<ObservableStatement>> observableMap;
    private JPanel panel;
    private Ident ident;

    public RenderType(JPanel panel, Ident ident, Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap, boolean enabled) {
        this.panel = panel;
        this.ident = ident;
        this.variables = variables;
        this.observableMap = observableMap;
        this.enabled = enabled;
    }

    @Override
    public Void visit(BoolType type) {
        final JCheckBox checkBox = new JCheckBox("Yes");
        checkBox.setEnabled(this.enabled);
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                variables.put(RenderType.this.ident, new BooleanValue(checkBox.isSelected()));
                // notify observers
                notifyObservers(RenderType.this.ident);
            }
        });
        this.panel.add(checkBox);
        return null;
    }

    @Override
    public Void visit(StringType type) {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.setEditable(this.enabled);
        jTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                variables.put(RenderType.this.ident, new StringValue(jTextField.getText()));
            }
        });
        this.panel.add(jTextField);

        return null;
    }

    @Override
    public Void visit(IntType type) {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.setEditable(this.enabled);
        jTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                final String text = jTextField.getText();
                Integer value = 0;
                try
                {
                    if(!text.isEmpty())
                    {
                        value = Integer.valueOf(text);
                    }
                }
                catch(NumberFormatException nfe)
                {
                    JOptionPane.showMessageDialog(panel, MESSAGE, TITLE, JOptionPane.ERROR_MESSAGE);
                }

                variables.put(RenderType.this.ident, new IntegerValue(value));
            }

        });
        this.panel.add(jTextField);

        return null;
    }

    @Override
    public Void visit(MoneyType type) {
        final JTextField jTextField = new JTextField(LENGTH);
        jTextField.setEditable(this.enabled);
        jTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                update();
            }

            public void removeUpdate(DocumentEvent e)
            {
                update();
            }

            public void insertUpdate(DocumentEvent e)
            {
                update();
            }

            public void update()
            {
                final String text = jTextField.getText();
                Double value = 0.0;
                try
                {
                    if(!text.isEmpty())
                    {
                        value = Double.valueOf(text);
                    }
                }
                catch(NumberFormatException nfe)
                {
                    JOptionPane.showMessageDialog(panel, MESSAGE, TITLE, JOptionPane.ERROR_MESSAGE);
                }

                variables.put(RenderType.this.ident, new MoneyValue(value));
            }

        });
        this.panel.add(jTextField);

        return null;
    }

    @Override
    public Void visit(NumericType type) {
        type.accept(this);
        return null;
    }

    private void notifyObservers(Ident ident)
    {
        List<ObservableStatement> observableStatements = observableMap.get(ident);
        if(observableStatements != null)
        {
            for (ObservableStatement observableStatement : observableStatements) {
                observableStatement.notifyObs();
            }
        }
    }
}
