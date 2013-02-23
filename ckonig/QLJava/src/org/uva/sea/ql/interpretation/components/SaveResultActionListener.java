package org.uva.sea.ql.interpretation.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Map;

import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.interpretation.SwingHelper;

public class SaveResultActionListener implements ActionListener {
    private SwingHelper helper;

    public SaveResultActionListener(SwingHelper h){
        this.helper = h;
        
    }
    @Override
    public final void actionPerformed(ActionEvent arg0) {
        if (loaded()) {
            if (isValidInput()) {
                final Map<String, Object> input = getInput();
                final StringBuilder output = new StringBuilder();
                for (Map.Entry<String, Object> entry : input.entrySet()) {
                    output.append(entry.getKey() + ";"
                            + entry.getValue().toString() + " \r\n");
                }
                try {
                    IOHelper.write("c:/input.txt", output.toString());
                    this.helper.pushLog("store input to c:/input.txt");
                } catch (FileNotFoundException e) {
                    this.helper.pushLog(e.getMessage());
                }
            } else {
                this.helper.pushLog("cannot save invalid input");
            }
        } else {
            this.helper.pushLog("no form loaded");
        }
    }
    private boolean isValidInput() {
        return this.helper.getRegistry().isValid();
    }

    private boolean loaded() {
        return this.helper != null && this.helper.getRegistry() != null;
    }

    private Map<String, Object> getInput() {
        return this.helper.getRegistry().getInput();
    }
}
