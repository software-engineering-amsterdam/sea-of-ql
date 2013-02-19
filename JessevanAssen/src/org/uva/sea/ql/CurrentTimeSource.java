package org.uva.sea.ql;

import java.util.Calendar;
import java.util.GregorianCalendar;

class CurrentTimeSource implements TimeSource {
    @Override
    public Calendar getCurrentDate() {
        return new GregorianCalendar();
    }
}
