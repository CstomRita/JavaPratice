package pratice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:05 2019-06-14
 * @ Description：时间戳转换
 * @ Modified By：
 * @Version: $
 */
public class TimeStapTest {
    public static void main(String[] args) throws ParseException {
        System.out.println(stmpToDate("1560219600000"));
        System.out.println(dateToStamp("2019/06/11 10:20:00"));
    }

    /*
     * @Author: ChangSiteng
     * @Description: 时间戳转为日期格式
     * @param stmpValue:
     * @return: java.lang.String
     */
    public static String stmpToDate(String stmpValue) {
        String pattern = "yyyy/MM/dd HH:mm:ss";
        DateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date(Long.parseLong(stmpValue));
        String res = sdf.format(date);
        return res;
    }

    /*
     * @Author: ChangSiteng
     * @Description: 日期格式转换为时间戳
     * @param dateValaue:
     * @return: java.lang.String
     */
    public static String dateToStamp(String dateValaue) throws ParseException {
        String pattern = "yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(dateValaue);
        long ts = date.getTime();

        String res = String.valueOf(ts);
        return res;
    }
}
