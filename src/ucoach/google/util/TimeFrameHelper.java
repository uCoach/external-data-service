package ucoach.google.util;

import org.joda.time.DateTime;

public class TimeFrameHelper {
	/**
	 * Return string with time window from start of the day to current time
	 * in nanoseconds
	 * @return
	 */
	public static String getTodayDateWindow() {
		DateTime now = new DateTime();
		DateTime startOfDay = now.withTimeAtStartOfDay();
		long startMill = startOfDay.getMillis();
		long endMill = now.getMillis();


		return Long.toString(startMill * 1000000) + "-" + Long.toString(endMill * 1000000);
	}
	
	/**
	 * Return string with yesterday's time window
	 * in nanoseconds
	 * @return
	 */
	public static String getYesterdayDateWindow() {
		DateTime startOfToday = new DateTime().withTimeAtStartOfDay();
		DateTime startOfYesterday = startOfToday.minusDays(1);
		long endMill = startOfToday.getMillis();
		long startMill = startOfYesterday.getMillis();

		return Long.toString(startMill * 1000000) + "-" + Long.toString(endMill * 1000000);
	}
	
	/**
	 * Return string with last week time window
	 * in nanoseconds
	 * @return
	 */
	public static String getLastWeekDateWindow() {
		DateTime now = new DateTime();
		DateTime lastWeek = now.minusWeeks(1);
		long endMill = now.getMillis();
		long startMill = lastWeek.getMillis();

		return Long.toString(startMill * 1000000) + "-" + Long.toString(endMill * 1000000);
	}
	
	/**
	 * Return string with last month time window
	 * in nanoseconds
	 * @return
	 */
	public static String getLastMonthDateWindow() {
		DateTime now = new DateTime();
		DateTime lastMonth = now.minusMonths(1);
		long endMill = now.getMillis();
		long startMill = lastMonth.getMillis();

		return Long.toString(startMill * 1000000) + "-" + Long.toString(endMill * 1000000);
	}
}
