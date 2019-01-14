package com.test;

import org.junit.platform.commons.util.StringUtils;

/**
 * 
 * @author ohdoking
 *
 *         Human readable duration format
 * 
 *         Your task in order to complete this Kata is to write a function which
 *         formats a duration, given as a number of seconds, in a human-friendly
 *         way.
 * 
 *         The function must accept a non-negative integer. If it is zero, it
 *         just returns "now". Otherwise, the duration is expressed as a
 *         combination of years, days, hours, minutes and seconds.
 * 
 *         It is much easier to understand with an example:
 * 
 *         TimeFormatter.formatDuration(62) //returns "1 minute and 2 seconds"
 *         TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2
 *         seconds" For the purpose of this Kata, a year is 365 days and a day
 *         is 24 hours.
 * 
 *         Note that spaces are important.
 * 
 *         Detailed rules The resulting expression is made of components like 4
 *         seconds, 1 year, etc. In general, a positive integer and one of the
 *         valid units of time, separated by a space. The unit of time is used
 *         in plural if the integer is greater than 1.
 * 
 *         The components are separated by a comma and a space (", "). Except
 *         the last component, which is separated by " and ", just like it would
 *         be written in English.
 * 
 *         A more significant units of time will occur before than a least
 *         significant one. Therefore, 1 second and 1 year is not correct, but 1
 *         year and 1 second is.
 * 
 *         Different components have different unit of times. So there is not
 *         repeated units like in 5 seconds and 1 second.
 * 
 *         A component will not appear at all if its value happens to be zero.
 *         Hence, 1 minute and 0 seconds is not valid, but it should be just 1
 *         minute.
 * 
 *         A unit of time must be used "as much as possible". It means that the
 *         function should not return 61 seconds, but 1 minute and 1 second
 *         instead. Formally, the duration specified by of a component must not
 *         be greater than any valid more significant unit of time.
 */
public class TimeFormatter {

	enum Date{
		YEAR(365*24*60*60),
		DAY(24*60*60),
		HOUR(60*60),
		MINUTE(60),
		SECOND(1);
		
		private int seconds;
		private int count = 0;
		
		Date(int seconds){
			this.seconds = seconds;
		}
		
		protected int getSeconds() {
			return this.seconds;
		}
		
		protected int getCount() {
			return this.count;
		}
		
		protected void setCount(int count) {
			this.count = count;
		}
		
		int getDate(int seconds) {
			setCount(seconds/getSeconds());
			if(getCount() != 0) {
				setCount(getCount());
				seconds = seconds - (getSeconds() * getCount());
			}
			return seconds;
		}
		
		String getHRFormat(String name, int seconds) {
			return getCount() + " " + name + (getCount() > 1 ? "s" : "") + (seconds != 0 ? ", " : "") ;
		}
		
		
	}
	public static String formatDuration(int seconds) {
		if(seconds == 0) {
			return "now";
		}
		StringBuffer result = new StringBuffer();
		for(Date day : Date.values()) {
			seconds = day.getDate(seconds);
			
			if(day.getCount() != 0) {
				result = result.append(day.getHRFormat(day.name().toLowerCase(),seconds));
			}
			if(seconds == 0) {
				break;
			}
			
		}
		int lastAnd = result.lastIndexOf(",");
		if(lastAnd != -1) {
			result.replace(lastAnd, lastAnd+1, " and");
		}
		System.out.println(result);
		return result.toString();
	}
}