package org.uva.sea.ql.interpretation.components.control;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.uva.sea.ql.interpretation.SwingHelper;

public final class SaveResultPanel extends JPanel {

    private static final long serialVersionUID = 1949530516980497007L;
    private final JButton saveButton;
    private final SwingHelper helper;

    public SaveResultPanel(SwingHelper h) {
        this.helper = h;
        this.saveButton = new JButton("Save");
        this.add(this.saveButton);
        addSaveResultListener(this.saveButton);
    }

    private void addSaveResultListener(JButton b) {
        b.addActionListener(new SaveResultActionListener(this.helper));
    }
}
