package main.canil.utils;

import main.canil.enums.DayType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    public Boolean isValidFormatDate(String date) {
        try {
            toLocaldate(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public LocalDate toLocaldate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public DayType getWeekdayOrWeekend(LocalDate localDate) {
        switch (localDate.getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return DayType.WEEKEND;
            default:
                return DayType.WEEKDAY;
        }
    }

}
