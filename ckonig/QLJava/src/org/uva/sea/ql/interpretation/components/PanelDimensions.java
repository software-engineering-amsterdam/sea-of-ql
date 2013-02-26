package org.uva.sea.ql.interpretation.components;

import java.awt.Dimension;
import java.awt.Font;

public final class PanelDimensions {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int TOP_HEIGHT = 100;
    private static final int LEFT_WIDTH = 200;
    private static final int CENTER_WIDTH = 400;
    private static final int CENTER_HEIGHT = 400;
    private static final int HEADING_FONT_SIZE = 20;

    private PanelDimensions() {

    }

    public static Dimension getWindowDimension() {
        return new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT);
    }

    public static Dimension getTopDimension() {
        return new Dimension(WINDOW_WIDTH,TOP_HEIGHT);
    }

    public static Dimension getLeftDimension() {
        return new Dimension(LEFT_WIDTH,CENTER_HEIGHT);
    }

    public static Dimension getContentDimension() {
        return new Dimension(CENTER_WIDTH,CENTER_HEIGHT);
    }

    public static Font getFont() {
        return new Font("Times New Roman", 0, HEADING_FONT_SIZE);
    }
}
