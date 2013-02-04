package org.uva.sea.ql.tests;

import org.uva.sea.ql.TimeSource;

import java.util.Calendar;

public class StaticTimeSource implements TimeSource {
    private Calendar calendar;
    public Calendar getDate() { return calendar; }
    public void setDate(Calendar calendar) { this.calendar = calendar; }

    @Override
    public Calendar getCurrentDate() {
        return calendar;
    }
}
