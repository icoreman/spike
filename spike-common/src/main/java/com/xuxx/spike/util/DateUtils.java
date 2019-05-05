package com.xuxx.spike.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: DateUtils
 *
 * @author xuxx
 * @date 2019-05-05 21:04:56
 * @since  JDK 1.8
 *
 */
@Slf4j
public class DateUtils {
	public static final String FORMAT_YYYY_MM_DD_HH = "yyyy_MM_dd_hh";

	public static final String getDateString_YYYY_MM_DD_HH(Date d) {
		return new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH).format(d);
	}

	public static final String getCurrentDateString_YYYY_MM_DD_HH() {
		return new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH).format(new Date());
	}

	public static final String DEFAULT_DATE_FORMAT_NUM = "yyyyMMdd";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_DATE_FORMAT_DETAIL = "yyyy-MM-dd hh:mm";
	public static final String DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat DEFAULT_DATE_FORMATER = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	public static final String DEFAULT_SHORT_DATE_FORMAT = "yy-MM-dd";
	public static final String DEFAULT_SHORT_DATE_FORMAT1 = "%s月%s日 %d:%d";
	public static final String DEFAULT_SHORT_DATE_FORMAT2 = "yyyy/MM/dd";
	public static final SimpleDateFormat DEFAULT_SHORT_DATE_FORMATER = new SimpleDateFormat(DEFAULT_SHORT_DATE_FORMAT);

	private static final long CHANGE_MATCH_TIME = 300;

	public static final String getDateString_MMddhhmmss_1(Date d) {

		Calendar gc = new GregorianCalendar();
		gc.setTime(d);

		final String str = String.format(DEFAULT_SHORT_DATE_FORMAT1, gc.get(Calendar.MONTH), gc.get(Calendar.DAY_OF_MONTH),
				gc.get(Calendar.HOUR_OF_DAY),
				gc.get(Calendar.MINUTE));

		return str;
	}

	public static final boolean isExpired(Date time, Long expireTime) {
		if (time == null) {
			return false;
		}

		long createTime = time.getTime();
		long currentTime = System.currentTimeMillis();
		long defaultExpireTime = createTime + expireTime;// 加上五天
		if (defaultExpireTime > currentTime) {
			return false;
		}

		return true;
	}

	public static final String formatDate(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(pattern).format(date);
	}

	public static final String formatDate(Date postDate) {
		if (postDate == null) {
			return null;
		}
		return DEFAULT_DATE_FORMATER.format(postDate);
	}

	public static final String formatDateDetail(Date postDate) {
		if (postDate == null) {
			return null;
		}
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT_DETAIL).format(postDate);
	}

	public static final String formatDateClient(Date postDate) {

		if (postDate == null) {
			return null;
		}
		String time = null;
		long todayTime = System.currentTimeMillis();
		long date = postDate.getTime();
		long diffTime = todayTime - date;

		long hours = diffTime / (60 * 60 * 1000);
		if (hours > 96) {
			time = DEFAULT_SHORT_DATE_FORMATER.format(postDate);
		} else if (hours >= 72) {
			time = "3天前";
		} else if (hours >= 48) {
			time = "2天前";
		} else if (hours >= 24) {
			time = "1天前";
		} else if (hours >= 1) {
			time = hours + "小时前";
		} else {
			long minutes = diffTime / (60 * 1000);
			if (minutes > 1) {
				time = minutes + "分钟前";
			} else {
				time = "1分钟前";
			}
		}
		return time;
	}

	public static final String getTimeCeilClient(Date postDate, int limitDay) {
		if (postDate == null) {
			return null;
		}
		String time = null;
		long todayTime = System.currentTimeMillis();
		long curTime = postDate.getTime();
		long diffTime = curTime + limitDay * 24 * 60 * 60 * 1000 - todayTime;

		long hours = diffTime / (60 * 60 * 1000);
		if (hours > 96) {
			time = ((hours + 23) / 24) + "天内";
		} else if (hours >= 72) {
			time = "4天内";
		} else if (hours >= 48) {
			time = "3天内";
		} else if (hours >= 24) {
			time = "2天内";
		} else if (hours / 24 >= 1) {
			time = hours / 24 + "天内";
		} else if (hours >= 1) {
			time = hours + "小时内";
		} else {
			long minutes = diffTime / (60 * 1000);
			if (minutes > 1) {
				time = minutes + "分钟内";
			} else {
				time = "1分钟内";
			}
		}
		return time;
	}

	public static final String getLeftChangeMatcherTime(Date date) {
		if (date == null) {
			return String.valueOf("0");
		}
		Date now = new Date();
		long diffTime = (now.getTime() - date.getTime()) / 1000;
		if (diffTime < 0) {
			diffTime = 0L;
		}
		long leftTime = Math.max(CHANGE_MATCH_TIME - diffTime, 0);
		return String.valueOf(leftTime);
	}

	// 昨天晚上十二点的时间
	public static Date getLastDaySeparatorTime() {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		return now.getTime();
	}

	/**
	 * 获取某一天的晚上十二点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取某一天的前一天晚上十二点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 前后N小时的时间 --24小时制
	 * 
	 * @param calendar
	 * @param days     -n:向前n小时 n:往后后n小时
	 * @return
	 */
	public static Calendar hourAddOrReduce(Calendar calendar, int hours) {
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar;
	}

	/**
	 * 前后N天的时间0点
	 * 
	 * @param calendar
	 * @param days     -n:向前n天 n:往后后n天
	 * @return
	 */
	public static Date getDayAddOrReduceSeparatorTime(Calendar calendar, int days) {
		calendar.add(Calendar.DATE, days);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param weekOffset      //n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
	 * @param calendarWeekDay 想周几，这里就传几Calendar.MONDAY（TUESDAY...）
	 * @return
	 */
	public static String getLastOrNextWeekDate(int weekOffset, int calendarWeekDay) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, weekOffset * 7);
		String weekDateString;
		cal.set(Calendar.DAY_OF_WEEK, calendarWeekDay);
		weekDateString = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return weekDateString;
	}

	public static long getLastOrNextWeekTimeMillis(int weekOffset, int calendarWeekDay) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, weekOffset * 7);
		cal.set(Calendar.DAY_OF_WEEK, calendarWeekDay);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 前后N天的时间
	 * 
	 * @param calendar
	 * @param days     -n:向前n天 n:往后后n天
	 * @return
	 */
	public static Calendar dayAddOrReduce(Calendar calendar, int days) {
		calendar.add(Calendar.DATE, days);
		return calendar;
	}

	/**
	 * 前后N个月的时间
	 * 
	 * @param calendar
	 * @param months   -n:向前n个月 n:往后后n个月
	 * @return
	 */
	public static Calendar monthAddOrReduce(Calendar calendar, int months) {
		calendar.add(Calendar.MONTH, months);
		return calendar;
	}

	/**
	 * 格式化时间
	 * 
	 * @param calendar
	 * @param formatPattern
	 * @return
	 */
	public static String getDate(Calendar calendar, String formatPattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
		return (String) dateFormat.format(calendar.getTime());
	}

	/**
	 * 格式化时间字符串
	 * 
	 * @param date
	 * @param formatPattern
	 * @return
	 */
	public static Date parseDate(String date, String formatPattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			log.error("DateUtils parseDate error ", e);
		}
		return null;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 格式化两个日期之间相差的时间
	 * 
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public static String formatDaysBetween(Date sDate, Date eDate) {
		long diffTime = sDate.getTime() - eDate.getTime();
		long hours = diffTime / (60 * 60 * 1000);
		if (hours >= 24) {
			return String.format("%1$d天多", hours / 24);
		} else {
			return String.format("%1$d分钟", (diffTime / (60 * 1000)));
		}
	}

	/**
	 * 计算两个日期之间相差的秒
	 * 
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int secondBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_FULL);
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_second = (time2 - time1) / (1000); // 共计秒数

		return Integer.parseInt(String.valueOf(between_second));
	}

	/**
	 * 
	 * getDailyExpire:(获取当前距离零点的秒数).
	 * 
	 * @author jy.hu Date:2013-11-18上午11:10:19
	 * 
	 * @return
	 */
	public static long getDailyExpire() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return (System.currentTimeMillis() - c.getTimeInMillis()) / 1000l;
	}

	public static boolean isToday(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date toDay = new Date();
		date = sdf.parse(sdf.format(date));
		toDay = sdf.parse(sdf.format(toDay));
		Calendar cal = Calendar.getInstance();
		Calendar calToDay = Calendar.getInstance();
		cal.setTime(date);
		calToDay.setTime(toDay);

		if (cal.get(Calendar.YEAR) == calToDay.get(Calendar.YEAR)
				&& cal.get(Calendar.MONTH) == calToDay.get(Calendar.MONTH)
				&& cal.get(Calendar.DAY_OF_MONTH) == calToDay.get(Calendar.DAY_OF_MONTH)) {
			return true;
		}

		return false;
	}

	public static boolean isTimeout(Date postDate) {

		long todayTime = System.currentTimeMillis();
		long date = postDate.getTime();
		long diffTime = todayTime - date;

		long hours = diffTime / (60 * 60 * 1000);

		if (hours < 48) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取每月第一天（-1=上月,0=当月,1=下月）
	 * 
	 * @author Administrator Date:2013-11-26下午5:04:48
	 * 
	 * @return
	 */
	public static String getMonthFirstDay(int month) {

		String str = "";

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, month);
		lastDate.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_DATE_FORMAT);
		str = sdf.format(lastDate.getTime());

		return str;
	}

	/**
	 * 获取每月最后一天（-1=上月,0=当月,1=下月）
	 * 
	 * @author Administrator Date:2013-11-26下午5:04:27
	 * 
	 * @return
	 */
	public static String getMonthLastDay(int month) {

		String str = "";

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, month);
		lastDate.set(Calendar.DAY_OF_MONTH, 1);
		lastDate.roll(Calendar.DAY_OF_MONTH, -1);

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_DATE_FORMAT);
		str = sdf.format(lastDate.getTime());

		return str;
	}

	/**
	 * 本月第一天
	 * 
	 * @author Administrator Date:2013-11-26下午5:04:34
	 * 
	 * @return
	 */
	public static String getCurrentMoonFirstDay() {

		String str = "";

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_DATE_FORMAT);
		str = sdf.format(lastDate.getTime());

		return str;
	}

	/**
	 * 返回当前日期的星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String dayOfWeek(Date date) {
		String week = "";
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			week = "星期日";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		case 7:
			week = "星期六";
			break;
		}
		return week;
	}

	/**
	 * 判断时间是否大于或者小于今天，精确到天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLargeToday(Date date) {

		Calendar toDay = Calendar.getInstance();
		Calendar deDay = Calendar.getInstance();
		deDay.setTime(date);
		if (deDay.get(Calendar.YEAR) <= toDay.get(Calendar.YEAR)
				&& deDay.get(Calendar.MONTH) <= toDay.get(Calendar.MONTH)
				&& deDay.get(Calendar.DATE) <= toDay.get(Calendar.DATE)) {
			return true;
		} else {
			return false;
		}

	}

	public static long getDailyTime(int interval) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, interval);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis() / 1000;
	}

	public static Date dealDate(Date d, int offset) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DAY_OF_YEAR, offset);
		Date dd = c.getTime();
		return dd;
	}

	/**
	 * 
	 * @Title: getOffsetDate 
	 * @Description: 获取日期 date 间隔 day 天的日期 
	 * @param @param date
	 * @param @param day
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getOffsetDate(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	/**
	 * 
	 * @Title: disTime 
	 * @Description: 计算两个时间的间隔
	 * @param @param beginDate
	 * @param @param endDate
	 * @return String    返回类型 
	 * @throws
	 */
	public static String disTime(Date beginDate, Date endDate) {
		long l = beginDate.getTime() - endDate.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		return day + "天" + hour + "小时" + min + "分" + s + "秒";
	}
}
