package org.uva.sea.ql.interpretation.swing.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.interpretation.swing.SwingHelper;

public class SaveResultPanel extends JPanel {

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
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
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
                            helper.pushLog("store input to c:/input.txt");
                        } catch (FileNotFoundException e) {
                            helper.pushLog(e.getMessage());
                        }
                    } else {
                        helper.pushLog("cannot save invalid input");
                    }
                } else {
                    helper.pushLog("no form loaded");
                }
            }
        });
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
