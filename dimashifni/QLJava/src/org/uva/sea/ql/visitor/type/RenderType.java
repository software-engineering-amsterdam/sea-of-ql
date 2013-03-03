package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.type.BoolType;
import org.uva.sea.ql.type.IntType;
import org.uva.sea.ql.type.NumericType;
import org.uva.sea.ql.type.StringType;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;

import javax.swing.*;
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

    @Override
    public Void visit(IntType type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(NumericType type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(StringType type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
