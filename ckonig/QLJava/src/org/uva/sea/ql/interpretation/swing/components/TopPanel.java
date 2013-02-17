package org.uva.sea.ql.interpretation.swing.components;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 270484964302085412L;

    private final FileOpenPanel fileOpenPanel;

    public TopPanel(LeftPanel l, CenterPanel c) {
        this.setSize(Sizes.WINDOW_WIDTH, Sizes.TOP_HEIGHT);
        final JTextArea log = l.getLog();
        this.fileOpenPanel = new FileOpenPanel(log, c);
        this.add(this.fileOpenPanel);
    }
}
