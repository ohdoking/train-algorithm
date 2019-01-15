package com.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeFormatterTest {
    @Test
    public void testFormatDurationExamples() {
        // Example Test Cases
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
    
    @Test
    public void testMinuteIsLast() {
    	assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }
    
    @Test
    public void testHourIsLast() {
    	assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }
    
    @Test
    public void testNow() {
    	assertEquals("now", TimeFormatter.formatDuration(0));
    }
}
