package org.uva.sea.ql.interpretation.swing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.interpretation.swing.components.CenterPanel;
import org.uva.sea.ql.interpretation.swing.components.LeftPanel;
import org.uva.sea.ql.interpretation.swing.components.Sizes;
import org.uva.sea.ql.interpretation.swing.components.TopPanel;

public class SwingInterpreter extends JFrame {
    private static final long serialVersionUID = -1942492887122279651L;
    private static final String TITLE = "QL Interpreter";

    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;

    public SwingInterpreter() {
        super(TITLE);
        createComponents();
        setSizes();
        setLayout();
        setSize(Sizes.WINDOW_WIDTH, Sizes.WINDOW_HEIGHT);
        setVisible(true);
    }

    private void setSizes() {
        this.centerPanel.setBackground(Color.green);
        this.centerPanel.setSize(Sizes.CENTER_WIDTH, Sizes.CENTER_HEIGHT);
    }

    private void createComponents() {
        this.leftPanel = new LeftPanel();
        this.centerPanel = new CenterPanel();
        this.topPanel = new TopPanel(this.getHelper());
    }

    private void setLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        addToContentPane(0, 0, 2, this.topPanel, c);
        addToContentPane(0, 1, 1, this.leftPanel, c);
        addToContentPane(1, 1, 1, this.centerPanel, c);

    }

    private void addToContentPane(int x, int y, int gridwidth, JPanel p,
            GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = y;
        c.gridwidth = gridwidth;
        getContentPane().add(p, c);
    }

    private SwingHelper getHelper() {
        return new SwingHelper(this.leftPanel, this.centerPanel);
    }

}
