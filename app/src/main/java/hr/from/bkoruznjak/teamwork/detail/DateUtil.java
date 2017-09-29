package hr.from.bkoruznjak.teamwork.detail;

import android.content.res.Resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import hr.from.bkoruznjak.teamwork.R;

/**
 * Created by bkoruznjak on 29/09/2017.
 */

public class DateUtil {
    public static final long DAY_IN_MILLIS = 60 * 60 * 24 * 1000;
    //obviously this isn't correct but for demo purposes is good enough
    public static final long MONTH_IN_MILLIS = DAY_IN_MILLIS * 30;
    public static final long YEAR_IN_MILLIS = MONTH_IN_MILLIS * 12;

    public static final SimpleDateFormat dateParseFormat = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat monthDayFormat = new SimpleDateFormat("MMM dd");
    public static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    public static String getProjectStatusString(Resources resources, long projectEndTime) {
        String dueToFinish = "";
        long currentTimeInMillis = new Date().getTime();
        long timeDiff = projectEndTime - currentTimeInMillis;

        if (timeDiff > 0) {
            //we still have time
            if (timeDiff >= YEAR_IN_MILLIS) {
                dueToFinish = String.format(resources.getString(R.string.project_on_time), resources.getString(R.string.time_1_year));
            } else if (timeDiff < YEAR_IN_MILLIS && timeDiff >= MONTH_IN_MILLIS) {
                long timeSum = currentTimeInMillis;
                int numberOfMonths = 0;
                for (; timeSum < projectEndTime; numberOfMonths++) {
                    timeSum += MONTH_IN_MILLIS;
                }
                String months = (numberOfMonths == 1) ? resources.getString(R.string.time_month) : resources.getString(R.string.time_months);
                dueToFinish = String.format(resources.getString(R.string.project_on_time), String.valueOf(numberOfMonths).concat(months));
            } else {
                long timeSum = currentTimeInMillis;
                int numberOfDays = 0;
                for (; timeSum < projectEndTime; numberOfDays++) {
                    timeSum += DAY_IN_MILLIS;
                }
                String days = (numberOfDays == 1) ? resources.getString(R.string.time_day) : resources.getString(R.string.time_days);
                dueToFinish = String.format(resources.getString(R.string.project_on_time), String.valueOf(numberOfDays).concat(days));
            }

        } else {
            //were over due
            timeDiff = -timeDiff;
            if (timeDiff >= YEAR_IN_MILLIS) {
                dueToFinish = String.format(resources.getString(R.string.project_late), resources.getString(R.string.time_1_year));
            } else if (timeDiff < YEAR_IN_MILLIS && timeDiff >= MONTH_IN_MILLIS) {
                long timeSum = projectEndTime;
                int numberOfMonths = 0;
                for (; timeSum < currentTimeInMillis; numberOfMonths++) {
                    timeSum += MONTH_IN_MILLIS;
                }
                String months = (numberOfMonths == 1) ? resources.getString(R.string.time_month) : resources.getString(R.string.time_months);
                dueToFinish = String.format(resources.getString(R.string.project_late), String.valueOf(numberOfMonths).concat(months));
            } else {
                long timeSum = projectEndTime;
                int numberOfDays = 0;
                for (; timeSum < currentTimeInMillis; numberOfDays++) {
                    timeSum += DAY_IN_MILLIS;
                }
                String days = (numberOfDays == 1) ? resources.getString(R.string.time_day) : resources.getString(R.string.time_days);
                dueToFinish = String.format(resources.getString(R.string.project_late), String.valueOf(numberOfDays).concat(days));
            }
        }
        return dueToFinish;
    }
}
