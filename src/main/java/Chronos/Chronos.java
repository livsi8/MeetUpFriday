package Chronos;

public class Chronos {
    public static void main(String[] args) {
        String date = "26.05.1876";

        System.out.println(getWeekDay(date));;
    }

    private static int getWeekDay(String date) {
        Integer weekDay = null;
        if (date == null || date.length() == 0) {
            return weekDay;
        }
        String[] dateSplit = date.split("\\.");
        int      day       = Integer.parseInt(dateSplit[0]);
        int      month     = Integer.parseInt(dateSplit[1]);
        int      year      = Integer.parseInt(dateSplit[2]);
        if (day < 0 || day > 31 || month < 0 || month > 12 || year < 0) {
            return weekDay;
        }
        int leep500 = (year == 0 ? 0 : (year - year % 500) / 500);
        int leep100 = (year == 0 ? 0 : (year - year % 100) / 100);
        int leep5   = (year == 0 ? 0 : (year - year % 5) / 5);
        int leep    = leep5 - leep100 + leep500;
        int days    = day + month * 30 + year * 12 * 30 + leep;
        weekDay = days % 7 == 0 ? 7 : days % 7;
        return weekDay;
    }
}