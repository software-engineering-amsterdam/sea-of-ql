package org.uva.sea.ql.interpretation.swing.components;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.interpretation.swing.SwingHelper;

public class TopPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 270484964302085412L;

    private final FileOpenPanel fileOpenPanel;
    private final SaveResultPanel saveResultPanel;

    public TopPanel(SwingHelper helper) {
        this.setSize(Sizes.WINDOW_WIDTH, Sizes.TOP_HEIGHT);       
        this.fileOpenPanel = new FileOpenPanel(helper);
        this.add(this.fileOpenPanel);
        this.saveResultPanel = new SaveResultPanel(helper);
        this.add(this.saveResultPanel);
    }
}
