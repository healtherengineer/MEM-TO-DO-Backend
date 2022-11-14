package dev.mem.memtodo.utilities.converters;

import java.time.LocalDateTime;

public class DateConverter {
    public static LocalDateTime stringToDateFormat(String date) {
        return LocalDateTime.parse(date.substring(0,date.length()-1));
    }
}
