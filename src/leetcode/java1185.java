package leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 *
 * 提示：
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//最投机取巧的方法就是利用java的日历类，有自带方法可以查看星期
    //虽然过不了leetcode，但是我就是想用api强奸题目，开心就好
public class java1185 {
  static   class Solution {
        public String dayOfTheWeek(int day, int month, int year) throws ParseException {
            String [] result ={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            String date=year+"-"+month+"-"+day;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(date);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date1);
            int res = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
            return result[res-1];
        }
    }

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(23,02,2020));

    }
}
