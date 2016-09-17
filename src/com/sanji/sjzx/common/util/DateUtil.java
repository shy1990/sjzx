/**  
* @Title: DateUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-21 下午3:06:18
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 日期工具�?月末、周末等的日期操�?
 * @ClassName: DateUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-21 下午3:06:18
 */
public class DateUtil {


    /**
     * 取得某天相加(�?後的那一�?
    * @Title: getAnotherDate
    * @Description: TODO(取得某天相加(�?後的那一�?
    * @param @param date
    * @param @param num
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getAnotherDate(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, num);
        return c.getTime();
    }

    /**
     * 取得某月的的�?���?��
    * @Title: getLastDayOfMonth
    * @Description: TODO(取得某月的的�?���?��)
    * @param @param year
    * @param @param month
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);// �?
        cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是�?�?��，所以要�?
        cal.set(Calendar.DATE, 1);// 日，设为�?��
        cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一�?
        cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一�?
        return cal.getTime();// 获得月末是几�?
    }

    /**
     * 取得某天是一年中的多少周
    * @Title: getWeekOfYear
    * @Description: TODO(取得某天是一年中的多少周)
    * @param @param date
    * @param @return    设定文件
    * @return int    返回类型
    * @author ZhouZhangbao
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得某天�?��周的第一�?
    * @Title: getFirstDayOfWeek
    * @Description: TODO(这里用一句话描述这个方法的作�?
    * @param @param date
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    /**
     * 取得某天�?��周的�?���?��
    * @Title: getLastDayOfWeek
    * @Description: TODO(得某天所在周的最后一�?
    * @param @param date
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    /**
     * 取得某一年共有多少周
    * @Title: getMaxWeekNumOfYear
    * @Description: TODO(取得某一年共有多少周)
    * @param @param year
    * @param @return    设定文件
    * @return int    返回类型
    * @author ZhouZhangbao
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }
    /**
     * 获取某一年某�?��的日�?
    * @Title: getWeekDays
    * @Description: TODO(获取某一年某�?��的日�?
    * @param @param year
    * @param @param week
    * @param @return    设定文件
    * @return List<String>    返回类型
    * @author ZhouZhangbao
     */
    public static List<String> getWeekDays(int year,int week){
    	List<String> list = new ArrayList<String>();
    	
        Date date =  getFirstDayOfWeek(year,week);
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
     
        for (int i = 0; i < 7; i++) {
			list.add(d.format(date));
			System.out.println(d.format(date));
		
			date.setDate(date.getDate()+1);
		}
    	return list;
    }
    
    /**
     * 取得某年某周的第�?�� 对于交叉:2008-12-29�?009-01-04属于2008年的�?���?��,2009-01-05�?009年第�?��的第�?��
    * @Title: getFirstDayOfWeek
    * @Description: TODO(取得某年某周的第�?�� )
    * @param @param year
    * @param @param week
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar calFirst = Calendar.getInstance();
        calFirst.set(year, 0, 7);
        Date firstDate = getFirstDayOfWeek(calFirst.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        firstDate = getFirstDayOfWeek(cal.getTime());

        return firstDate;
    }

    /**
     * 取得某年某周的最后一�?对于交叉:2008-12-29�?009-01-04属于2008年的�?���?��, 2009-01-04�?
     * 2008年最后一周的�?���?��
    * @Title: getLastDayOfWeek
    * @Description: TODO(取得某年某周的最后一�?
    * @param @param year
    * @param @param week
    * @param @return    设定文件
    * @return Date    返回类型
    * @author ZhouZhangbao
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar calLast = Calendar.getInstance();
        calLast.set(year, 0, 7);
        Date firstDate = getLastDayOfWeek(calLast.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        Date lastDate = getLastDayOfWeek(cal.getTime());

        return lastDate;
    }

    /**
     * 获取当前日期的年、月、日
    * @Title: display
    * @Description: TODO(获取当前日期的年、月、日)
    * @param     设定文件
    * @return void    返回类型
    * @author ZhouZhangbao
     */
    public void display() {
        Calendar cal = Calendar.getInstance();
        // �?
        int year = cal.get(cal.YEAR);
        // �?
        int month = cal.get(cal.MONTH) + 1;
        // �?
        int date = cal.get(cal.DATE);
        // 星期
        int today = cal.get(cal.DAY_OF_WEEK) - 1;
    }
    
    /**
	 * 将Date 转换成Long
	* @Title: getLongByDate
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param date
	* @param @return    设定文件
	* @return Long    返回类型
	* @author ZhouZhangbao
	 */
	public static Long getLongByDate(Date date) {
		if (date == null) {
			return null;
		}
		Long lSysTime = date.getTime() / 1000; // 得到秒数，Date类型的getTime()返回毫秒�?
		return lSysTime;
	}
	
	/**
	 * 验证两个日期的时间差是否大于限定的时间，<br>大于返回false;否则返回true
	* @Title: isCheckExpires
	* @Description: TODO(验证两个日期的时间差是否大于限定的时�?
	* @param @param sendDate
	* @param @param milliseconds
	* @param @return    大于返回false;否则返回true
	* @return boolean    返回类型
	* @author ZhouZhangbao
	 */
	public static boolean isCheckExpires(Date sendDate, Long milliseconds) {
		Long timeDifference = getLongByDate(new Date())
				- getLongByDate(sendDate);// 获得时间�?�?
		if (timeDifference > milliseconds) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Date类型的转换成标准格式(String类型)
	* @Title: getStringByDate
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param date
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getStringByDate(Date date) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(date);
		} else {
			return null;
		}

	}
	
	/**
	 * 获取上月第一天的日期 （格式为�?014-06-01 �?
	* @Title: previousMonthFirstDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String previousMonthFirstDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取上月第一�?String) 格式为：2014-06-01 00:00:00
	* @Title: previousMonFirstDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String previousMonFirstDay() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String months = "";
		if (month > 1) {
			month--;
		} else {
			year--;
			month = 12;
		}
		if (!(String.valueOf(month).length() > 1)) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		if (!(String.valueOf(day).length() > 1)) {
		} else {
		}
		String firstDay = "" + year + "-" + months + "-01";
		String[] lastMonth = new String[2];
		lastMonth[0] = firstDay;
		return firstDay + " 00:00:00";
	}

	/**
	 * 获取当月第一�?返回字符�?
	* @Title: currentMonFirstDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String currentMonFirstDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获得上月�?���?��的日�?
	* @Title: PreviousMonthLastDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String PreviousMonthLastDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一�?
		lastDate.roll(Calendar.DATE, -1);// 日期回滚�?��，也就是本月�?���?��
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取当月�?���?��,返回字符�?
	* @Title: currentMonLastDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String currentMonLastDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1�?
		lastDate.add(Calendar.DATE, -1);// 减去�?��，变为当月最后一�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取N天前的时�?（返回格式String类型 2012-08-27 00:00:00�?br>
	 * 使用方法：n 表示查询天数，例�?今天时间�?n=0;昨天n=1;近一周n=7；取值的�?�?��时间
	 *               map.get("startTime")；截止时间map.get("endTime")
	* @Title: getNearestTime
	* @Description: TODO(获取N天前的时�?（返回格式String类型 2012-08-27 00:00:00�?
	* @param @param n
	* @param @return    设定文件
	* @return Map<String,String>    返回类型
	* @author ZhouZhangbao
	 */
	public static Map<String, String> getNearestTime(Integer n) {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		Calendar cale = Calendar.getInstance();
		cal.add(Calendar.DATE, -n);
		if (n == 0) {
			cale.add(Calendar.DATE, -0);
		} else {
			cale.add(Calendar.DATE, -1);
		}

		Date s = cal.getTime();
		Date e = cale.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		map.put("startTime", sp.format(s) + " 00:00:00");// �?��时间
		map.put("endTime", sp.format(e) + " 23:59:59");// 截止时间
		return map;
	}
	
	/**
	 * 获取N天时间段的时�?（返回格式String类型 2012-08-27 00:00:00�?br>
	 * 使用方法：n 表示查询天数，例�?今天时间�?n=0;昨天n=1;近一周n=7；取值的�?�?��时间
	 *               map.get("startTime")；截止时间map.get("endTime")
	* @Title: getSectionTimeStr
	* @Description: TODO(获取N天时间段的时�?（返回格式String类型 2012-08-27 00:00:00�?
	* @param @param n
	* @param @return    设定文件
	* @return Map<String,String>    返回类型
	* @author ZhouZhangbao
	 */
	public static Map<String, String> getSectionTimeStr(Integer n) {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		Calendar cale = Calendar.getInstance();
		cal.add(Calendar.DATE, -n);
		if (n == 0) {
			cale.add(Calendar.DATE, -0);
		} else {
			cale.add(Calendar.DATE, -1);
		}

		Date s = cal.getTime();
		Date e = cale.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		map.put("startTime", sp.format(s) + " 00:00:00");// �?��时间
		map.put("endTime", sp.format(e) + " 23:59:59");// 截止时间
		return map;
	}
	
	/**
	 * 获取N天时间段的时�?（返回格式Long类型 �?br>
	 * 使用方法：n 表示查询天数，例�?今天时间�?n=0;昨天n=1;近一周n=7；取值的�?�?��时间
	 *               map.get("startTime")；截止时间map.get("endTime")
	* @Title: getSectionTimeLong
	* @Description: TODO(获取N天时间段的时�?（返回格式Long类型 �?
	* @param @param n
	* @param @return    设定文件
	* @return Map<String,Long>    返回类型
	* @author ZhouZhangbao
	 */
	public static Map<String, Long> getSectionTimeLong(Integer n) {
		Map<String, Long> map = new HashMap<String, Long>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, String> mapstr = getSectionTimeStr(n);
			Date startTime = sdf.parse(mapstr.get("startTime"));// 获取�?��时间
			Date endTime = sdf.parse(mapstr.get("endTime"));// 获取截止时间
			map.put("startTime", getLongByDate(startTime));
			map.put("endTime", getLongByDate(endTime));
		} catch (ParseException e) {
			System.err.println("获取时间段出现问�?");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 获取当月第一�?返回字符�?
	* @Title: getFirstDayOfMonth
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取当月第一�?返回Date类型
	* @Title: getFirstDayOfMonth_1
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return Date    返回类型
	* @author ZhouZhangbao
	 */
	public static Date getFirstDayOfMonth_1() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		return lastDate.getTime();
	}

	/**
	 * 获取当月�?���?��,返回字符�?
	* @Title: getDefaultDay
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1�?
		lastDate.add(Calendar.DATE, -1);// 减去�?��，变为当月最后一�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取当月�?���?��,返回Date
	* @Title: getDefaultDay_1
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return Date    返回类型
	* @author ZhouZhangbao
	 */
	public static Date getDefaultDay_1() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1�?
		lastDate.add(Calendar.DATE, -1);// 减去�?��，变为当月最后一�?
		return lastDate.getTime();
	}

	/**
	 * 获取上月第一天的日期(String)
	* @Title: getPreviousMonthFirst
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1�?
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取上月第一天的日期(Date)
	* @Title: getPreviousMonthFirst_Date
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return Date    返回类型
	* @author ZhouZhangbao
	 */
	public static Date getPreviousMonthFirst_Date() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1�?
		return lastDate.getTime();
	}

	/**
	 * 将字符串日期时间转换成Long类型的毫�?
	* @Title: getDateStrToLong
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param str
	* @param @return    设定文件
	* @return Long    返回类型
	* @author ZhouZhangbao
	 */
	public static Long getDateStrToLong(String str) {
		Long lSysTime1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = sdf.parse(str);
			lSysTime1 = date1.getTime() / 1000; // 得到秒数，Date类型的getTime()返回毫秒�?
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lSysTime1;
	}

	/**
	 * 将字符串日期时间转换成Date类型
	* @Title: getDateStrToDate
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param str
	* @param @return    设定文件
	* @return Date    返回类型
	* @author ZhouZhangbao
	 */
	public static Date getDateStrToDate(String str) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 两个日期相减得出天数或月份或年份
	* @Title: compareDate
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param date1 日期1
	* @param @param date2 日期2
	* @param @param stype 获得类型(0：天数，1：月份，2：年�?
	* @param @return    设定文件
	* @return Long    返回类型
	* @author ZhouZhangbao
	 */
	public static Long compareDate(String date1,String date2,int stype){ 
        Long n = 0L;  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        try {  
            c1.setTime(df.parse(date1));  
            c2.setTime(df.parse(date2));  
        } catch (Exception e3) {  
            System.out.println("wrong occured");  
        }  
        while (!c1.after(c2)) {    
            n++;  
            if(stype==0){
            	c1.add(Calendar.DATE, 1); // 比较天数，日�?1
            }  else if (stype==1){ 
            	c1.add(Calendar.MONTH, 1);// 比较月份，月�?1  
            }  else if(stype==2){
            	c1.add(Calendar.YEAR, 1);// 比较年份，年�?1
            }
        }  
        n = n-1;       
        return n;  
    }	
  
}
