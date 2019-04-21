package bankmain;

import java.util.Date;

public class DateDifference {
    private static int yearsAdded;
    private static int monthsAdded;

    DateDifference() {
        yearsAdded = 0;
        monthsAdded = 0;
    }

    public static void addDifference(int totalMonthsToAdd) {
        int yearsToAdd = totalMonthsToAdd / 12;
        int monthsToAdd = totalMonthsToAdd - 12 * yearsToAdd;

        //Add date difference such that monthsAdded <= 12
        if (monthsAdded + monthsToAdd > 12) {
            monthsAdded += monthsToAdd - 12;
            yearsAdded += yearsToAdd + 1;
        } else {
            monthsAdded += monthsToAdd;
            yearsAdded += yearsToAdd;
        }
    }

    public static Date createDate() {
        Date tempDate = new Date();
        int currYear = tempDate.getYear();
        int currMonth = tempDate.getMonth();

        int tempMonth = currMonth + monthsAdded;
        if (tempMonth >= 12) {
            tempDate.setMonth(tempMonth - 12);
            tempDate.setYear(currYear + yearsAdded + 1);
        } else {
            tempDate.setMonth(tempMonth);
            tempDate.setYear(currYear + yearsAdded);
        }

        return tempDate;
    }

    public static int getYearsAdded() {
        return yearsAdded;
    }

    public static int getMonthsAdded() {
        return monthsAdded;
    }

    public static void setYearsAdded(int year) {
        yearsAdded = year;
    }

    public static void setMonthsAdded(int month) {
        monthsAdded = month;
    }
}