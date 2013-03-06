package org.uva.sea.ql.interpretation.components;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LeftPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 5134179366168025629L;
    private final JTextArea log;

    public LeftPanel() {
        this.log = new JTextArea();
        this.log.setSize(PanelDimensions.getLeftDimension());
        this.log.setText("");
        this.log.setLineWrap(true);
        this.add(this.log);
        this.setBackground(Color.red);
    }

    public final JTextArea getLog() {
        return this.log;
    }
}
