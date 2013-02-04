package org.uva.sea.ql.tests.valuePersister.destinations.fileDestination;

import org.junit.Test;
import org.uva.sea.ql.tests.StaticTimeSource;
import org.uva.sea.ql.valuePersister.persisters.filePersister.NamingConvention;
import org.uva.sea.ql.valuePersister.persisters.filePersister.TimestampNamingConvention;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;

public class TimestampNamingConventionTests {

    private final StaticTimeSource timeSource = new StaticTimeSource();
    private final NamingConvention namingConvention = new TimestampNamingConvention(timeSource);

    @Test
    public void getNameCalled_returnsCurrentTimestamp() {
        // Note that month is zero based, so 00 is actually 01
        timeSource.setDate(new GregorianCalendar(2000, 00, 02, 03, 04, 05));
        String expected = "20000102030405000";
        assertEquals(expected, namingConvention.getName());
    }

}
