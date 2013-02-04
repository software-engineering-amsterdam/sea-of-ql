package org.uva.sea.ql.valuePersister.persisters.filePersister;

import org.uva.sea.ql.TimeSource;

public class TimestampNamingConvention implements NamingConvention {

    private final TimeSource timeSource;

    public TimestampNamingConvention(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public String getName() {
        return String.format(
                "%1$tY" + "%1$tm" + "%1$td" + "%1$tH" + "%1$tM" + "%1$tS" + "%1$tL",
                timeSource.getCurrentDate()
        );
    }
}
