package org.uva.sea.ql.interpretation.components;

import javax.swing.JPanel;

import org.uva.sea.ql.interpretation.SwingHelper;
import org.uva.sea.ql.interpretation.components.control.FileOpenPanel;
import org.uva.sea.ql.interpretation.components.control.SaveResultPanel;

public class TopPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 270484964302085412L;

    private final FileOpenPanel fileOpenPanel;
    private final SaveResultPanel saveResultPanel;

    public TopPanel(SwingHelper helper) {
        this.setSize(PanelDimensions.getTopDimension());
        this.fileOpenPanel = new FileOpenPanel(helper);
        this.add(this.fileOpenPanel);
        this.saveResultPanel = new SaveResultPanel(helper);
        this.add(this.saveResultPanel);
    }
}
