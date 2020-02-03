package com.example.boot.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 项目名称：boot   
 * 类名称：DateUtils   
 * 类描述：时间工具 
 * 创建人：li132   
 * 创建时间：2019年4月22日 下午9:43:23   
 * 修改人：  
 * 修改时间：   
 * 修改备注： 
 * @version
 */
public class DateUtils {
	public static final String DATEFORMAT = "yyyy-MM-dd";
	public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMEFORMAT2 = "yyyy-MM-dd HH:mm";
    private static final String toYMSTR = "yyyy-MM";
	
	/**
	 * 字符串转换为Date
	 * 
	 * @param dateStr - 时间字符串
	 * @param formatType - 该字符串格式
	 **/
	public static Date strToDate(String dateStr,String formatType) {
		try {
			if(StringUtils.isBlank(dateStr))return null;
			if (StringUtils.isBlank(formatType))formatType=DATEFORMAT;
			DateFormat sdf = new SimpleDateFormat(formatType);
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Date转换为字符串
	 * 
	 * @param date - 时间
	 * @param formatType - 该字符串格式
	 **/
	public static String dateToStr(Date date,String formatType){
		if(date==null)return "";
		if (StringUtils.isBlank(formatType))formatType=DATEFORMAT;
		DateFormat sdf = new SimpleDateFormat(formatType);	
		return sdf.format(date);
	}
	
	/**
	 * 时间字符串增加天数
	 * 
	 * @param date - 时间
	 * @param addDateNum - 增加天数
	 **/
	public static Date addDate(Date date,Integer addDateNum){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date); 
		if(addDateNum==null)addDateNum=1;
		calendar.add(Calendar.DATE,addDateNum);	
		return calendar.getTime();
	}

	/**
	 * 时间字符串增加天数
	 * 
	 * @param dateStr - 时间字符串
	 * @param addDateNum - 增加天数
	 **/
	public static String addDateStr(String dateStr,Integer addDateNum){
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(strToDate(dateStr, null)); 
		if(addDateNum==null)addDateNum=1;
		calendar.add(Calendar.DATE,addDateNum);	
		return dateToStr(calendar.getTime(),null);
	}
	
	public static String getYMStr(Date date) {
    	if (date != null) {
            return new SimpleDateFormat(toYMSTR).format(date);
        } else {
            return null;
        }
    }
	public static String getYMDStr(Date date) {
    	if (date != null) {
            return new SimpleDateFormat(DATEFORMAT).format(date);
        } else {
            return null;
        }
    }
	public static String getYStr(Date date) {
    	if (date != null) {
            return new SimpleDateFormat("yyyy").format(date);
        } else {
            return null;
        }
    }
	/**
     * @param date 日期
     * @return 对应日期所在年的第一天
     */
    public static Date getFirstDayOfYear(Date date) {
        if (date != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);
            return c.getTime();
        } else {
            return date;
        }
    }
   
    public static String getCurrenYearFirstDay() {
    	Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return getYMDStr(c.getTime());
    }

	/**
	 * @param date 设定日期
	 * @param n    增加几天
	 * @return 增加n天后的日期
	 */
	public static Date addDays(Date date, int n) {
		if (date != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_YEAR, n);
			return c.getTime();
		} else {
			return date;
		}
	}

	/**
	 * @param date 设定日期
	 * @param n    增加几月
	 * @return 增加n月后的日期
	 */
	public static Date addMonths(Date date, int n) {
		if (date != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, n);
			return c.getTime();
		} else {
			return date;
		}
	}
    
    /**
     * 获取上一个月 格式为yyyy-mm
     * @return
     */
    public static String getLastMonth() {
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return DateUtils.getYMStr(m);
    }
    
    public static int compareDate(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    public static Date getStartTime(Integer year,Integer month,Integer date) {
    	if(year != null && year < 1970){
    		return null;
    	}
    	if(month != null && (month > 12 || month < 1)){
    		return null;
    	}
    	if(date != null && (date > 31 || date < 1)){
    		return null;
    	}
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	if(year != null){
    		c.set(Calendar.YEAR,year.intValue());
    	}
    	if(month != null){
    		c.set(Calendar.MONTH,month.intValue()-1);
    	}else{
    		c.set(Calendar.MONTH,0);
    	}
    	if(date != null){
    		date = Math.min(date, c.get(Calendar.DAY_OF_MONTH));
    		c.set(Calendar.DATE,date.intValue());
    	}else{
    		c.set(Calendar.DATE,1);
    	}
    	c.set(Calendar.HOUR_OF_DAY,0);
    	c.set(Calendar.MINUTE,0);
    	c.set(Calendar.SECOND,0);
    	
    	return c.getTime();
    }
    
    public static Date getEndTime(Integer year,Integer month,Integer date) {
    	if(year != null && year < 1970){
    		return null;
    	}
    	if(month != null && (month > 12 || month < 1)){
    		return null;
    	}
    	if(date != null && (date > 31 || date < 1)){
    		return null;
    	}
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	if(year != null){
    		c.set(Calendar.YEAR,year.intValue());
    	}
      	if(month != null){
    		c.set(Calendar.MONTH,month.intValue()-1);
    	}else{
    		c.set(Calendar.MONTH,11);
    	}
    	if(date != null){
    		date = Math.min(date, c.get(Calendar.DAY_OF_MONTH));
    		c.set(Calendar.DATE,date.intValue());
    	}else{
    		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
    	}
    	c.set(Calendar.HOUR_OF_DAY,23);
    	c.set(Calendar.MINUTE,59);
    	c.set(Calendar.SECOND,59);
    	
    	return c.getTime();
    }
}
