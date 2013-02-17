package org.uva.sea.ql;

public class TimeSourceFactory {
    public static TimeSource createTimeSource() {
        return new CurrentTimeSource();
    }
}
